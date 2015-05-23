package de.illilli.opendata.service.einwohnernachaltersgruppen.http;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.CsvParser;

public class AskForEinwohnerNachAltersgruppen<T> {

	private static final Logger logger = Logger
			.getLogger(AskForEinwohnerNachAltersgruppen.class);

	private List<T> einwohnerList;

	/**
	 * <p>
	 * Need the uri for request and a csvParser to know how the data is
	 * structured.
	 * </p>
	 * <p>
	 * Use like this:
	 * 
	 * <pre>
	 * AskForEinwohnerNachAltersgruppen askFor = new AskForEinwohnerNachAltersgruppen(
	 * 		&quot;http://&lt;server&gt;/&lt;path&gt;&quot;, new EinwohnerNachAltersgruppenCsvParser());
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param uri
	 * @param csvParser
	 */
	public AskForEinwohnerNachAltersgruppen(URI uri, CsvParser<T> csvParser) {

		einwohnerList = new ArrayList<T>();
		LoadDataFromHttpRequest<T> loadCSVDataFromResource = new LoadDataFromHttpRequest<T>(
				uri, csvParser);
		einwohnerList = loadCSVDataFromResource.getObjectList();
		logger.debug("Data read from '" + uri.getPath() + "'");

	}

	public List<T> getList() {
		return einwohnerList;
	}

}
