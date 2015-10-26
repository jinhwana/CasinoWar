import java.util.*;
public class CasinoWarPlay{
     
     //deal
     public int deal(int numberOfDeck){
          Random random = new Random();
          int dealCard = random.nextInt(51 * numberOfDeck);
          
          return dealCard;
     }
     
     //get rank
     public int getRank(int card){
          int rank = 0;
          rank = card % 52;
          
          return rank;
     }
     //returns 1 for player win, 0 for tie, -1 for lose
     public int play(int playerCard, int dealerCard){
          int result = 0;
          int playerCardRank = getRank(playerCard);
          int dealerCardRank = getRank(dealerCard);
          if(playerCardRank > dealerCardRank){
               result = 1;
          }
          else if(playerCardRank < dealerCardRank){
               result = -1;
          }
          else{
               result = 0;
          }
          return result;
     }
     
     //win
     public int win(int currentAmount, int bettingAmount){
          System.out.println("You Won!");
          return currentAmount + bettingAmount;
     }
     
     //lose
     public int lose(int currentAmount, int bettingAmount){
          System.out.println("You Lost!");
          return currentAmount - bettingAmount;
     }
     
     //tie
     public int tie(int bettingAmount, char surrenderOrWar, int numTie){
          int bet = bettingAmount;
          if(((surrenderOrWar == 'w') || (surrenderOrWar == 'W')) && numTie == 1){
               //first tie and go for war
               bet += bettingAmount;               
          }
          else if(((surrenderOrWar == 'w') || (surrenderOrWar == 'W')) && numTie == 2){
               //second tie and go for war
               bet += bettingAmount;
          }
          else{
               //tie and surrender
               bet -= bettingAmount / 2;
          }
          return bet;
     }
    // public int tie(int 
     public char surrenderOrWar(){
          Scanner input = new Scanner(System.in);
          char userDecision = ' ';
          do{
               System.out.println("Draw!\nSurrender or War (S/W):");
               userDecision = input.next().charAt(0);
          }while((userDecision == 's') || (userDecision == 'S') || (userDecision == 'W') || (userDecision == 'w'));
          return userDecision;
     }
     
     
     //ask for play again
     public char playAgain(){
          Scanner input = new Scanner(System.in);
          System.out.println("Play again? (Y/y)");
          char again = input.next().charAt(0);
          return again;
     }
}