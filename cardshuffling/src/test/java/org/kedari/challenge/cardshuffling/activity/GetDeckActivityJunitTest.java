package org.kedari.challenge.cardshuffling.activity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.kedari.challenge.cardshuffling.activities.AddDeckActivity;
import org.kedari.challenge.cardshuffling.activities.GetDeckActivity;
import org.kedari.challenge.cardshuffling.exception.DataNotFoundException;
import org.kedari.challenge.cardshuffling.exception.NameNotProvidedException;
import org.kedari.challenge.cardshuffling.model.Deck;

import junit.framework.TestCase;

public class GetDeckActivityJunitTest extends TestCase{

    
    GetDeckActivity getDeckActivity = new GetDeckActivity();
    
    @Test(expected=NameNotProvidedException.class)
    public void testGetDeckForNull() {

        try {
            getDeckActivity.getDeck(null);
            fail();
        } catch (NameNotProvidedException e) {
            assertThat(e.getMessage(), is("Name can not be null or empty"));
        }
    }
    
    @Test(expected=DataNotFoundException.class)
    public void testGetDeckNotFound() {

        try {
            getDeckActivity.getDeck("4King");
            fail();
        } catch (DataNotFoundException e) {
            assertThat(e.getMessage(), is("Deck with name 4King not found"));
        }
    }
    
   
    
    @Test
    public void testGetDeck() {

        try {
            AddDeckActivity addDeckActivity = new AddDeckActivity();
            addDeckActivity.addDeck("4Hearts");
            Deck deck = getDeckActivity.getDeck("4Hearts");
            assertNotNull(deck);
        } catch (Exception e) {
            fail();
        }
    }
    
    
    
}
