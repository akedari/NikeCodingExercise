package org.kedari.challenge.cardshuffling.activity;

import java.util.List;

import org.junit.Test;
import org.kedari.challenge.cardshuffling.activities.AddDeckActivity;
import org.kedari.challenge.cardshuffling.activities.GetAllDecksActivity;
import org.kedari.challenge.cardshuffling.model.Deck;

import junit.framework.TestCase;

public class GetAllDecksActivityJunitTest extends TestCase {

    GetAllDecksActivity getAllDecksActivity = new GetAllDecksActivity();

    @Test
    public void testGetAllDecks() {
        
        List<Deck> output = getAllDecksActivity.getAllDecks();
        assertNotNull(output);
    }

    @Test
    public void testGetAllDecksSize() {
        List<Deck> initialDecks = getAllDecksActivity.getAllDecks();
        
        new AddDeckActivity().addDeck("firstDeck");
        new AddDeckActivity().addDeck("secondDeck");
        new AddDeckActivity().addDeck("thirdDeck");
        
        List<Deck> output = getAllDecksActivity.getAllDecks();
        assertEquals("Should matched the count of decks", 3+initialDecks.size(), output.size());
    }

}
