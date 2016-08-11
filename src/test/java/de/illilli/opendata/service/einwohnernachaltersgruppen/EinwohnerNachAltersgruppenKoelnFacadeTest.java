package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.einwohnernachaltersgruppen.bo.EinwohnerNachAltersgruppenKoeln;
import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.CsvParser;
import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.EinwohnerNachAltersgruppenKoelnCsvParser;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.LoadData;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.LoadDataFromFile;

public class EinwohnerNachAltersgruppenKoelnFacadeTest extends
		EinwohnerNachAltersgruppenFacade<EinwohnerNachAltersgruppenKoeln> {

	private final static int year = 2012;

	@Test
	public void testGetJson() throws URISyntaxException {
		Facade test = new EinwohnerNachAltersgruppenKoelnFacadeTest();
		Assert.assertTrue(test.getJson().contains("koelnGesamt"));
	}

	public EinwohnerNachAltersgruppenKoelnFacadeTest()
			throws URISyntaxException {
		super(year);
	}

	@Override
	LoadData<EinwohnerNachAltersgruppenKoeln> getLoadData(int year)
			throws URISyntaxException {
		return new LoadDataFromFile<EinwohnerNachAltersgruppenKoeln>(
				getURI(year), getCsvParser());
	}

	@Override
	URI getURI(int year) throws URISyntaxException {
		URL url = this.getClass().getClassLoader()
				.getResource(year + "_Altersgruppen_Insgesamt.csv");
		return url.toURI();
	}

	@Override
	CsvParser<EinwohnerNachAltersgruppenKoeln> getCsvParser() {
		return new EinwohnerNachAltersgruppenKoelnCsvParser();
	}

}
