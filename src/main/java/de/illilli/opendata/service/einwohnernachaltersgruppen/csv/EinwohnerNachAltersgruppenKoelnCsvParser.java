package de.illilli.opendata.service.einwohnernachaltersgruppen.csv;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import de.illilli.opendata.service.einwohnernachaltersgruppen.bo.EinwohnerNachAltersgruppenKoeln;

public class EinwohnerNachAltersgruppenKoelnCsvParser extends
		EinwohnerNachAltersgruppenCsvParser<EinwohnerNachAltersgruppenKoeln> {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger
			.getLogger(EinwohnerNachAltersgruppenKoelnCsvParser.class);

	final CsvSchema SIMPLE_SCHEMA = CsvSchema.builder() //
			.addColumn("koelnGesamt") //
			.addColumn("einwohnerInsgesamt") //
			.addColumn("a0_2") //
			.addColumn("a3_5") //
			.addColumn("a6_14") //
			.addColumn("a15_17") //
			.addColumn("a18_20") //
			.addColumn("a21_34") //
			.addColumn("a35_59") //
			.addColumn("a60_64") //
			.addColumn("a65_74") //
			.addColumn("a75_79") //
			.addColumn("a80undAelter") //
			.build();

	public EinwohnerNachAltersgruppenKoelnCsvParser() {

		ObjectMapper mapper = new CsvMapper();
		objectReader = mapper.reader(SIMPLE_SCHEMA);
		objectReader = objectReader
				.withType(EinwohnerNachAltersgruppenKoeln.class);
	}

}
