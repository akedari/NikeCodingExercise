package org.kedari.challenge.cardshuffling.activities;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kedari.challenge.cardshuffling.cache.Cache;
import org.kedari.challenge.cardshuffling.model.Deck;


@Path("/decks")
public class GetAllDecksActivity {
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" media type. 
     *
     * @return object that will be returned as a application/json response.
     */
    
    
    /**
     * getAllDecks() returns all the Decks present in the Memory
     * @return : Successfully getAllDecks() operation will return all Deck(s) in "application/json format"
     *          else will return empty list.
     */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Deck> getAllDecks() {
	    
		ArrayList<Deck> allDecks = new ArrayList<Deck>(Cache.getDecks().values());
		return allDecks;
	}
}
