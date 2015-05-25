package de.illilli.opendata.service.einwohnernachaltersgruppen.csv;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;

public abstract class EinwohnerNachAltersgruppenCsvParser<T> implements
		CsvParser<T> {

	ObjectReader objectReader;
	ObjectMapper mapper = new CsvMapper();

	@Override
	public T getObject(String line) throws JsonProcessingException,
			UnsupportedEncodingException, IOException {
		return objectReader.readValue(line.getBytes("UTF-8"));
	}

}
