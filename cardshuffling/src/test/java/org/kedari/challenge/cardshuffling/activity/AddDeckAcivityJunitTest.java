package org.kedari.challenge.cardshuffling.activity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Test;
import org.kedari.challenge.cardshuffling.activities.AddDeckActivity;
import org.kedari.challenge.cardshuffling.exception.NameConflictException;
import org.kedari.challenge.cardshuffling.exception.NameNotProvidedException;

import junit.framework.TestCase;

public class AddDeckAcivityJunitTest extends TestCase {

    AddDeckActivity addDeckActivity = new AddDeckActivity();
    
    @Test
    public void testAddDeck(){
        Response output = addDeckActivity.addDeck("test");
        assertEquals("should return status 201", 201, output.getStatus());
        
    }
    
    @Test(expected=NameConflictException.class)
    public void testAddDeckDuplicateName(){
        
        try {
            addDeckActivity.addDeck("Duplicate");
            addDeckActivity.addDeck("Duplicate");
            fail();
        } catch (NameConflictException e) {
            assertThat(e.getMessage(), is("Deck with smae name is already exists, Please choose different name"));
        }
    }
    
    
    @Test(expected=NameNotProvidedException.class)
    public void testAddDeckForNull(){
        
        try {
            addDeckActivity.addDeck(null);
            fail();
        } catch (NameNotProvidedException e) {
            assertThat(e.getMessage(), is("Name can not be null or empty"));
        }
        
        
    }
    
    

}
