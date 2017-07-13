package org.kedari.challenge.cardshuffling.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Deck {
    
    /**
     * This is model class for Deck. Data-structure for Deck
     * Use to create new Deck with pre-defined sorted order.
     * 
     */

	private String name;
	private ArrayList<String> cards;

	public Deck() {
		this("Dummy");
	}

	public Deck(String name) {
		this.name = name;
		this.cards = new ArrayList<>();
		fillCards();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getCards() {
		return cards;
	}

	public void setCards(ArrayList<String> cards) {
		this.cards = cards;
	}

	/**
	 * This Method is use to create Deck of 52 cards in sorting order
	 * 
     */
	
	private void fillCards() {
		
		String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	    
	    for(int i=0;i<suits.length;i++) {
	        for(int j=0;j<ranks.length;j++) {
	            String card = ranks[j] + "-" + suits[i];
	            cards.add(card);
	        }
	    }
	    
	}

}
