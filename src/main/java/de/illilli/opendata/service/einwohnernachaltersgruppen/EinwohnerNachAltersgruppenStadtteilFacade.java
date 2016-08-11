package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.net.URI;
import java.net.URISyntaxException;

import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.einwohnernachaltersgruppen.bo.EinwohnerNachAltersgruppenStadtteil;
import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.CsvParser;
import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.EinwohnerNachAltersgruppenStadtteilCsvParser;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.LoadData;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.LoadDataFromHttpRequest;

/**
 * read data from http://www.offenedaten-koeln.de/sites/default/files/
 * 2012_Altersgruppen_Stadtteil.csv
 */
public class EinwohnerNachAltersgruppenStadtteilFacade
		extends EinwohnerNachAltersgruppenFacade<EinwohnerNachAltersgruppenStadtteil> {

	public EinwohnerNachAltersgruppenStadtteilFacade(int year) throws URISyntaxException {
		super(year);
	}

	@Override
	LoadData<EinwohnerNachAltersgruppenStadtteil> getLoadData(int year) throws URISyntaxException {
		return new LoadDataFromHttpRequest<EinwohnerNachAltersgruppenStadtteil>(getURI(year), getCsvParser());
	}

	@Override
	URI getURI(int year) throws URISyntaxException {
		String uriString = Config.getProperty("offenedaten.koeln.url") + year
				+ Config.getProperty("offenedaten.koeln.altersgruppen.stadtteil");
		return new URI(uriString);
	}

	@Override
	CsvParser<EinwohnerNachAltersgruppenStadtteil> getCsvParser() {
		return new EinwohnerNachAltersgruppenStadtteilCsvParser();
	}

}
