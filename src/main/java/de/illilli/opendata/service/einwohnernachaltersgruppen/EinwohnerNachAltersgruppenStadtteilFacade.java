package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.net.URISyntaxException;

import de.illilli.opendata.service.einwohnernachaltersgruppen.bo.EinwohnerNachAltersgruppenStadtteil;
import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.EinwohnerNachAltersgruppenStadtteilCsvParser;

/**
 * read data from http://www.offenedaten-koeln.de/sites/default/files/
 * 2012_Altersgruppen_Stadtteil.csv
 */
public class EinwohnerNachAltersgruppenStadtteilFacade extends
		EinwohnerNachAltersgruppenFacade<EinwohnerNachAltersgruppenStadtteil> {

	public EinwohnerNachAltersgruppenStadtteilFacade(int year)
			throws URISyntaxException {
		super(year, "_Altersgruppen_Stadtteil.csv",
				new EinwohnerNachAltersgruppenStadtteilCsvParser());
	}
}
