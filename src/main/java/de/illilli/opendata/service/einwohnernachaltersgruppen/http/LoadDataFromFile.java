package de.illilli.opendata.service.einwohnernachaltersgruppen.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URI;

import org.apache.log4j.Logger;

import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.CsvParser;

public class LoadDataFromFile<T> extends LoadData<T> {

	private static final Logger logger = Logger
			.getLogger(LoadDataFromFile.class);

	public LoadDataFromFile(URI uri, CsvParser<T> csvParser) {
		super(uri, csvParser);
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
