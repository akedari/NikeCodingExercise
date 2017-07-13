package org.kedari.challenge.cardshuffling.activity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.kedari.challenge.cardshuffling.activities.AddDeckActivity;
import org.kedari.challenge.cardshuffling.activities.DeleteDeckActivity;
import org.kedari.challenge.cardshuffling.exception.DataNotFoundException;
import org.kedari.challenge.cardshuffling.exception.NameNotProvidedException;
import org.kedari.challenge.cardshuffling.model.Deck;

import junit.framework.TestCase;

public class DeleteDeckActivityJunitTest extends TestCase{
    
    DeleteDeckActivity deleteDeckActivity = new DeleteDeckActivity();
    
    @Test(expected=NameNotProvidedException.class)
    public void testRemoveDeckForNull() {

        try {
            deleteDeckActivity.removeDeck(null);
            fail();
        } catch (NameNotProvidedException e) {
            assertThat(e.getMessage(), is("Name can not be null or empty"));
        }
    }
    
    @Test(expected=DataNotFoundException.class)
    public void testGetDeckDataNotFound() {

        try {
            deleteDeckActivity.removeDeck("7Spades");
            fail();
        } catch (DataNotFoundException e) {
            assertThat(e.getMessage(), is("Deck with name 7Spades not found"));
        }
    }
    
    @Test
    public void testRemoveDeck() {

        try {
            AddDeckActivity addDeckActivity = new AddDeckActivity();
            addDeckActivity.addDeck("13Diamonds");
            Deck deck = deleteDeckActivity.removeDeck("13Diamonds");
            assertNotNull(deck);
            
        } catch (Exception e) {
            fail();
        }
    }

}
