import java.util.*;

/*
 *
 * Proj2.java
 *
 * Jake Herman Thu lab (4:30-6:20)
 *
 * poker hand dealer (EXTRA CREDIT ATTEMPTED):
 * 	deals five cards at random to user.
 * 	identifies high card and if a pairs/three of a kind exist.
 * 	utilizes multidimensional arrays for card data and for loops for code efficiency.
 *  To improve upon this code, I'd use java lists (to avoid null elements) and a hashmap
 *  so that I could could link all the cards in the deck to how many times they occur in
 *  the players hand. Then, finding pairs/three of a kind would be much easier. I wouldn't
 *  have to use nested for loops (o^2) to look up items.
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

    //Pair finding:

    //stores cards that were paired (list objects would be better...)
    String[] pairedCards = new String[2];
    //count pairs made for handling output
    int pairs = 0;
    //pass is incremented every time one card is NOT equal to another in your hand
    int passes = 0;

    /* takes one card and compares it to all the other cards in the hand
     * there are 5 cards in the hand. This would compare card1 to itself once, so
     * four passes means there are no matches for that card.
     */
    for (String[] card1 : hand)
    {
      for(String[] card2 : hand)
      {
        //if they are not equal, pass is incremented
        if(!card1[2].equals(card2[2]))
        {
          passes++;
        }
      }

      /* if the card passed three times, then there is another card (besides itself)
       * that matched when the for loop ran. If it only passed twice, then we have
       * three of a kind.
       */
      if(passes == 3 || passes == 2)
      {
        //now we need to make sure we dont output multiple times for the same pair
        boolean alreadyPaired = false;
        //compares the card which we believe to be a pair to what has already been known to be paired in the hand
        for (int i = 0; i < pairedCards.length; i++)
        {
          if(card1[0].equals(pairedCards[i]))
          {
            alreadyPaired = true;
            //break out of loop so we don't overwrite the boolean
            break;
          }
        }
        //if the for loop above passed then we can tell the user a pair was found
        if(!alreadyPaired)
        {
          //a pair (this will happen twice if there is a two pair)
          if(passes == 3)
          {
            System.out.println("You have a pair of " + card1[0] + "'s");
            pairedCards[pairs] = card1[0];
            pairs++;
          }
          //three of a kind
          else if(passes == 2)
          {
            System.out.println("You have three " + card1[0] + "'s");
            pairedCards[pairs] = card1[0];
            pairs++;
          }
        }
      }

      passes = 0;
    }

    //let the user know their poker hand is up a tier
    if(pairs > 1)
    {
      System.out.println("that's a two pair! nice!");
    }
    //let the user know no pairs were found
    if(pairs == 0)
    {
      System.out.println("You have no pairs");
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
