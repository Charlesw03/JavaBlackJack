/**
 * Created by Charlesw03 on 5/28/2019.
 */

import java.util.Random;


public class Deck {
    //top card is the first position in the array
    private Card[] myDeck;
    private int numberOfCards;

    //constructor of a deck without shuffling
    public Deck() {
        this(1, false);
    }


    //this constructor defines the number of decks available and if its shuffled or not
    // numberOfDecks is the individual number of how many decks are in play. (casinos have a bunch sometimes)
    // shuffle = is the deck shuffled or not
    public Deck(int numberOfDecks, boolean shuffle) {
        //initial card index (first card)
        int c = 0;
        this.numberOfCards = numberOfDecks * 52;
        this.myDeck = new Card[this.numberOfCards];

        for (int d = 0; d < numberOfDecks; d++) {
            for (int s = 0; s < 4; s++) {
                for (int n = 1; n <= 13; n++) {
                    this.myDeck[c] = new Card(Suit.values()[s], n);
                    c++;
                }
            }
        }
        if (shuffle) {
            this.shuffle();
        }
    }

    public void shuffle() {
        Random randomNum = new Random();

        Card temp;

        int tempPosition;

        for (int i = 0; i < this.numberOfCards; i++) {
            //get a random card to swap with the temp position
            tempPosition = randomNum.nextInt(this.numberOfCards);

            temp = this.myDeck[i];
            this.myDeck[i] = this.myDeck[tempPosition];
            this.myDeck[tempPosition] = temp;

        }


    }

    public Card dealNextCard() {
        //dealing the top card
        Card top = this.myDeck[0];
        //shift the cards in the deck(array) up 1(shift the postions in the array left by 1)
        for (int cards = 1; cards < this.numberOfCards; cards++) {
            this.myDeck[cards - 1] = this.myDeck[cards];
        }

        this.myDeck[this.numberOfCards - 1] = null;
        //decrement the number of cards in the deck
        this.numberOfCards--;

        return top;


    }

    //printing the cards
    public void printDeck(int numToPrint) {
        for (int c = 0; c < numToPrint; c++) {
            System.out.printf("% 3d/%d %s\n", c + 1, this.numberOfCards, this.myDeck[c].toString());
        }
        System.out.printf("\t[%d others]\n", this.numberOfCards-numToPrint);
    }
}
