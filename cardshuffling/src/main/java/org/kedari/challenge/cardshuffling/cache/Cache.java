package org.kedari.challenge.cardshuffling.cache;

import java.util.HashMap;
import java.util.Map;

import org.kedari.challenge.cardshuffling.dao.MySqlDao;
import org.kedari.challenge.cardshuffling.model.Deck;

public class Cache {
    
    /**
     * In Memory operations for Deck such as Add, Remove as well as If you want to dump Data into persistent Database 
     * provision has been provided to do that via. dumpCache()
     * 
     * We can enhance and add any new Database support through this class
     */
    

	private static Map<String, Deck> decks = new HashMap<>();

	public static Map<String, Deck> getDecks() {
		return decks;
	}

	public static Deck add(String name, Deck newDeck) {
	    decks.put(name, newDeck);
		return newDeck; 
	}

	public static Deck remove(String name) {
		return decks.remove(name);
	}

	public static void dumpCache() {
	    MySqlDao.save(decks);
	}

}
