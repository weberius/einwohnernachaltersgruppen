package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.CsvParser;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.AskForEinwohnerNachAltersgruppen;
import de.illilli.opendata.service.einwohnernachaltersgruppen.http.LoadData;

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

	String json;

	public EinwohnerNachAltersgruppenFacade(int year) throws URISyntaxException {

		LoadData<T> loadData = getLoadData(year);
		AskForEinwohnerNachAltersgruppen<T> askFor = new AskForEinwohnerNachAltersgruppen<T>(
				loadData);
		List<T> list = askFor.getList();
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		json = gson.toJson(list);
	}

	abstract LoadData<T> getLoadData(int year) throws URISyntaxException;

	abstract URI getURI(int year) throws URISyntaxException;

	abstract CsvParser<T> getCsvParser();

	@Override
	public String getJson() {
		return json;
	}

}
