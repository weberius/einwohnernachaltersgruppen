package de.illilli.opendata.service.einwohnernachaltersgruppen.csv;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import de.illilli.opendata.service.einwohnernachaltersgruppen.bo.EinwohnerNachAltersgruppenStadtbezirk;

public class EinwohnerNachAltersgruppenStadtbezirkCsvParser
		extends
		EinwohnerNachAltersgruppenCsvParser<EinwohnerNachAltersgruppenStadtbezirk> {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger
			.getLogger(EinwohnerNachAltersgruppenStadtbezirkCsvParser.class);

	final CsvSchema SIMPLE_SCHEMA = CsvSchema.builder() //
			.addColumn("nr") //
			.addColumn("stadtbezirk") //
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

	public EinwohnerNachAltersgruppenStadtbezirkCsvParser() {

		objectReader = mapper.reader(SIMPLE_SCHEMA);
		objectReader = objectReader
				.withType(EinwohnerNachAltersgruppenStadtbezirk.class);
	}

}
