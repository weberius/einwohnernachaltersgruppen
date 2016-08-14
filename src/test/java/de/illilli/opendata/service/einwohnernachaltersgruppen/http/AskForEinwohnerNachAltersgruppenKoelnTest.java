package de.illilli.opendata.service.einwohnernachaltersgruppen.http;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.einwohnernachaltersgruppen.bo.EinwohnerNachAltersgruppenKoeln;

public class AskForEinwohnerNachAltersgruppenKoelnTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetData() throws MalformedURLException, IOException {
		int year = 2012;
		AskFor<List<EinwohnerNachAltersgruppenKoeln>> askFor = new AskForEinwohnerNachAltersgruppenKoeln(year);
		List<EinwohnerNachAltersgruppenKoeln> list = askFor.getData();
		System.out.println(list.size());
	}

}
