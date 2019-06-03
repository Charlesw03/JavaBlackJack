/**
 * Created by Charlesw03 on 5/28/2019.
 */

import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deck myDeck = new Deck(1, true);
        Player me = new Player("Chalie");
        Player dealer = new Player("Dealer");
// deal 2 cards to the 2 players
        me.addCard(myDeck.dealNextCard());
        dealer.addCard(myDeck.dealNextCard());
        me.addCard(myDeck.dealNextCard());
        dealer.addCard(myDeck.dealNextCard());

        // print the initial hands
        System.out.println("Cards are dealt \n");
        me.printHand(true);
        System.out.println("\n");
        dealer.printHand(false);
        System.out.println("\n");

        //flags for when the players are done hitting
        boolean meDoneHit = false;
        boolean dealerDoneHit = false;
        String answer;

        while (!meDoneHit || !dealerDoneHit) {
            //players turn
            if (!meDoneHit) {
                System.out.print("Would you like to Hit or Stay (Enter H or S): ");
                answer = sc.next();
                System.out.println();

                //if player hits
                if (answer.compareToIgnoreCase("H") == 0) {
                    //add next card in the deck and store whether the player is busted
                    meDoneHit = !me.addCard(myDeck.dealNextCard());
                    me.printHand(true);

                } else {
                    meDoneHit = true;
                }
            }
            if (!dealerDoneHit) {
                if (dealer.getHandSum() < 17) {
                    System.out.println("the Dealer Hits\n");
                    dealerDoneHit = !dealer.addCard(myDeck.dealNextCard());
                    dealer.printHand(false);
                } else {
                    System.out.println("the Dealer stays\n");
                    dealerDoneHit = true;
                }
            }
            System.out.println();
        }
        //close scanner
        sc.close();

        //print final hands
        me.printHand(true);
        dealer.printHand(true);

        int mysum = me.getHandSum();
        int dealerSum = dealer.getHandSum();

        if (mysum > dealerSum && mysum <= 21 || dealerSum > 21) {
            System.out.println("\n You Win!!");
        } else {
            System.out.println("\n Dealer Wins");
        }

    }


}
