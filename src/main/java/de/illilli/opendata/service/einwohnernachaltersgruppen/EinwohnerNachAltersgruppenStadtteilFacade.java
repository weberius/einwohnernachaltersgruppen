package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import com.google.gson.Gson;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.einwohnernachaltersgruppen.bo.EinwohnerNachAltersgruppenStadtteil;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.AskForEinwohnerNachAltersgruppenStadtteil;

/**
 * read data from http://www.offenedaten-koeln.de/sites/default/files/
 * 2012_Altersgruppen_Stadtteil.csv
 */
public class EinwohnerNachAltersgruppenStadtteilFacade implements Facade {

	private List<EinwohnerNachAltersgruppenStadtteil> einwohnerList;

	public EinwohnerNachAltersgruppenStadtteilFacade(int year)
			throws URISyntaxException, MalformedURLException, IOException {
		AskFor<List<EinwohnerNachAltersgruppenStadtteil>> askFor = new AskForEinwohnerNachAltersgruppenStadtteil(year);
		einwohnerList = askFor.getData();
	}

	@Override
	public String getJson() {
		Gson gson = new Gson();
		return gson.toJson(einwohnerList);
	}
}
