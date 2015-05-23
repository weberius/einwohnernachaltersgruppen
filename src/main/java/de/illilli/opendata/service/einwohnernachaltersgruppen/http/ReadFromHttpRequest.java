package de.illilli.opendata.service.einwohnernachaltersgruppen.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

public class ReadFromHttpRequest {

	private static final Logger logger = Logger
			.getLogger(LoadDataFromHttpRequest.class);

	private StringBuilder lineBuilder = new StringBuilder();
	private boolean fileFound = false;
	private BufferedReader br;
	private int statusCode;
	HttpClient httpClient = HttpClientBuilder.create().build();

	public ReadFromHttpRequest(URI uri) {

		try {
			HttpGet getRequest = new HttpGet(uri);
			getRequest.addHeader("accept", "application/json");
			HttpResponse response = httpClient.execute(getRequest);
			statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ statusCode);
			}

			InputStream src = response.getEntity().getContent();
			fileFound = (src != null);

			if (!fileFound) {
				return;
			}

			br = new BufferedReader(new InputStreamReader(src, "UTF-8"));

			String line;
			while ((line = br.readLine()) != null) {
				lineBuilder.append(line);
			}
			br.close();
		} catch (ClientProtocolException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}

	public boolean isFileFound() {
		return fileFound;
	}

	public String getContent() {
		return lineBuilder.toString();
	}

	public int getStatusCode() {
		return statusCode;
	}

}
