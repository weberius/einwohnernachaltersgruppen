package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.net.URISyntaxException;

/**
 * read data from http://www.offenedaten-koeln.de/sites/default/files/
 * 2012_Altersgruppen_Stadtteil.csv
 */
public class EinwohnerNachAltersgruppenStadtteilFacade extends
		EinwohnerNachAltersgruppenFacade {

	public EinwohnerNachAltersgruppenStadtteilFacade(int year)
			throws URISyntaxException {
		super(year, "_Altersgruppen_Stadtteil.csv");
	}
}
