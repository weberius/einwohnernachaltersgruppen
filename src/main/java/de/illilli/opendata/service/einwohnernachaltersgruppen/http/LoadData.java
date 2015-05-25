package de.illilli.opendata.service.einwohnernachaltersgruppen.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.CsvParser;

public abstract class LoadData<T> {

	static final String UTF_8 = "UTF-8";
	StringBuilder lineBuilder = new StringBuilder();
	List<T> objectList = new ArrayList<T>();
	boolean fileFound = false;
	BufferedReader br;
	CsvParser<T> csvParser;
	URI uri;
	String line;

	void load() throws JsonProcessingException, UnsupportedEncodingException,
			IOException {

		init();

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

	abstract void init();

}
