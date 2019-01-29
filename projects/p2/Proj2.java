import java.util.*;

public class Proj2 {

  public static void main(String args[]) {
    Random r = new Random();
    String[][] cards = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack",
                      "Queen", "King"};

    String[] suits = {"spades", "clubs", "hearts", "diamonds"};
    String[][] hand = new String[5][2];

    for(int i = 0; i < 5; i++) {
      int cardIndex = r.nextInt(13);
      int suitIndex = r.nextInt(4);

      hand[i][0] = cards[cardIndex];
      hand[i][1] = suits[suitIndex];

      System.out.println(hand[i][0] + " of " + hand[i][1]);
    }

    String pair = "";

    //find pairs
    for(int i = 0; i < 5; i++) {
      String[] card1 = hand[i];
      int matches = 0;

      for(int j = 0; j < 5; j++) {
        String[] card2 = hand[j];

        if(card1[0].equals(card2[0])) {
          matches++;
          pair = card1[0];
        }

      }
      //greater than one because it could just compare to itself
      if(matches > 1) {
        System.out.printf("you have a pair of %s's \n", pair);
        break;
      }

      if(i==4) {
        System.out.println("you have no pairs");
      }
    }

    //find high card
    String highCard = hand[0][0];
    for(int i = 0; i < 5; i++) {
      if(i < 4) {
        if(hand[i][0] instanceof String) {

        } else {
          if(Integer.parseInt(hand[i][0] > highCard)) {
            highCard =
          }
        }
      }
    }

  }

}
