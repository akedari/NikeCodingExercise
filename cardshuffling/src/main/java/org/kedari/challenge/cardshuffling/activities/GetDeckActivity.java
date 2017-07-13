package org.kedari.challenge.cardshuffling.activities;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kedari.challenge.cardshuffling.cache.Cache;
import org.kedari.challenge.cardshuffling.exception.DataNotFoundException;
import org.kedari.challenge.cardshuffling.exception.NameNotProvidedException;
import org.kedari.challenge.cardshuffling.model.Deck;


@Path("/decks")
public class GetDeckActivity {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" media type. 
     * Method take input as name for Deck in "text/plain" format
     *
     * @return object that will be returned as a application/json response.
     */
    
    
    /**
     * getDeck() return a Deck present in the Memory
     * @return : Successfully getDeck() operation will return a Deck in "application/json format"
     *          else will return DataNotFoundException Exception error message in "application/json" format.
     */
    
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Deck getDeck(@PathParam("name") String name) throws NameNotProvidedException, DataNotFoundException {
	    
	    //If name is not provided will throw NameNotProvidedException Exception
	    if (name == null || name.isEmpty()) {
            throw new NameNotProvidedException("Name can not be null or empty");
        }
	    
		Deck deck = Cache.getDecks().get(name);
		
		
		// If No Deck with "name" provided is present, then it is throwing DataNotFoundException
		if(deck == null) {
		    throw new DataNotFoundException("Deck with name "+ name + " not found");
		}
		return deck;
	}
}
