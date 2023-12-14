package de.ebader.controller;

import de.ebader.dao.DataAccessObject;
import de.ebader.persistence.JsonPersistence;
import de.ebader.view.MainViewing;

public interface MainControlling {
	/**
	 * Startet Programm durch den Main-Controller
	 * @param view
	 * @param dao
	 * @param jsonParser
	 */
	public void starteProgramm(MainViewing view, DataAccessObject dao, JsonPersistence jsonParser);

}
