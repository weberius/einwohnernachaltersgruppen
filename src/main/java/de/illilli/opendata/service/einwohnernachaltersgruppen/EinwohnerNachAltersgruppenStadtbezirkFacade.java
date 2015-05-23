package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.net.URISyntaxException;

/**
 * read data from http://www.offenedaten-koeln.de/sites/default/files/
 * 2012_Altersgruppen_Stadtbezirk.csv
 *
 */
public class EinwohnerNachAltersgruppenStadtbezirkFacade extends
		EinwohnerNachAltersgruppenFacade {

	public EinwohnerNachAltersgruppenStadtbezirkFacade(int year)
			throws URISyntaxException {
		super(year, "_Altersgruppen_Stadtbezirk.csv");
	}

}
