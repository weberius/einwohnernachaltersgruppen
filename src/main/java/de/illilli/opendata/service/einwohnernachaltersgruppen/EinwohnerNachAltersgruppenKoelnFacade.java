package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.net.URISyntaxException;

import de.illilli.opendata.service.einwohnernachaltersgruppen.bo.EinwohnerNachAltersgruppenKoeln;
import de.illilli.opendata.service.einwohnernachaltersgruppen.csv.EinwohnerNachAltersgruppenKoelnCsvParser;

/**
 * read data from http://www.offenedaten-koeln.de/sites/default/files/
 * 2012_Altersgruppen_Insgesamt.csv
 * 
 */
public class EinwohnerNachAltersgruppenKoelnFacade extends
		EinwohnerNachAltersgruppenFacade<EinwohnerNachAltersgruppenKoeln> {

	public EinwohnerNachAltersgruppenKoelnFacade(int year)
			throws URISyntaxException {
		super(year, "_Altersgruppen_Insgesamt.csv",
				new EinwohnerNachAltersgruppenKoelnCsvParser());
	}

}
