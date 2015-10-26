import java.util.*;

public class Deck{
     /* 0 ~ 51:
      * 0 ~ 12 -> Spades
      * 13 ~ 25 -> Hearts
      * 26 ~ 38-> Clubs
      * 39 ~ 51 -> Diamonds */
     public int[] decksReady(int numDeck){
          int[] deck = new int[52 * numDeck];
          for(int i = 0; i < (52 * numDeck); i++){
               deck[i] = i;
          }
          return deck;
     }
     
     /* 0 ~ 51:
      * 0 ~ 12 -> Spades
      * 13 ~ 25 -> Hearts
      * 26 ~ 38-> Clubs
      * 39 ~ 51 -> Diamonds */
     public String deckToString(int deck){
          int suit = deck % 52;
          int rank = deck % 13;
          String output = "";
          
          //Suit
          if((suit >= 0) && (suit < 13)){
               output = "Spades ";
          }
          else if((suit >= 13) && (suit < 26)){
               output = "Hearts ";
          }
          else if((suit >= 26) && (suit < 39)){
               output = "Clubs ";
          }
          else if((suit >= 39) && (suit < 52)){
               output = "Diamonds ";
          }
          else{
               output = "Something went wrong!";
          }
          
          //Rank
          switch (rank){
               case 0:
                    output += "Ace";
                    break;
               case 1:
                    output += "2";
                    break;
               case 2:
                    output += "3";
                    break;
               case 3:
                    output += "4";
                    break;
               case 4:
                    output += "5";
                    break;
               case 5:
                    output += "6";
                    break;
               case 6:
                    output += "7";
                    break;
               case 7:
                    output += "8";
                    break;
               case 8:
                    output += "9";
                    break;
               case 9:
                    output += "10";
                    break;
               case 10:
                    output += "J";
                    break;
               case 11:
                    output += "Q";
                    break;
               case 12:
                    output += "K";
                    break;
               default:
                    output += "No";
          }
          return output;
     }
     
}