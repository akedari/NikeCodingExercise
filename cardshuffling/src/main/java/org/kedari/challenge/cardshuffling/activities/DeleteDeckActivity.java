package org.kedari.challenge.cardshuffling.activities;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kedari.challenge.cardshuffling.cache.Cache;
import org.kedari.challenge.cardshuffling.exception.DataNotFoundException;
import org.kedari.challenge.cardshuffling.exception.NameNotProvidedException;
import org.kedari.challenge.cardshuffling.model.Deck;

@Path("/decks")
public class DeleteDeckActivity {
    
    /**
     * Method handling HTTP DELETE requests. The returned object will be sent
     * to the client as "application/json" media type. 
     * Method take input as path param
     *
     * name input parameter as path param
     * @return object that will be returned as a application/json response.
     */
    
    
    /**
     * removeDeck() remove a one new Deck to the memory, with title as parameter passed "name"
     * @return : Successfully remove operation will return recently deleted Deck in "application/json"
     *          else will return appropriate error message in "application/json" with status code.
     */
    
	@DELETE
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Deck removeDeck(@PathParam("name") String name) throws NameNotProvidedException, DataNotFoundException {
	    
	    if(name == null || name.isEmpty()) {
            throw new NameNotProvidedException("Name can not be null or empty");
        }
	    
	    // Removing requested Deck from list
		Deck removedDeck = Cache.remove(name);
		
		if(removedDeck == null) {
            throw new DataNotFoundException("Deck with name "+ name + " not found");
        }
        return removedDeck;
		
	}
	
	
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Deck removeDeckNotName(@PathParam("name") String name) throws NameNotProvidedException {
        
	    throw new NameNotProvidedException("Name can not be null or empty");
    }
	
}
