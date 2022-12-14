package com.BrandonHellwarth.BlackJack;
import java.util.ArrayList;
public class Deck {
	private ArrayList<Card> cards;
	
    public Deck() {
        this.cards = new ArrayList<Card>();

        // Populate the cards list -- loop to 52
        for (String name : new String[] {"Hearts", "Clubs", "Diamonds", "Spades"}) {
            for (Integer rank = 1; rank <= 13; rank++) {
                this.cards.add(new Card(name, rank));
            }
        }
    }
    
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public void shuffle() {
		ArrayList<Integer> newarr = new ArrayList<Integer>();
		while (newarr.size() < 52) {
			int rand = (int)((Math.random() * 52));
			boolean bool = true;
			for(int i=0;i<newarr.size();i++) {
				if(newarr.get(i) == rand) {
					bool = false;
					break;
				}
			}
			if(bool == false) {
				continue;
			}
			newarr.add(rand);
		}
		for(int i=0;i<this.cards.size();i++) {
			Card card = this.cards.get(newarr.get(i));
			this.cards.set(i, card);
		}
	}
	
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
}
