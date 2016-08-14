package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import com.google.gson.Gson;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.einwohnernachaltersgruppen.bo.EinwohnerNachAltersgruppenStadtbezirk;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.AskForEinwohnerNachAltersgruppenStadtbezirk;

/**
 * read data from http://www.offenedaten-koeln.de/sites/default/files/
 * 2012_Altersgruppen_Stadtbezirk.csv
 *
 */
public class EinwohnerNachAltersgruppenStadtbezirkFacade implements Facade {

	private List<EinwohnerNachAltersgruppenStadtbezirk> einwohnerList;

	public EinwohnerNachAltersgruppenStadtbezirkFacade(int year)
			throws URISyntaxException, MalformedURLException, IOException {
		AskFor<List<EinwohnerNachAltersgruppenStadtbezirk>> askFor = new AskForEinwohnerNachAltersgruppenStadtbezirk(
				year);
		einwohnerList = askFor.getData();
	}

	@Override
	public String getJson() {
		Gson gson = new Gson();
		return gson.toJson(einwohnerList);
	}

}
