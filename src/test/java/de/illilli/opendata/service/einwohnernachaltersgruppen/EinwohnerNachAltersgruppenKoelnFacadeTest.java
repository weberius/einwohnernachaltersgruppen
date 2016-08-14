package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import de.illilli.opendata.service.Facade;

public class EinwohnerNachAltersgruppenKoelnFacadeTest {

	private final static int year = 2012;

	@Test
	public void testGetJson() throws URISyntaxException, MalformedURLException, IOException {
		Facade test = new EinwohnerNachAltersgruppenKoelnFacade(year);
		Assert.assertTrue(test.getJson().contains("koelnGesamt"));
	}

}
