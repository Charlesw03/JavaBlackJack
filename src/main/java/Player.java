/**
 * Created by Charlesw03 on 5/28/2019.
 */
//blackjack Player
public class Player {
    private String name;
    private Card[] hand = new Card[10];
    private int numberOfCardsInHand;

    public Player(String name) {
        this.name = name;
        //default hand for a player is nothing...hense emptyhand
        this.emptyHand();
    }

    public void emptyHand() {
        for (int c = 0; c < 10; c++) {
            this.hand[c] = null;
        }
        this.numberOfCardsInHand = 0;
    }

    public boolean addCard(Card aCard) {
        //print an error if you have more then 10 cards
        if (this.numberOfCardsInHand == 10) {
            System.err.printf("%s's hand already has 10 cards; " + " cant add anymore\n", this.name);
            System.exit(1);
        }
        this.hand[this.numberOfCardsInHand] = aCard;
        this.numberOfCardsInHand++;
        return (this.getHandSum() <= 21);
    }

    public int getHandSum() {
        int handSum = 0;
        int cardNum;
        int numAces = 0;

        for (int c = 0; c < this.numberOfCardsInHand; c++) {
            cardNum = this.hand[c].getNumber();
            if (cardNum == 1) {
                //Ace in the hole
                numAces++;
                handSum += 11;
            } else if (cardNum > 10) {
                //face cards
                handSum += 10;
            } else {
                handSum += cardNum;
            }
        }

        // if the sum of our black jack hand is greater then 21 and we have aces, switch the aces to 1 instead of 11.
        while (handSum > 21 && numAces > 0) {
            handSum -= 10;
            numAces--;
        }
        return handSum;

    }
//print cards in the hand and if we want the first card to be shown or not
    public void printHand(boolean showFirstCard){
        System.out.printf("%s's cards:\n",this.name);
        for (int c = 0; c < this.numberOfCardsInHand ; c++) {
            if(c==0 && !showFirstCard ){
                System.out.println("[hidden]");
            } else{
                System.out.printf(" %s\n", this.hand[c].toString());
            }
        }
    }



}
