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
		for(int i = 0; i < 4; i++) {
			playerCards.add(deckOfCards.remove(0));
		}
		
		System.out.println("players cards");
		for(Card c: playerCards)
			System.out.println(c);

		System.out.println("pairs is " + checkFor2Kind());

	}//end main

	public static void shuffle() {
		// Use Collections.shuffle to shuffle the deck better 
		//(before it only shuffled heart suit cards)
		Collections.shuffle(deckOfCards);
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
}//end class
