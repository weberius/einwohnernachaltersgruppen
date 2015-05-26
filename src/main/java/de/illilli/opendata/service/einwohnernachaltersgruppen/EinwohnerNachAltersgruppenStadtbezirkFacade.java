package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.net.URI;
import java.net.URISyntaxException;

import de.illilli.opendata.service.einwohnernachaltersgruppen.bo.EinwohnerNachAltersgruppenStadtbezirk;
import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.CsvParser;
import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.EinwohnerNachAltersgruppenStadtbezirkCsvParser;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.LoadData;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.LoadDataFromHttpRequest;

/**
 * read data from http://www.offenedaten-koeln.de/sites/default/files/
 * 2012_Altersgruppen_Stadtbezirk.csv
 *
 */
public class EinwohnerNachAltersgruppenStadtbezirkFacade extends
		EinwohnerNachAltersgruppenFacade<EinwohnerNachAltersgruppenStadtbezirk> {

	public EinwohnerNachAltersgruppenStadtbezirkFacade(int year)
			throws URISyntaxException {
		super(year);
	}

	@Override
	LoadData<EinwohnerNachAltersgruppenStadtbezirk> getLoadData(int year)
			throws URISyntaxException {
		return new LoadDataFromHttpRequest<EinwohnerNachAltersgruppenStadtbezirk>(
				getURI(year), getCsvParser());
	}

	@Override
	URI getURI(int year) throws URISyntaxException {
		return new URI(OFFENE_DATEN_KOELN_URL + year
				+ "_Altersgruppen_Stadtbezirk.csv");
	}

	@Override
	CsvParser<EinwohnerNachAltersgruppenStadtbezirk> getCsvParser() {
		return new EinwohnerNachAltersgruppenStadtbezirkCsvParser();
	}

}
