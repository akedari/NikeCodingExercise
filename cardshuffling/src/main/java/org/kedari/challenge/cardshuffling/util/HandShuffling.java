package org.kedari.challenge.cardshuffling.util;

import java.util.List;

import org.kedari.challenge.cardshuffling.model.Deck;

public class HandShuffling implements ShufflingStrategy {
    
    /**
     * This class provides a implementation for ShufflingStrategy Interface
     * Strategy Designed Pattern has been implemented for runtime switching the strategies.
     * This class is for Hand Shuffling of cards   
     */
    
	@Override
	public Deck shuffleDeck(Deck deck) {
		
	    List<String> cards =  deck.getCards();
	    int size = deck.getCards().size();
	    
	    String[] half1 = new String[ size / 2 ];
        String[] half2 = new String[ size - size / 2 ];

        for( int i = 0; i < size / 2; i++ ) {
            half1[i] = cards.get(i);
        }
        
        for( int i = 0; i < size - size / 2; i++ ) {
            half2[i] = cards.get( i + size / 2 );
        }
        
        for( int i = 0; i < size / 2; i++ ) {
            cards.set(2*i, half2[i]);
            cards.set(2*i+1, half1[i]);
        }
        
        if( size % 2 != 0 ) {
            cards.set(size-1,half2[ size - size / 2 ]);
        }
	    
		return deck;
	}

}
