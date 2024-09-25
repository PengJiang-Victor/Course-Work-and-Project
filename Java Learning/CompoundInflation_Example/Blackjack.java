package edu.nyu.cs;

import java.util.Scanner;

/**
 * A variation of the game of Blackjack.  
 * Complete this program according to the instructions in the README.md file as well as within the given comments below.
 */
public class Blackjack {

  /**
   * The main function is automatically called first in a Java program.
   * 
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) throws Exception {
    int UserCard1 = CardNumberGenerater();
    int UserCard2 = CardNumberGenerater();

    System.out.println("Welcome to black jack!");
    System.out.println("Your cards are: "+ UserCard1 + ", " + UserCard2);


    int[] Cards = new int[100];
    int index =2;
    Cards[0] = UserCard1;
    Cards[1] = UserCard2;
    Scanner scnr = new Scanner(System.in);
    
    //User:
    while (true) {
      
      System.out.println("Would you like to hit or stand? ");
      String input = scnr.nextLine();
      
      if (input.equals("stand")){
        break;
      }

      if (input.equals("hit")){
        Cards[index] = CardNumberGenerater();
        index++;
        OutPutNumberUser(index, Cards);
        if (BustOrNot(index, Cards)){
          break;
        }     
      }
    }
    // System.out.println(SumCards(index, Cards)); //test of sum of user's cards

    if (BustOrNot(index, Cards)){
      System.out.println("You have bust!");
      System.out.println("Dealer wins!");
    }
    else{ //the situation when player has not bust, then goes to dealer's round and output of result.
      //Dealer:
      int DealerCard1 = CardNumberGenerater();
      int DealerCard2 = CardNumberGenerater();
      int[] Cards2 = new int[100];
      int index2 =2;
      Cards2[0] = DealerCard1;
      Cards2[1] = DealerCard2;

      if (DealerCard1+DealerCard2<21) {
        while (true) {
          //dealer's decision is somehow depend on the cards of player
          if (SumCards(index2, Cards2)<21) {
            if (SumCards(index2, Cards2)<SumCards(index, Cards)){
              System.out.println("The dealer hits");
              Cards2[index2]= CardNumberGenerater();
              index2++;
            }
            else{
              System.out.println("The dealer stands");
              break;
            }
          }
          else if(SumCards(index2, Cards2)==21){
            System.out.println("The dealer stands");
              break;
          }
          else {
            if (Math.random()<1){//probability that dealer bust (we can set the probability for dealer to bust to increase or decrease the rate at which player wins.)
              System.out.println("The dealer stands");
              break;
            }
            else{//1-probability that dealer bust = probability that dealer won't bust (in this case player have to win by being larger than dealer's cards before the last one in the dealer's array, since the last one is taken out from the array)
              System.out.println("The dealer stands");
              Cards2[index2-1]= 0;
              index2--;
              break;
            }
          }//for this one we can set the probability for the dealer to bust

        }
          
      }
      else {
        System.out.println("The dealer stands.");
      }
      
      // System.out.println(SumCards(index2, Cards2)); /test of sum of dealer's cards

      //output of card numbers:
      OutPutNumberUser(index, Cards);
      OutPutNumberDealer(index2, Cards2);
      
      //test
      // for (int i=0; i<index2+3; i++) {
      //   System.out.print("Dealer: "+ Cards2[i]+ " ");
      // }
      
      //output of result:
      if (BustOrNot(index2, Cards2)){
        System.out.println("The dealer has bust!");
        System.out.println("You win!");
      }
      else{
        if (SumCards(index, Cards) == SumCards(index2, Cards2)){
          System.out.println("Tie!");
        }

        if (SumCards(index2, Cards2) > SumCards(index, Cards)){
          System.out.println("Dealer wins!");
        }

        if (SumCards(index2, Cards2) < SumCards(index, Cards)){
          System.out.println("You win!");
        }
      }
    }

    scnr.close();// why I have to create a scanner outside of while loop and close it outside the while loop?**


  } // main



  //methods:
  public static void OutPutNumberUser(int index, int[] Cards){
    System.out.print("Your cards are: ");
    for (int i=0; i<index-1; i++){
      System.out.print(Cards[i]+", ");
    }
    System.out.print("and " + Cards[index-1]+"\n");
    
  }
  
  public static void OutPutNumberDealer(int index, int[] Cards){
    System.out.print("The dealer's cards are: ");
    for (int i=0; i<index-1; i++){
      System.out.print(Cards[i]+", ");
    }
    System.out.print("and " + Cards[index-1]+"\n");
    
  }

  public static boolean BustOrNot(int index, int[] Cards){
    boolean a;
    if (SumCards(index,Cards) > 21){
      a = true;
    }
    else{
      a =false;
    }
    return a;
  }


  public static int CardNumberGenerater() {

    int Cardnumber =(int)(Math.random()*10 + 2);
    return Cardnumber;

  }

  public static int SumCards(int index, int[]Cards) {
    
    int sum = 0;
    for (int i=0; i<index; i++){
      sum += Cards[i];
    }
    return sum;
  }

}
