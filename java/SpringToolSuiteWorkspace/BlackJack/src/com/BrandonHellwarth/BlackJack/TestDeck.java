package com.BrandonHellwarth.BlackJack;

public class TestDeck {

	public static void main(String[] args) {
		Deck deck = new Deck();
		for(int i=0;i<deck.getCards().size();i++) {
			System.out.println(deck.getCards().get(i).getName());
		}
		deck.shuffle();
		for(int i=0;i<deck.getCards().size();i++) {
			System.out.println(deck.getCards().get(i).getName());
		}
	}
}
