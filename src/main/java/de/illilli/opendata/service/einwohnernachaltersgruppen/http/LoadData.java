package de.illilli.opendata.service.einwohnernachaltersgruppen.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.CsvParser;

public abstract class LoadData<T> {

	private static final Logger logger = Logger.getLogger(LoadData.class);
	static final String UTF_8 = "UTF-8";
	StringBuilder lineBuilder = new StringBuilder();
	List<T> objectList = new ArrayList<T>();
	boolean fileFound = false;
	BufferedReader br;
	CsvParser<T> csvParser;
	URI uri;
	String line;

	public LoadData(URI uri, CsvParser<T> csvParser) {
		this.uri = uri;
		this.csvParser = csvParser;

		init();

		try {
			load();
		} catch (JsonProcessingException e) {
			logger.error(e);
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
	}

	void load() throws JsonProcessingException, UnsupportedEncodingException,
			IOException {

		boolean firstLine = true;
		while ((line = br.readLine()) != null) {
			if (!firstLine) {
				lineBuilder.append("\n");
				lineBuilder.append(line);
				T myTinyObject = csvParser.getObject(line);
				objectList.add(myTinyObject);
			} else {
				lineBuilder.append(line);
			}
			firstLine = false;
		}
		br.close();
	}

	public boolean isFileFound() {
		return fileFound;
	}

	public List<T> getObjectList() {
		return objectList;
	}

	/**
	 * initializes BufferedReader.
	 */
	abstract void init();

}
