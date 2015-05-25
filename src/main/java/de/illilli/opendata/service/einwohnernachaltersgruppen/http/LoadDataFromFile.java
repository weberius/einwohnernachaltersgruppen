package de.illilli.opendata.service.einwohnernachaltersgruppen.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.CsvParser;

public class LoadDataFromFile<T> extends LoadData<T> {

	private static final Logger logger = Logger
			.getLogger(LoadDataFromFile.class);

	public LoadDataFromFile(URI uri, CsvParser<T> csvParser) {
		this.uri = uri;
		this.csvParser = csvParser;

		try {
			load();
		} catch (FileNotFoundException e) {
			logger.error("File not found", e);
		} catch (JsonProcessingException e) {
			logger.error("Json Processing Error", e);
		} catch (UnsupportedEncodingException e) {
			logger.error("Encoding not supported", e);
		} catch (IOException e) {
			logger.error(e);
		}
	}

	@Override
	void init() {
		File file = new File(uri);
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		logger.debug("read from " + file.getAbsolutePath());

	}

}
