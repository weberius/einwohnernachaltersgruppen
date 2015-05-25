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

import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.CsvParser;

public class LoadDataFromHttpRequest<T> extends LoadData<T> {

	private static final Logger logger = Logger
			.getLogger(LoadDataFromHttpRequest.class);

	private HttpClient httpClient;

	public LoadDataFromHttpRequest(URI uri, CsvParser<T> csvParser) {
		this.uri = uri;
		this.csvParser = csvParser;

		try {
			super.load();
		} catch (ClientProtocolException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}

	@Override
	void init() {
		httpClient = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(uri);
		getRequest.addHeader("accept", "application/json");
		HttpResponse response;
		try {
			response = httpClient.execute(getRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			InputStream src = response.getEntity().getContent();
			fileFound = (src != null);

			if (!fileFound) {
				return;
			}

			br = new BufferedReader(new InputStreamReader(src, UTF_8));

		} catch (ClientProtocolException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}

	}

}
