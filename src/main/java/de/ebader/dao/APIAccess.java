package de.ebader.dao;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class APIAccess implements DataAccessObject {
	
	public URI url;
    public HttpClient httpClient;
    public HttpRequest request;
    public ObjectMapper objectmapper;
    public static JsonNode jsonNode;
    
    public APIAccess() {
        this.httpClient = HttpClient.newBuilder().connectTimeout(java.time.Duration.ofSeconds(10)).build();
        this.request = HttpRequest.newBuilder()
        		.uri(URI.create("https://rocket-league1.p.rapidapi.com/"))
        		.header("User-Agent", "GameTracker")
        		.header("Accept-Encoding", "identity")
        		.header("X-RapidAPI-Key", "2d8b36e0ebmshad64b5a7f19fa1cp109fc9jsne99b9c970cc0")
        		.header("X-RapidAPI-Host", "rocket-league1.p.rapidapi.com")
        		.method("GET", HttpRequest.BodyPublishers.noBody())
        		.build();
        this.objectmapper = new ObjectMapper();

        if (this.jsonNode == null) {
            try {
                this.jsonNode = baueResponseAuf();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private JsonNode baueResponseAuf() throws IOException, InterruptedException, JsonProcessingException, JsonMappingException {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            // Hier könntest du auch den Response Body oder andere Informationen
            // ausgeben
            String responseBody = response.body();
            jsonNode = objectmapper.readTree(responseBody);
            return jsonNode;
    }
    
    @Override
    public JsonNode getJsonNode() {
    	return this.jsonNode;
    }
    	
}


