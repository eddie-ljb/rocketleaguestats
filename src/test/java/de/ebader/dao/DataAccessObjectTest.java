package de.ebader.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;

class DataAccessObjectTest {

	@Test
	void testAPIConnection() {
		DataAccessObject dao = new APIAccess();
		JsonNode jsonNode = dao.getJsonNode();
		
		assertEquals(false, jsonNode.isNull());
	}

}
