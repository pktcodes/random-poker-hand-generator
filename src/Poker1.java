import java.util.Random;
import java.util.Scanner;

public class Poker1 {
	
	/**
	 *
	 * @author PraveenKumarThipparam
	 */
	public static void main(String[] args) {
		boolean canContinue = true;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("WELCOME TO POKER");
		System.out.println("=================");
		do {
			int[] hand = new int[5];
			
			int[] deck = getDeck();
			shuffle(deck);
			
			// Testing cardsDeck
			// printDeck(deck);
			
			hand = dealHand(deck);
			printHand(hand);
			
			System.out.print("\nDo you want to play again? (Y or N): ");
			
			String userPreference = sc.nextLine();
			
			if (userPreference.trim().equals("N") || userPreference.trim().equals("n")) {
				canContinue = false;
			}
			
		} while(canContinue);
		sc.close();
		
	}
	
	/**
	 * method description
	 * @return return description
	 */
	public static int[] getDeck() {
		int deck[] = new int[52];
		for (int i = 0; i < 52; i++) {
	    	deck[i] = i;
	    }
	    
	    return deck;
	}
	
	/**
	 * 
	 * @param deck 
	 */
	public static void shuffle(int[] deck) {
		 Random rand = new Random();
		 //Shuffle:
		 
		 int numOfSwaps = 20000;
		 for(int i =0; i<numOfSwaps; i++)	{
			 //Swap ind1 and ind2 positions:
			 int ind1=rand.nextInt(6)+1;
			 int ind2=rand.nextInt(51);
			 
			 int temp = deck[ind1];
			 deck[ind1]=deck[ind2];
			 deck[ind2]=temp;
		 }
	}
	
	/**
	 * 
	 * @param deck
	 */
	public static void printDeck(int[] deck) {
		
		for (int i = 0; i < deck.length; i++)
			System.out.println(deck[i]);
	}
	
	/**
	 * 
	 * @param deck
	 * @return
	 */
	public static int[] dealHand(int[] deck) {
		int min = 0, max = 51;
		int hand[] = new int[5];
		
		String handValuesText = "\nYour hand: (";
		Random rand = new Random();
		
		for (int i =0; i <5; i++) {
			hand[i] = rand.nextInt((max - min) + 1) + min;
			
			if (i == 4)
				handValuesText = handValuesText + " " + hand[i] + " )";
			else
				handValuesText = handValuesText + " " + hand[i] + " ,";
		}
		
		System.out.println(handValuesText);

		return hand;
	}
	
	/**
	 * 
	 * @param hand
	 */
	public static void printHand(int[] hand) {
		
		for (int i=0; i<hand.length; i++) {
			
			int suitValue = hand[i] / 13;
			int cardValue = hand[i] % 13;
			
			String suit = "", card = "";
			
			switch(suitValue) { 
				case 0: suit = "Hearts"; break;
				case 1: suit = "Diamonds"; break;
				case 2: suit = "Spades"; break;
				case 3: suit = "Clubs"; break;
				default: System.out.println("Something went wrong!"); System.exit(-1);
			}
			
			switch(cardValue) {
				case 0: card = "A"; break;
				case 1: card = "2"; break;
				case 2: card = "3"; break;
				case 3: card = "4"; break;
				case 4: card = "5"; break;
				case 5: card = "6"; break;
				case 6: card = "7"; break;
				case 7: card = "8"; break;
				case 8: card = "9"; break;
				case 9: card = "10"; break;
				case 10: card = "J"; break;
				case 11: card = "Q"; break;
				case 12: card = "K"; break;
				default: System.out.println("Something went wrong!"); System.exit(-1);
			}
			
			System.out.println(" " + card + " of " + suit);
		}
	}
}
