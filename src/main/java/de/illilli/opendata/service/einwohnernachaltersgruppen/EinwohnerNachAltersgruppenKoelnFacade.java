package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import com.google.gson.Gson;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.einwohnernachaltersgruppen.bo.EinwohnerNachAltersgruppenKoeln;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.AskForEinwohnerNachAltersgruppenKoeln;

/**
 * read data from http://www.offenedaten-koeln.de/sites/default/files/
 * 2012_Altersgruppen_Insgesamt.csv
 * 
 */
public class EinwohnerNachAltersgruppenKoelnFacade implements Facade {

	private List<EinwohnerNachAltersgruppenKoeln> einwohnerList;

	public EinwohnerNachAltersgruppenKoelnFacade(int year)
			throws URISyntaxException, MalformedURLException, IOException {
		AskFor<List<EinwohnerNachAltersgruppenKoeln>> askFor = new AskForEinwohnerNachAltersgruppenKoeln(year);
		einwohnerList = askFor.getData();
	}

	@Override
	public String getJson() {
		Gson gson = new Gson();
		return gson.toJson(einwohnerList);
	}
}
