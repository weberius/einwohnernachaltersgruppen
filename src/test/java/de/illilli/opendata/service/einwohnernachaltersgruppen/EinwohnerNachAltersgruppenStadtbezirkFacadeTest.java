package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.einwohnernachaltersgruppen.bo.EinwohnerNachAltersgruppenStadtbezirk;
import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.CsvParser;
import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.EinwohnerNachAltersgruppenStadtbezirkCsvParser;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.LoadData;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.LoadDataFromFile;

public class EinwohnerNachAltersgruppenStadtbezirkFacadeTest extends
		EinwohnerNachAltersgruppenFacade<EinwohnerNachAltersgruppenStadtbezirk> {

	private final static int year = 2012;

	@Test
	public void testGetJson() throws URISyntaxException {
		Facade test = new EinwohnerNachAltersgruppenStadtbezirkFacadeTest();
		Assert.assertTrue(test.getJson().contains("stadtbezirk"));
	}

	public EinwohnerNachAltersgruppenStadtbezirkFacadeTest()
			throws URISyntaxException {
		super(year);
	}

	@Override
	LoadData<EinwohnerNachAltersgruppenStadtbezirk> getLoadData(int year)
			throws URISyntaxException {
		return new LoadDataFromFile<EinwohnerNachAltersgruppenStadtbezirk>(
				getURI(year), getCsvParser());
	}

	@Override
	URI getURI(int year) throws URISyntaxException {
		URL url = this.getClass().getClassLoader()
				.getResource(year + "_Altersgruppen_Stadtbezirk.csv");
		return url.toURI();
	}

	@Override
	CsvParser<EinwohnerNachAltersgruppenStadtbezirk> getCsvParser() {
		return new EinwohnerNachAltersgruppenStadtbezirkCsvParser();
	}

}
