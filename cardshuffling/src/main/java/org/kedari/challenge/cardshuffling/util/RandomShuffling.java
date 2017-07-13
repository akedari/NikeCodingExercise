package org.kedari.challenge.cardshuffling.util;

import java.util.List;
import java.util.Random;

import org.kedari.challenge.cardshuffling.model.Deck;

public class RandomShuffling implements ShufflingStrategy {

    /**
     * This class provides a implementation for ShufflingStrategy Interface
     * Strategy Designed Pattern has been implemented for runtime switching the strategies.
     * This class is for Random Shuffling of cards   
     */
    
	@Override
	public Deck shuffleDeck(Deck deck) {
	    
		List<String> cards =  deck.getCards();
		int minimum = 0;
        int maximum = cards.size()-1;
		
		for(int i=0;i<cards.size();i++) {
		    Random rand = new Random();
            int randomPosition = minimum + rand.nextInt((maximum - minimum) + 1);
            swap(randomPosition,i,cards);
		}
		return deck;
	}
	
	// Swap function for cards
    private void swap(int randomPosition, int seq, List<String> cards) {
        
        String temp = cards.get(randomPosition);
        cards.set(randomPosition, cards.get(seq));
        cards.set(seq,temp);
        
    }

}
