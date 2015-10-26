import java.util.*;
public class CasinoWarGame{
     public void game(){
          CasinoWarCash cwc = new CasinoWarCash();
          CasinoWarPlay cwp = new CasinoWarPlay();
          Deck deck = new Deck();
          Scanner input = new Scanner(System.in);
          char playAgain = 'y';
          //Initialize number of deck
          int numberOfDeck = 6;
          int[] d = deck.decksReady(numberOfDeck);
          
          //Initialize starting amount (0 ~ 1000)
          int amount = 0;
          amount = cwc.initAmount();
          int bettingAmount = 0;
          int currentAmount = amount;
          
          //card
          int playerCard = -1;
          int dealerCard = -1;
          String player_card = "";
          String dealer_card = "";
          
          //game
          int result = 0;
          int numTie = 0;
          do{
               //Betting
               bettingAmount = cwc.bet(currentAmount);
               
               do{
                    //deal the card
                    playerCard = cwp.deal(numberOfDeck);
                    dealerCard = cwp.deal(numberOfDeck);
                    player_card = deck.deckToString(playerCard);
                    dealer_card = deck.deckToString(dealerCard);
                    System.out.println("Dealer's card is " + dealer_card + " " 
                                            + dealerCard + "\nYour card is " + player_card +" "+ playerCard + ".");
                    
                    //Result
                    result = cwp.play(playerCard, dealerCard);
                    if(result == 1){ //win
                         currentAmount = cwp.win(currentAmount, bettingAmount);
                    }
                    else if(result == -1){ //lose
                         currentAmount = cwp.lose(currentAmount, bettingAmount);
                    }
                    else{ // tie
                         char surrenderOrWar = cwp.surrenderOrWar();
                         currentAmount = cwp.tie(bettingAmount, surrenderOrWar, numTie);
                         numTie++;
                    }
               }while(result == 0 && numTie < 3);
               //Current cash output
               cwc.currentCash(currentAmount);
               
               if(currentAmount == 0){
                    cwc.gameOver();
                    playAgain = 'n';
               }
               else{
                    //Again?
                    playAgain = cwp.playAgain();
               }
          }while(((playAgain == 'y') || (playAgain == 'Y')) && currentAmount != 0);
     }
}