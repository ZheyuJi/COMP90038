/**
 * an instance of class {@code Card} represents a card in a Poker game.
 * 
 * @author name: 
 * @author login name:
 * @author Student ID:
 * 
 */
public final class Card implements Comparable<Card> {
    /** Cache the suit for the card */
    private Suits suit;

    /** Cache the rank for the card */
    private Ranks rank;

    /**
     * this is a void constructor;
     */
    public Card() {
        super();

    }

    /**
     * create a new card, with the information given by a String s.
     * 
     * @param s
     *            s is a String has two Characters, the first one
     *            represents rank and the second one represent suit. For
     *            example, "4D" will give a new card that rank is 4 and
     *            suit is Diamonds.
     */
    public Card(String s) {
        /*
         * use the first char of the string s to get the rank of the card
         * use the second char of the string s to get the rank of the card
         * if there is a exception, catch it and print the information
         */
        try {
            this.suit = Suits.valueOf(("" + s.charAt(1)).toUpperCase());
            this.rank = Ranks.valueOf(("_" + s.charAt(0)).toUpperCase());
        } catch (RuntimeException e) {
            System.out.println("Error: invalid card name '" + s + "'");
            System.exit(0);
        }
    }

    /**
     * use this method to get the rank's value of this card
     * 
     * @return the rank's value of this card
     */
    public int getRankValue() {
        return this.rank.getValue();
    }

    /**
     * use this method to get the suit of the card
     * 
     * @return the suit of the card
     */
    public Suits getSuit() {
        return suit;
    }

    /**
     * use this method to get the rank of the card
     * 
     * @return the rank of the card
     */
    public Ranks getRank() {
        return rank;
    }

    /**
     * the {@code compareTo} method for class {@code Card} returns the
     * comparison result of this card and another Card c <br>
     * it actually just compare the rank of the card <br>
     * if the result > 0 this card is bigger than c <br>
     * if the result = 0 this card is equal to c <br>
     * if the result < 0 this card is smaller than c
     * 
     * @see Ranks#compareTo
     * @param c
     *            c is the card need to be compared
     * @return the result of comparison to c.
     */
    public int compareTo(Card c) {
        return this.rank.compareTo(c.rank);
    }

    /**
     * Returns a string representation of the card. The {@code toString}
     * method for class {@code Card} returns a string consisting of the
     * suit and rank of the Card
     * 
     * @return a string representation of the card.
     * @see Suits#toString()
     * @see Ranks#toString()
     */
    public String toString() {
        return rank.toString();
    }
}
