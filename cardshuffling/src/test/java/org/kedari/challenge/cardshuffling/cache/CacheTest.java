package org.kedari.challenge.cardshuffling.cache;

import org.junit.Test;
import org.kedari.challenge.cardshuffling.cache.Cache;
import org.kedari.challenge.cardshuffling.model.Deck;

import junit.framework.TestCase;

public class CacheTest extends TestCase {
    
    @Test
    public void testGetDecks() {
        assertNotNull(Cache.getDecks());   
    }

    @Test
    public void testAdd() {
        Deck deck = Cache.add("4Queens", new Deck());
        assertNotNull(deck);  
    }
    
    @Test
    public void testRemove() {
        Cache.add("4Queens", new Deck());
        Deck deck = Cache.remove("4Queens");
        assertNotNull(deck);  
    }

}
