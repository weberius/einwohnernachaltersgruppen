package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opendata.service.Facade;

/**
 * <p>
 * This service reads the csv Data for <a href=
 * "http://www.offenedaten-koeln.de/dataset/einwohner-nach-altersgruppen" >
 * Einwohner Nach Altersgruppen</a> from www.offenedaten-koeln.de and returns a
 * json representation ().
 * </p>
 *
 */
@Path("/service")
public class Service {

	private static final Logger logger = Logger.getLogger(Service.class);

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;

	/**
	 * <p>
	 * <a href=
	 * "http://localhost:8080/einwohnernachaltersgruppen/service/insgesamt/2012">
	 * Einwohner in K&ouml;ln gesamt</a>
	 * </p>
	 * <p>
	 * This Service returns data for whole cologne by year.
	 * </p>
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/insgesamt/{year}")
	public String getByYear(@PathParam("year") int year)
			throws JsonParseException, JsonMappingException, IOException, URISyntaxException {
		// setze das Character-Encoding fuer die Antwort auf UTF-8
		response.setCharacterEncoding("UTF-8");

		Facade facade = new EinwohnerNachAltersgruppenKoelnFacade(year);
		String json = facade.getJson();

		return json;
	}

	/**
	 * <p>
	 * <p>
	 * <a href=
	 * "http://localhost:8080/einwohnernachaltersgruppen/service/stadtbezirk/2012"
	 * >Einwohner in K&ouml;n je Stadtbezirk</a>
	 * </p>
	 * </p>
	 * http://www.offenedaten-koeln.de/sites/default/files/
	 * 2012_Altersgruppen_Stadtbezirk.csv
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/stadtbezirk/{year}")
	public String getStadtbezirkByJahr(@PathParam("year") int year)
			throws JsonParseException, JsonMappingException, IOException, URISyntaxException {
		// setze das Character-Encoding fuer die Antwort auf UTF-8
		response.setCharacterEncoding("UTF-8");

		Facade facade = new EinwohnerNachAltersgruppenStadtbezirkFacade(year);
		String json = facade.getJson();
		logger.debug("json: " + json);
		return json;
	}

	/**
	 * <p>
	 * <a href=
	 * "http://localhost:8080/einwohnernachaltersgruppen/service/stadtteil/2012"
	 * >Einwohner nach Altersgruppen je Stadtteil</a>
	 * </p>
	 * <p>
	 * <a href=
	 * "http://www.offenedaten-koeln.de/sites/default/files/2012_Altersgruppen_Stadtteil.csv"
	 * >Offene Daten K&ouml;ln Altergruppen Stadtteil csv</a>
	 * </p>
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/stadtteil/{year}")
	public String getStadtteilByJahr(@PathParam("year") int year)
			throws JsonParseException, JsonMappingException, IOException, URISyntaxException {
		// setze das Character-Encoding fuer die Antwort auf UTF-8
		response.setCharacterEncoding("UTF-8");

		Facade facade = new EinwohnerNachAltersgruppenStadtteilFacade(year);
		String json = facade.getJson();
		logger.debug("json: " + json);
		return json;
	}

}
