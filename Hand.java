
import java.util.Arrays;

/**
 * an instance of class {@code Hand} represents a Hand in a Poker game. 
 * one hand have 5 cards and a classification determined by its 5 cards.
 * one hand also has int value to store the player's number of this hand.
 * 
 * @author name: 
 * @author login name:
 * @author Student ID:
 * 
 */

public class Hand implements Comparable<Hand> {
    /** Cache the classification for the Hand */
    private Classifications classifications;

    /** Cache the number of the player for the Hand */
    private int playerNumber;

    /** Cache the dominate card for the Hand */
    private Card c1;

    /**
     * Cache the second-dominate c2 for the Hand if there is not a c2, it
     * should be null
     */
    private Card c2;

    /** Cache the 5 cards in the Hand */
    private Card[] cards = new Card[5];

    /**
     * this is a void constructor;
     */
    Hand() {
        super();
    }

    /**
     * this is a constructor of class {@code Hand} accept a string array s
     * to generate the classification, playerNumber, r1, r2 and cards in
     * the Hand.
     * 
     * @see HandUtil#defineHand(Hand)
     * @param s
     */
    Hand(String[] s) {
        this.cards = getCardsArray(s);
        HandUtil.defineHand(this);
    }

    /**
     * use this method to set the classifications
     * 
     * @param classifications
     */
    public void setClassifications(Classifications classifications) {
        this.classifications = classifications;
    }

    /**
     * use this method to set the c1
     * 
     * @param c1
     * @see #c1
     */
    public void setC1(Card c1) {
        this.c1 = c1;
    }

    /**
     * use this method to set the r2
     * 
     * @param c2
     * @see #c2
     */
    public void setC2(Card c2) {
        this.c2 = c2;
    }

    /**
     * use this method to get the cards array
     * 
     * @return Card[]
     * @see #cards
     */
    public Card[] getCards() {
        return cards;
    }

    /**
     * use this method to set the playerNumber
     * 
     * @see #playerNumber
     * @param playerNumber
     */
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    /**
     * use this method to get the playerNumber
     * 
     * @see #playerNumber
     * @return playerNumber
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * this method {@code getCardsArray} in class {@code Hand} accept a
     * string array s of length 5 to generate an array store 5 cards <br>
     * 
     * @param s
     * @return cards cards is the cards array that has been sorted.
     * @see Card#Card(String)
     * @see Card#compareTo(Card)
     */
    public Card[] getCardsArray(String[] s) {
        Card[] cards = new Card[5];
        for (int i = 0; i < s.length; i++) {
            cards[i] = new Card(s[i]);
        }
        Arrays.sort(cards);
        return cards;
    }

    /**
     * Returns a string representation of the Hand. The {@code toString}
     * method for class {@code Hand} returns a string consisting of the
     * Player Number and description of the Hand's classification
     * 
     * @return a string representation of the card.
     * @see #playerNumber
     */
    public String toString() {
        return "Player " + playerNumber + ": "
                + String.format(classifications.toString(), c1, c2);
    }

    /**
     * the {@code compareTo} method for class {@code Hand} returns the
     * comparison result of this card and another Hand h <br>
     * if the result > 0 this Hand is bigger than h <br>
     * if the result = 0 this Hand is equal to h <br>
     * if the result < 0 this Hand is smaller than h
     * 
     * @see Card#compareTo(Card)
     * @param h
     *            h is the hand need to be compared
     * @return the result of comparison to h.
     */
    public int compareTo(Hand h) {
        /*
         * compare the classification in reverse order because the first
         * classification is the biggest, if equals compare the first
         * dominate card c1, if equals, compare the second dominate card
         * c2, if equals, compare the whole cards array from the largest to
         * smallest.
         * 
         */
        if (this.classifications.compareTo(h.classifications) != 0) {
            return -(this.classifications.compareTo(h.classifications));
        } else if (this.c1.compareTo(h.c1) != 0) {
            return this.c1.compareTo(h.c1);
        } else if (c2 != null && this.c2.compareTo(h.c2) != 0) {
            return this.c2.compareTo(h.c2);
        } else {
            for (int i = this.cards.length - 1; i >= 0; i--) {
                if (this.cards[i].compareTo(h.cards[i]) != 0) {
                    return this.cards[i].compareTo(h.cards[i]);
                }
            }
        }
        return 0;
    }

}
