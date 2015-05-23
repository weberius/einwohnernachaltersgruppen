package de.illilli.opendata.service.einwohnernachaltersgruppen;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * <p>
 * This service reads the csv Data for <a
 * href="http://www.offenedaten-koeln.de/dataset/einwohner-nach-altersgruppen"
 * >Einwohner Nach Altersgruppen</a> from www.offenedaten-koeln.de and returns a
 * json representation ().
 * </p>
 *
 */
@Path("/service")
public class Service {

	private static final Logger logger = Logger.getLogger(Service.class);
	public static final String ALTERSGRUPPEN_STADTTEIL_URL = "http://www.offenedaten-koeln.de/sites/default/files/2012_Altersgruppen_Stadtteil.csv";

	/**
	 * <p>
	 * http://localhost:8080/einwohnernachaltersgruppen/service/2012
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
	@Path("/{year}")
	public String getByYear(@PathParam("year") int year)
			throws JsonParseException, JsonMappingException, IOException,
			URISyntaxException {
		System.out.println("#########");
		Facade facade = new EinwohnerNachAltersgruppenInsgesamtFacade(year);
		String json = facade.getJson();
		System.out.println("json: " + json);
		System.out.println("#########");
		logger.debug("json: " + json);
		return json;
	}

	/**
	 * <p>
	 * <p>
	 * http://localhost:8080/einwohnernachaltersgruppen/service/2012/stadtbezirk
	 * </p>
	 * </p> http://www.offenedaten-koeln.de/sites/default/files/
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
	@Path("/{year}/stadtbezirk")
	public String getStadtbezirkByJahr(@PathParam("year") int year)
			throws JsonParseException, JsonMappingException, IOException,
			URISyntaxException {
		Facade facade = new EinwohnerNachAltersgruppenStadtbezirkFacade(year);
		String json = facade.getJson();
		logger.debug("json: " + json);
		return json;
	}

	/**
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
	@Path("/{year}/stadtbezirk/{nr}")
	public String getStadtbezirkByJahrAndNumber(@PathParam("year") int year,
			@PathParam("nr") int nr) throws JsonParseException,
			JsonMappingException, IOException, URISyntaxException {
		Facade facade = new EinwohnerNachAltersgruppenInsgesamtFacade(year);
		String json = facade.getJson();
		logger.debug("json: " + json);
		return json;
	}

	/**
	 * http://www.offenedaten-koeln.de/sites/default/files/
	 * 2012_Altersgruppen_Stadtteil.csv
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{year}/stadtteil")
	public String getStadtteilByJahr(@PathParam("year") int year)
			throws JsonParseException, JsonMappingException, IOException,
			URISyntaxException {
		Facade facade = new EinwohnerNachAltersgruppenInsgesamtFacade(year);
		String json = facade.getJson();
		logger.debug("json: " + json);
		return json;
	}

	/**
	 * http://www.offenedaten-koeln.de/sites/default/files/
	 * 2012_Altersgruppen_Stadtteil.csv
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{year}/stadtteil/{nr}")
	public String getStadtteilByJahrAndNumber(@PathParam("year") int year,
			@PathParam("nr") int nr) throws JsonParseException,
			JsonMappingException, IOException, URISyntaxException {
		Facade facade = new EinwohnerNachAltersgruppenInsgesamtFacade(year);
		String json = facade.getJson();
		logger.debug("json: " + json);
		return json;
	}

}
