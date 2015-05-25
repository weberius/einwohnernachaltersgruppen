package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.CsvParser;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.AskForEinwohnerNachAltersgruppen;

/**
 * read data from http://www.offenedaten-koeln.de/sites/default/files/
 * 2012_Altersgruppen_Insgesamt.csv
 * 
 * @author wolfram
 *
 */
public abstract class EinwohnerNachAltersgruppenFacade<T> implements Facade {

	/**
	 * http://www.offenedaten-koeln.de/sites/default/files/
	 * 2012_Altersgruppen_Stadtbezirk.csv
	 */
	public static final String OFFENE_DATEN_KOELN_URL = "http://www.offenedaten-koeln.de/sites/default/files/";

	URI uri;
	String json;

	public EinwohnerNachAltersgruppenFacade(int year, String csvFileName,
			CsvParser<T> parser) throws URISyntaxException {
		String urlString = OFFENE_DATEN_KOELN_URL + year + csvFileName;
		uri = new URI(urlString);

		AskForEinwohnerNachAltersgruppen<T> askFor = new AskForEinwohnerNachAltersgruppen<T>(
				uri, parser);
		List<T> list = askFor.getList();
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		json = gson.toJson(list);
	}

	@Override
	public String getJson() {
		return json;
	}

}
