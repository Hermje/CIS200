import java.util.*;

/*
 *
 * Proj2.java
 *
 * Jake Herman Thu lab (4:30-6:20)
 *
 * poker hand dealer:
 * 	deals five cards at random to user.
 * 	identifies high card and if any pairs exist.
 * 	utilizes multidimensional arrays for card data and for loops for code efficiency.
 *
 */

public class Proj2 {

  public static void main(String args[]) {
    Random r = new Random();
    //the deck, essentially- storing all the face values in a string array
    String[] cards = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack",
                      "Queen", "King"};

    //storing all possible suits in a string array
    String[] suits = {"spades", "clubs", "hearts", "diamonds"};
    //cards from the deal will be stored in this 2D string array
    //3 columns, one for the face name, the suit name, and then the cards numerical value (used for finding high card)
    String[][] hand = new String[5][3];

    //deal cards
    for(int i = 0; i < 5; i++) {
      // randomly pick a valid card value and match it to a name in the deck
      int cardIndex = r.nextInt(13);
      // randomly pick a suit for that card
      int suitIndex = r.nextInt(4);

      // adding to hand array, by matching the random numbers with a card/suit name
      hand[i][0] = cards[cardIndex];
      hand[i][1] = suits[suitIndex];
      // actual numerical value of the card, used for finding high card. array indexes start at 0, so if I didn't add 1 then the ace would = 0
      hand[i][2] = String.valueOf(cardIndex + 1);
      // display what was dealt to the user
      System.out.println(hand[i][0] + " of " + hand[i][1]);
    }

    //temp string used for storing result of matching operation below
    String pair = "";

    //find pairs
    for(int i = 0; i < 5; i++) {
      // temp string array to store all data of a card: {face name, suit name, numerical value}
      String[] card1 = hand[i];
      // increments every time match is found, it will compare the card to itself so one match is not enough
      int matches = 0;

      //compares every other card to the one selected above
      for(int j = 0; j < 5; j++) {
        String[] card2 = hand[j];
        //using .equals to compare because == with String doesn't compare their actual value
        if(card1[0].equals(card2[0])) {
          //increment matches if test passes
          matches++;
          //set pair equal to that card for output purposes
          pair = card1[0];
        }

      }
      //greater than one because it could just compare to itself
      if(matches > 1) {
        System.out.printf("you have a pair of %s's \n", pair);
        //not worried about anymore pairs at the moment so we can stop
        break;
      }

      if(i==4) {
    	  //every card has been compared at this point
        System.out.println("you have no pairs");
      }
    }

    //temp string, just picks the top card to start comparison
    String highCard = hand[0][2];
    //find high card
    for(int i = 0; i < 5; i++) {
      //numerical card value
      String card = hand[i][2];

      //ace is the highest possible, if found there's no need to continue comparing
      if(Integer.parseInt(card) == 1) {
    	  //card face name
    	  highCard = hand[i][2];
    	  break;
      }
      else
      {
    	  //the multidimensional card data array is of the String type so their numerical values need to be converted to ints for < > comparisons
          if (Integer.parseInt(card) > Integer.parseInt(highCard))
          {
        	  //set = to numerical value
            highCard = hand[i][2];
          }
      }

    }

    //output final result
    System.out.println("your high card is: " + cards[Integer.parseInt(highCard) - 1]);

  }

}
