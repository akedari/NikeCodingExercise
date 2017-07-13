package org.kedari.challenge.cardshuffling.activity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import javax.ws.rs.core.Response;

import org.junit.Test;
import org.kedari.challenge.cardshuffling.activities.AddDeckActivity;
import org.kedari.challenge.cardshuffling.activities.ShuffleDeckActivity;
import org.kedari.challenge.cardshuffling.exception.ConfigFileNotFoundException;
import org.kedari.challenge.cardshuffling.exception.DataNotFoundException;
import org.kedari.challenge.cardshuffling.exception.NameNotProvidedException;
import org.kedari.challenge.cardshuffling.model.Deck;
import org.kedari.challenge.cardshuffling.util.HandShuffling;

import junit.framework.TestCase;

public class ShuffleDeckActivityJunitTest extends TestCase{

    ShuffleDeckActivity shuffleDeckActivity = new ShuffleDeckActivity();
    

    @Test(expected=DataNotFoundException.class)
    public void testGetDeckNotFound() {

        try {
            shuffleDeckActivity.getDeck("4jack");
            fail();
        } catch (DataNotFoundException e) {
            assertThat(e.getMessage(), is("Deck with name 4jack not found"));
        }
    }
    
    @Test(expected=NameNotProvidedException.class)
    public void testGetDeckForNull() {

        try {
            shuffleDeckActivity.getDeck(null);
            fail();
        } catch (NameNotProvidedException e) {
            assertThat(e.getMessage(), is("Name can not be null or empty"));
        }
    }
    
    @Test
    public void testGetDeck() {

        try {
            new AddDeckActivity().addDeck("ABC");
            assertNotNull(shuffleDeckActivity.getDeck("ABC"));
        } catch (Exception e) {
            fail();
        }
    }
    
    @Test(expected=DataNotFoundException.class)
    public void testShuffleDeckHandShuffling() {

        try {
            AddDeckActivity addDeckActivity = new AddDeckActivity();
            Response response = addDeckActivity.addDeck("newDeck");
            Deck deck = (Deck) response.getEntity();
            Deck output = new HandShuffling().shuffleDeck(deck);
            
            ArrayList<String> expected = new ArrayList<>(Arrays.asList(
                    "Ace-Diamonds", "Ace-Spades", "2-Diamonds", "2-Spades", "3-Diamonds",
                    "3-Spades", "4-Diamonds", "4-Spades", "5-Diamonds", "5-Spades",
                    "6-Diamonds", "6-Spades", "7-Diamonds", "7-Spades", "8-Diamonds",
                    "8-Spades", "9-Diamonds", "9-Spades", "10-Diamonds", "10-Spades", 
                    "Jack-Diamonds", "Jack-Spades", "Queen-Diamonds", "Queen-Spades", 
                    "King-Diamonds", "King-Spades", "Ace-Clubs", "Ace-Hearts", "2-Clubs",
                    "2-Hearts", "3-Clubs", "3-Hearts", "4-Clubs", "4-Hearts", "5-Clubs",
                    "5-Hearts", "6-Clubs", "6-Hearts", "7-Clubs", "7-Hearts", "8-Clubs",
                    "8-Hearts", "9-Clubs", "9-Hearts", "10-Clubs", "10-Hearts", "Jack-Clubs",
                    "Jack-Hearts", "Queen-Clubs", "Queen-Hearts", "King-Clubs", "King-Hearts"));         
            
            assertEquals("Should match cards sequence", expected, output.getCards());
            
        } catch (DataNotFoundException e) {
            fail("HandShuffling is not working properly");
        }
    }
    
    @Test
    public void testGetShufflingStrategy() {

        try {
            String output = shuffleDeckActivity.getShufflingStrategy();
            assertNotNull(output);
        } catch (ConfigFileNotFoundException e) {
            fail("config.properties file is missing from resource directory");
        }
    }
    
    
}
