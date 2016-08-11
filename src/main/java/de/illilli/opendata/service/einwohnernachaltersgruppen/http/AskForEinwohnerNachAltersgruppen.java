package de.illilli.opendata.service.einwohnernachaltersgruppen.http;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class AskForEinwohnerNachAltersgruppen<T> {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(AskForEinwohnerNachAltersgruppen.class);

	private List<T> einwohnerList = new ArrayList<T>();

	public AskForEinwohnerNachAltersgruppen(LoadData<T> loadCSVData) {
		einwohnerList = loadCSVData.getObjectList();
	}

	public List<T> getList() {
		return einwohnerList;
	}

}
