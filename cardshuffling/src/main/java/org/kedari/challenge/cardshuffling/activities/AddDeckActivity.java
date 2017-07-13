package org.kedari.challenge.cardshuffling.activities;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.kedari.challenge.cardshuffling.cache.Cache;
import org.kedari.challenge.cardshuffling.exception.DataNotFoundException;
import org.kedari.challenge.cardshuffling.exception.NameConflictException;
import org.kedari.challenge.cardshuffling.exception.NameNotProvidedException;
import org.kedari.challenge.cardshuffling.model.Deck;

@Path("/decks")
public class AddDeckActivity {
    
    /**
     * Method handling HTTP PUT requests. The returned object will be sent
     * to the client as "application/json" media type. 
     * Method take input as "text/plain" media type
     *
     * name input parameter is "text/plain"
     * @return object that will be returned as a application/json response.
     */
    
    
    /**
     * addDeck() adds a one new Deck to the memory, with title as parameter passed "name"
     * @return : Successfully added operation will return newly added Deck
     *          else will return appropriate error message in "application/json" with status code.
     */

	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addDeck(String name) throws NameNotProvidedException {

		if(name == null || name.isEmpty()) {
            throw new NameNotProvidedException("Name can not be null or empty");
        }
		
		//check if Deck with same is already present, if yes return the error message to select different name
		if(isDeckPresent(name)) {
		    throw new NameConflictException("Deck with smae name is already exists, Please choose different name");
		}
		else{
		    //Adding newly requested Deck (with pre-defined sorting ordering) in to memory
		    Deck newDeck = Cache.add(name, new Deck(name));
		    
		    return Response.status(Status.CREATED)
		            .entity(newDeck)
		            .build();
		}
		
	}

	// Check for duplicate name of decks
    private boolean isDeckPresent(String name) {
        Deck deck = Cache.getDecks().get(name);
        return (deck == null) ? false : true;
        
    }

}
