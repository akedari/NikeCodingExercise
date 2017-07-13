package org.kedari.challenge.cardshuffling.activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kedari.challenge.cardshuffling.cache.Cache;
import org.kedari.challenge.cardshuffling.exception.ConfigFileNotFoundException;
import org.kedari.challenge.cardshuffling.exception.DataNotFoundException;
import org.kedari.challenge.cardshuffling.exception.InvalidStrategyException;
import org.kedari.challenge.cardshuffling.exception.NameNotProvidedException;
import org.kedari.challenge.cardshuffling.model.Deck;
import org.kedari.challenge.cardshuffling.util.HandShuffling;
import org.kedari.challenge.cardshuffling.util.RandomShuffling;
import org.kedari.challenge.cardshuffling.util.ShufflingStrategy;

@Path("/decks")
public class ShuffleDeckActivity {
    
    /**
     * Method handling HTTP POST requests. The returned object will be sent
     * to the client as "application/json" media type. 
     * Method take input as name for Deck in "text/plain" format
     *
     * @return object that will be returned as a application/json response.
     */
    
    
    /**
     * shuffleDeck() return a Shuffled Deck present in the Memory
     * @return : Successfully getDeck() operation will return a Deck in "application/json format"
     *          else if Shuffling Strategy is not provided will throw ConfigFileNotFoundException
     *          else if for invalid Shuffling Strategy will throw InvalidStrategyException
     *          else will return DataNotFoundException Exception error message in "application/json" format.
     */

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Deck shuffleDeck(String name)
            throws InvalidStrategyException {

        ShufflingStrategy shufflingStrategy = null;

        //get named Deck from memory, else throw Exception
        Deck deck = getDeck(name);
        
        //get Shuffling Strategy from config.properties , else throw respective Exception
        String shuffleType = getShufflingStrategy();

        //Depends on Shuffling Strategy instantiating an object for shuffling 
        if (shuffleType.equals("random")) {
            shufflingStrategy = new RandomShuffling();
        } else if (shuffleType.equals("handshuffle")) {
            shufflingStrategy = new HandShuffling();
        } else {
            throw new InvalidStrategyException(
                    "configuration has invalid shuffle strategy. " + "It should be either random or handshuffle");
        }

        return shufflingStrategy.shuffleDeck(deck);

    }

    /**
     * getDeck() return a Deck present in the Memory
     * @return : Successfully getDeck() operation will return a Deck Object"
     *          else if for name is not provided then will throw NameNotProvidedException
     *          else will return DataNotFoundException Exception.
     */
    
    public Deck getDeck(String name) throws NameNotProvidedException, DataNotFoundException {
        
        if (name == null || name.isEmpty()) {
            throw new NameNotProvidedException("Name can not be null or empty");
        }

        Deck deck = Cache.getDecks().get(name);

        if (deck == null) {
            throw new DataNotFoundException("Deck with name " + name + " not found");
        }
        
        return deck;
        
    }
    
    /**
     * getShufflingStrategy() return a String from config.properties file
     * @return : Successfully getShufflingStrategy() operation will return a String object"
     *          else will return ConfigFileNotFoundException Exception.
     */

    public String getShufflingStrategy() throws ConfigFileNotFoundException {

        Properties prop = new Properties();
        InputStream input = null;

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("config.properties").getFile());

            input = new FileInputStream(file);

            // load a properties file
            prop.load(input);

            // get the property value and return
            return prop.getProperty("shufflingStrategy");

        } 
        catch (NullPointerException ex) {
            throw new ConfigFileNotFoundException("config.properties file is missing from resource directory");
        }        
        catch (IOException ex) {
            throw new ConfigFileNotFoundException("config.properties file is missing from resource directory");
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
