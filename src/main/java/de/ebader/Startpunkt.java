package de.ebader;

import de.ebader.controller.MainController;
import de.ebader.controller.MainControlling;
import de.ebader.dao.APIAccess;
import de.ebader.dao.DataAccessObject;
import de.ebader.persistence.JsonParserAPI;
import de.ebader.persistence.JsonPersistence;
import de.ebader.view.MainViewer;
import de.ebader.view.MainViewing;

public class Startpunkt {
	
	public static void main(String[] args) {
		MainControlling controller = new MainController();
		MainViewing view = new MainViewer();
		DataAccessObject dao = new APIAccess();
		JsonPersistence jsonParser = new JsonParserAPI();
		
		controller.starteProgramm(view, dao, jsonParser);
	}

}
