package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.net.URI;
import java.net.URISyntaxException;

import de.illilli.opendata.service.einwohnernachaltersgruppen.bo.EinwohnerNachAltersgruppenKoeln;
import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.CsvParser;
import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.EinwohnerNachAltersgruppenKoelnCsvParser;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.LoadData;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.LoadDataFromHttpRequest;

/**
 * read data from http://www.offenedaten-koeln.de/sites/default/files/
 * 2012_Altersgruppen_Insgesamt.csv
 * 
 */
public class EinwohnerNachAltersgruppenKoelnFacade extends
		EinwohnerNachAltersgruppenFacade<EinwohnerNachAltersgruppenKoeln> {

	public EinwohnerNachAltersgruppenKoelnFacade(int year)
			throws URISyntaxException {
		super(year);
	}

	@Override
	LoadData<EinwohnerNachAltersgruppenKoeln> getLoadData(int year)
			throws URISyntaxException {
		return new LoadDataFromHttpRequest<EinwohnerNachAltersgruppenKoeln>(
				getURI(year), getCsvParser());
	}

	@Override
	URI getURI(int year) throws URISyntaxException {
		return new URI(OFFENE_DATEN_KOELN_URL + year
				+ "_Altersgruppen_Insgesamt.csv");
	}

	@Override
	CsvParser<EinwohnerNachAltersgruppenKoeln> getCsvParser() {
		return new EinwohnerNachAltersgruppenKoelnCsvParser();
	}

}
