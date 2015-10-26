import java.util.*;
public class CasinoWarCash{
     public int initAmount(){
          Scanner input = new Scanner(System.in);
          int startingAmount = 0;
          do{
               System.out.println("Staring amount (0 ~ 1000): ");
               startingAmount = input.nextInt();
          }while(startingAmount < 0 || startingAmount > 1000);
          return startingAmount;
     }
     
     public int bet(int currentAmount){
          Scanner input = new Scanner(System.in);
          int bettingAmount = 0;
          do{
               System.out.println("Betting amount (0 ~ " + currentAmount + "): ");
               bettingAmount = input.nextInt();
          }while(bettingAmount > currentAmount);
          return bettingAmount;
     }
     
     public void currentCash(int currentAmount){
          System.out.println("You have $" + currentAmount +" in your pocket");
     }
     
     public void gameOver(){
          System.out.println("Game Over!");
     }
}