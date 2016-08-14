package de.illilli.opendata.service.einwohnernachaltersgruppen.http;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.AskForCsv;
import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.einwohnernachaltersgruppen.bo.EinwohnerNachAltersgruppenKoeln;

public class AskForEinwohnerNachAltersgruppenKoeln extends AskForCsv<EinwohnerNachAltersgruppenKoeln>
		implements AskFor<List<EinwohnerNachAltersgruppenKoeln>> {

	private int year;

	String url = Config.getProperty("offenedaten.koeln.url");
	String postfix = Config.getProperty("offenedaten.koeln.altersgruppen.insgesamt");

	private final CsvSchema simpleSchema = CsvSchema.builder() //
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
			.build().withHeader();

	public AskForEinwohnerNachAltersgruppenKoeln(int year) throws MalformedURLException, IOException {
		super();
		this.year = year;
		this.clazz = EinwohnerNachAltersgruppenKoeln.class;
		mapData(getUrl(), getObjectReader(simpleSchema, clazz));
	}

	@Override
	protected URL getUrl() throws MalformedURLException {
		return new URL(url + "" + year + "" + postfix);
	}

}
