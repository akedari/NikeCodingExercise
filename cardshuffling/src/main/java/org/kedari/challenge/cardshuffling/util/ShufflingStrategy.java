package org.kedari.challenge.cardshuffling.util;

import org.kedari.challenge.cardshuffling.model.Deck;

public interface ShufflingStrategy {
    /**
     * Interface to provide abstraction.
     * Strategy Designed Pattern has been implemented for runtime switching the strategies.
     * implementions class has to provide definition for shuffleDeck()   
     * 
     */
    
	public Deck shuffleDeck(Deck deck);

}
