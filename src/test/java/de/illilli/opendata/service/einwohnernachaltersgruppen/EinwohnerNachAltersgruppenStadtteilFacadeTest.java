package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import de.illilli.opendata.service.einwohnernachaltersgruppen.bo.EinwohnerNachAltersgruppenStadtteil;
import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.CsvParser;
import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.EinwohnerNachAltersgruppenStadtteilCsvParser;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.LoadData;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.LoadDataFromFile;

public class EinwohnerNachAltersgruppenStadtteilFacadeTest extends
		EinwohnerNachAltersgruppenFacade<EinwohnerNachAltersgruppenStadtteil> {

	private final static int year = 2012;

	@Test
	public void testGetJson() throws URISyntaxException {
		Facade test = new EinwohnerNachAltersgruppenStadtteilFacadeTest();
		Assert.assertTrue(test.getJson().contains("stadtteil"));
	}

	public EinwohnerNachAltersgruppenStadtteilFacadeTest()
			throws URISyntaxException {
		super(year);
	}

	@Override
	LoadData<EinwohnerNachAltersgruppenStadtteil> getLoadData(int year)
			throws URISyntaxException {
		return new LoadDataFromFile<EinwohnerNachAltersgruppenStadtteil>(
				getURI(year), getCsvParser());
	}

	@Override
	URI getURI(int year) throws URISyntaxException {
		URL url = this.getClass().getClassLoader()
				.getResource(year + "_Altersgruppen_Stadtbezirk.csv");
		return url.toURI();
	}

	@Override
	CsvParser<EinwohnerNachAltersgruppenStadtteil> getCsvParser() {
		return new EinwohnerNachAltersgruppenStadtteilCsvParser();
	}

}
