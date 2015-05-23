package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.illilli.opendata.service.einwohnernachaltersgruppen.bo.EinwohnerNachAltersgruppenKoeln;
import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.EinwohnerNachAltersgruppenKoelnCsvParser;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.AskForEinwohnerNachAltersgruppen;

/**
 * read data from http://www.offenedaten-koeln.de/sites/default/files/
 * 2012_Altersgruppen_Insgesamt.csv
 * 
 */
public class EinwohnerNachAltersgruppenInsgesamtFacade implements Facade {

	public static final String OFFENE_DATEN_KOELN_URL = "http://www.offenedaten-koeln.de/sites/default/files/";

	URI uri;
	String json;

	public EinwohnerNachAltersgruppenInsgesamtFacade(int year)
			throws URISyntaxException {
		String urlString = OFFENE_DATEN_KOELN_URL + year
				+ "_Altersgruppen_Insgesamt.csv";
		uri = new URI(urlString);

		AskForEinwohnerNachAltersgruppen<EinwohnerNachAltersgruppenKoeln> askFor = new AskForEinwohnerNachAltersgruppen<EinwohnerNachAltersgruppenKoeln>(
				uri, new EinwohnerNachAltersgruppenKoelnCsvParser());
		List<EinwohnerNachAltersgruppenKoeln> list = askFor.getList();
		for (EinwohnerNachAltersgruppenKoeln enag : list) {
			System.out.println(enag.toString());
		}
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		json = gson.toJson(list);
	}

	@Override
	public String getJson() {
		return json;
	}

}
