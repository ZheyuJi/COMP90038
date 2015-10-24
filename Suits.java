/**
 * this enum clarifies the 4 possible Suits of a card
 *
 * @author name: 
 * @author login name:
 * @author Student ID:
 * 
 */

public enum Suits {

    /**
     * it represents the suit Club
     */
    C("Clubs"),

    /**
     * it represents the suit Diamond
     */
    D("Diamonds"),

    /**
     * it represents the suit Heart
     */
    H("Hearts"),

    /**
     * it represents the suit Spade
     */
    S("Spades");

    /** Cache the name of the Suit */
    private String name;

    /**
     * this is a constructor accept a name to create a suit
     * 
     * @param name
     *            name is the name of the suit
     */
    Suits(String name) {
        this.name = name;
    }

    /**
     * use the method to get the name of the suit
     * 
     * @return the name of the suit
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a string representation of the Suit. The {@code toString}
     * method for class {@code Suit} returns a string of the suit's name
     * 
     * @return a string representation of the suit.
     * 
     * @see #name
     */
    public String toString() {
        return name;
    }

}
