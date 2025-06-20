// Madison Bazan
// 6/18/2025
// Card game with OOD



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections; //new addition for shuffling

public class CardGame {

	//data structures that hold cards
	private static ArrayList<Card> deckOfCards = new ArrayList<Card>();
	private static ArrayList<Card> playerCards = new ArrayList<Card>();


	public static void main(String[] args) {

		//scanner-input reading
		Scanner input = null;
		try {
			input = new Scanner(new File("cards.txt"));
		} catch (FileNotFoundException e) {
			// error
			System.out.println("error");
			e.printStackTrace();
		}

		//attempts to read each card and add it to deck
		while(input.hasNext()) {
			String[] fields  = input.nextLine().split(",");
			//	public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
			Card newCard = new Card(fields[0], fields[1].trim(),
					Integer.parseInt(fields[2].trim()), fields[3]);
			deckOfCards.add(newCard);	
		}
		
		//shuffle function cause we're groovy like that
		shuffle();

		//for(Card c: deckOfCards)
			//System.out.println(c);

		//deal the player 5 cards
		for(int i = 0; i < 5; i++) { // deal 5 cards to player corrected
			playerCards.add(deckOfCards.remove(0));
		}
		

		//print out the players cards and searches for pairs, threes and finds total value
		System.out.println("Players cards:");
		for(Card c: playerCards)
			System.out.println(c);

		System.out.println("Pairs is " + checkFor2Kind());
		System.out.println("Three of a kind is " + checkFor3Kind());
		System.out.println("Total value of player's hand: " + getPlayerHandValue());


	}//end main

	public static void shuffle() {
		// Use Collections.shuffle to shuffle the deck better 
		//(before it only shuffled heart suit cards)
		Collections.shuffle(deckOfCards);
	}

	//get players hand value
	public static int getPlayerHandValue() {
		int total = 0;
		for (Card c : playerCards) {
			total += c.getValue();
		}
		return total;
	}

	//check for 2 of a kind in the players hand
	public static boolean checkFor2Kind() {

		int count = 0;
		for(int i = 0; i < playerCards.size() - 1; i++) {
			Card current = playerCards.get(i);
			Card next = playerCards.get(i+1);
			
			for(int j = i+1; j < playerCards.size(); j++) {
				next = playerCards.get(j);
				//System.out.println(" comparing " + current);
				//System.out.println(" to " + next);
				if(current.equals(next))
					count++;
			}//end of inner for
			if(count == 1)
				return true;

		}//end outer for
		return false;
	}

	//check for 3 of a kind in the players hand
	public static boolean checkFor3Kind() {
		for (int i = 0; i < playerCards.size(); i++) {
			int count = 1;
			Card current = playerCards.get(i);
			for (int j = 0; j < playerCards.size(); j++) {
				if (i != j && current.getRank().equals(playerCards.get(j).getRank())) {
					count++;
				}
			}
			if (count == 3) {
				return true;
			}
		}
		return false;
	}
}//end class
