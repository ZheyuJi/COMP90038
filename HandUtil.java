import java.util.ArrayList;

/**
 * This class contains various methods for manipulating Hands (such as to
 * determine whether a hand belongs to a classification, and to define a
 * hand).
 * 
 * @author name: 
 * @author login name:
 * @author Student ID:
 * 
 */
public class HandUtil {

    /**
     * use this method to decide a hand is a straight-Flush or not
     * 
     * @param h
     *            h is the hand need to be classify
     * @return the result whether h is a Straight-Flush
     * 
     * @see #isFlush(Hand)
     * @see #isStraight(Hand)
     */
    private static boolean isStraightFlush(Hand h) {
        /*
         * a Straight Flush should be a straight and a flush
         */
        return isStraight(h) && isFlush(h);
    }

    /**
     * use this method to decide a hand is a Four of a kind or not
     * 
     * @param h
     *            h is the hand need to be classify
     * @return the result whether h is a Four of a kind
     * @see #n_of_a_kind(Hand)
     */
    private static boolean isFourOfAKind(Hand h) {
        /*
         * a Four of a Kind should like "AAAAA" or "AAAAB" or "BAAAA"\ it
         * is 5 of a kind or 4 of a kind
         */
        return n_of_a_kind(h) >= 4;
    }

    /**
     * use this method to decide a hand is a Full house or not
     * 
     * @param h
     *            h is the hand need to be classify
     * @return the result whether h is a Full house
     * @see #n_of_a_kind(Hand)
     * @see #countPair(Hand)
     */
    private static boolean isFullHouse(Hand h) {
        /*
         * a Full house should like "AAABB" or "BBBAA" it is 3 of a kind,
         * and the countPair will return 3
         */
        return n_of_a_kind(h) == 3 && countPair(h) == 3;
    }

    /**
     * use this method to decide a hand is a Flush or not
     * 
     * @param h
     *            h is the hand need to be classify
     * @return the result whether h is a Flush
     * @see #isFlush(Hand)
     * @see #isStraight(Hand)
     */
    private static boolean isOnlyFlush(Hand h) {
        /*
         * a Flush should be a Flush and should not be a Straight, but it
         * can be omitted here bases on the sequence in the method
         * defineHand
         */
        return isFlush(h) /* && !isStraight(h) */;
    }

    /**
     * use this method to decide a hand is a Straight or not
     * 
     * @param h
     *            h is the hand need to be classify
     * @return the result whether h is a Straight
     * @see #isFlush(Hand)
     * @see #isStraight(Hand)
     */
    private static boolean isOnlyStraight(Hand h) {
        /*
         * a Straight should be a Straight and should not be a Flush, but
         * it can be omitted here bases on the sequence in the method
         * defineHand
         */
        return isStraight(h) /* && !isFlush(h) */;
    }

    /**
     * use this method to decide a hand is a Three of a kind or not
     * 
     * @param h
     *            h is the hand need to be classify
     * @return the result whether h is a Three of a kind
     * @see #n_of_a_kind(Hand)
     * @see #countPair(Hand)
     * @see #isFlush(Hand)
     */
    private static boolean isThreeOfAKind(Hand h) {
        /*
         * a Three of a kind should like "AAABC" or "BAAAC" or "BCAAA" it
         * should not be a Flush, but it can be omitted here bases on the
         * sequence in the method defineHand it is 3 of a kind, and
         * countPair should return 2
         */
        return n_of_a_kind(h) == 3
                && countPair(h) == 2 /* && !isFlush(h) */;
    }

    /**
     * use this method to decide a hand is a Two Pair or not
     * 
     * @param h
     *            h is the hand need to be classify
     * @return the result whether h is a Two Pair
     * @see #n_of_a_kind(Hand)
     * @see #countPair(Hand)
     * @see #isFlush(Hand)
     */
    private static boolean isTwoPair(Hand h) {
        /*
         * a Two Pair should like "AABBC" or "AACBB" or "CAABB" it should
         * not be a Flush, but it can be omitted here bases on the sequence
         * in the method defineHand it is 2 of a kind and countPair should
         * return 2
         */
        return n_of_a_kind(h) == 2
                && countPair(h) == 2 /* && !isFlush(h) */;
    }

    /**
     * use this method to decide a hand is a One Pair or not
     * 
     * @param h
     *            h is the hand need to be classify
     * @return the result whether h is a One Pair
     * @throws <i>MyException
     *             MyException will be thrown if a hand can not be defined
     *             to a classification</i>
     * @see #n_of_a_kind(Hand)
     * @see #countPair(Hand)
     * @see #isFlush(Hand)
     */
    private static boolean isOnePair(Hand h) {
        /*
         * a One Pair should like "AABCD" or "BAACD" or "BCAAD" or "BCDAA"
         * it should not be a Flush, but it can be omitted here bases on
         * the sequence in the method defineHand it is 2 of a kind and
         * countPair should return 1
         */
        return n_of_a_kind(h) == 2
                && countPair(h) == 1 /* && !isFlush(h) */;
    }

    /**
     * use this method to decide a hand is a High Card or not
     * 
     * @param h
     *            h is the hand need to be classify
     * @return the result whether h is a High Card
     * @see #n_of_a_kind(Hand)
     * @see #isStraight(Hand)
     * @see #isFlush(Hand)
     */
    private static boolean isHighCard(Hand h) {
        /*
         * a High Card should like "ABCDE" it should not be a Flush or a
         * Straight, but it can be omitted here bases on the sequence in
         * the method defineHand it is 1 of a kind
         */
        return n_of_a_kind(h) == 1 /* && !isFlush(h) && !isStraight(h) */;
    }

    /**
     * the static method {@code defineHand} in class {@code HandUtil}
     * defines the hand by setting the Hand with Classifications, c1, and
     * c2
     * 
     * @param h
     *            h is the hand need to be defined
     * @see Hand#setClassifications(Classifications)
     * @see Hand#setC1(Card)
     * @see Hand#setC2(Card)
     */
    public static void defineHand(Hand h) {
        /*
         * the cards array in the hand has been sorted when creating the
         * hand first decide what classification does the hand belongs to.
         * then set the c1 and c2 of the hand.
         */
        if (isStraightFlush(h)) {
            /*
             * c1 should be the largest card, or the 5th card
             */
            h.setClassifications(Classifications.Straightflush);
            h.setC1(h.getCards()[4]);
            return;
        } else if (isFourOfAKind(h)) {
            /*
             * "AAAAA" or "AAAAB" or "BAAAA" c1 is always the 3rd card
             */
            h.setClassifications(Classifications.Fourofakind);
            h.setC1(h.getCards()[2]);
            return;
        } else if (isFullHouse(h)) {
            /*
             * "AAABB" or "BBAAA" c1 is always the 3rd card if cards[0]'s
             * rank = cards[2]'s rank, c2 should be card[4] if cards[0]'s
             * rank != cards[2]'s rank, c2 should be card[0]
             */
            h.setClassifications(Classifications.Fullhouse);
            h.setC1(h.getCards()[2]);
            h.setC2((h.getCards()[0].getRank() == h.getCards()[2].getRank()
                    ? h.getCards()[4] : h.getCards()[0]));
            return;
        } else if (isOnlyFlush(h)) {
            /*
             * c1 should be the largest card, or the 5th card
             */
            h.setClassifications(Classifications.Flush);
            h.setC1(h.getCards()[4]);
            return;
        } else if (isOnlyStraight(h)) {
            /*
             * c1 should be the largest card, or the 5th card
             */
            h.setClassifications(Classifications.Straight);
            h.setC1(h.getCards()[4]);
            return;
        } else if (isThreeOfAKind(h)) {
            /*
             * "AAABC" or "BAAAC" or "BCAAA" c1 is always the 3rd card
             */
            h.setClassifications(Classifications.Threeofakind);
            h.setC1(h.getCards()[2]);
            return;
        } else if (isTwoPair(h)) {
            /*
             * first use method getPair to get the cards that has a sibling
             * in the hands then set the cards as c1 and c2, c1 is bigger
             * than c2
             */
            h.setClassifications(Classifications.Twopair);
            ArrayList<Card> tempc = getPair(h);
            h.setC1(tempc.get(1));
            h.setC2(tempc.get(0));
            return;
        } else if (isOnePair(h)) {
            /*
             * first use method getPair to get the card that has a sibling
             * in the hands then set the card as c1
             */
            h.setClassifications(Classifications.Onepair);
            ArrayList<Card> tempc = getPair(h);
            h.setC1(tempc.get(0));
            return;
        } else if (isHighCard(h)) {
            /*
             * c1 should be the largest card, or the 5th card
             */
            h.setClassifications(Classifications.Highcard);
            h.setC1(h.getCards()[4]);
            return;
        } else {
            /*
             * if a hand could not find a classification, then throws the
             * exception
             */
            throw new MyException("BAD DIFINE CODE");
        }

    }

    /**
     * The method {@code isStraight} in the class {@code HandUtil}
     * determines whether the hand is a Straight, regardless if it is a
     * Flush or not
     * 
     * @param h
     *            h is the hand need to decide
     * @return the result whether h is a Straight regardless if it is a
     *         Flush or not
     */
    private static boolean isStraight(Hand h) {
        /*
         * if there is a card's rank value is not bigger than its neighbor
         * ahead or the difference is not 1 , then returns false. else
         * returns true
         */
        Card cards[] = h.getCards();
        int value = cards[0].getRankValue();
        for (Card c : cards) {
            if ((c.getRankValue()) != value++) {
                return false;
            }
        }
        return true;
    }

    /**
     * The method {@code isFlush} in the class {@code HandUtil} determines
     * whether the hand is a Flush, regardless if it is a Straight or not
     * 
     * @param h
     *            h is the hand need to decide
     * @return the result whether h is a Flush regardless if it is a
     *         Straight or not
     */
    private static boolean isFlush(Hand h) {
        /*
         * if there is a cards' suit is not same with the first card,
         * return false else return true
         */
        Card cards[] = h.getCards();
        Suits s = cards[0].getSuit();
        for (Card c : cards) {
            if (c.getSuit() != s) {
                return false;
            }
        }
        return true;
    }

    /**
     * The method {@code isFlush} in the class {@code HandUtil} returns the
     * number of the largest number of the cards have same rank <br>
     * for example "AAAAB" returns 4 ; "AAABB" returns 3; "ABCDE" returns 1
     * 
     * @param h
     *            h is the hand need to decide
     * @return the number of the largest number of the cards have same rank
     * @see Card#getRankValue()
     */
    private static int n_of_a_kind(Hand h) {
        /*
         * first, get the cards array in the hand.
         * then go through the card array, find the rank that most card
         * have, and record how many card has this rank
         */
        Card cards[] = h.getCards();
        int n = 0;
        int count = 1;
        int value = cards[0].getRankValue();
        for (int i = 1; i < cards.length; i++) {
            if ((cards[i].getRankValue()) == value) {
                count++;
            } else {
                value = cards[i].getRankValue();
                n = (n >= count ? n : count);
                count = 1;
            }
        }
        return n >= count ? n : count;
    }

    /**
     * The method {@code countPair} in the class {@code HandUtil} returns
     * the number of how many card the rank of which is the same with its
     * ahead neighbor <br>
     * for example, "AAABB" returns 3, "AAAAB" returns 3 "AABBC" returns 2,
     * "ABCDE" returns 0
     * 
     * @param h
     *            h is the hand need to decide
     * @return the number of how many card the rank of which is the same
     *         with its ahead neighbor
     * @see Card#getRankValue()
     */
    private static int countPair(Hand h) {
        /*
         * first initialize the lastRankValue for every card in the cards
         * array if the next card's rank value = lastRankValue, count++
         * assign the lastRankValue with the new value.
         */
        Card cards[] = h.getCards();
        int count = 0;
        int lastRankValue = -1;
        for (Card c : cards) {
            if (c.getRankValue() == lastRankValue) {
                count++;
            }
            lastRankValue = c.getRankValue();
        }
        return count;
    }

    /**
     * The method {@code gettPair} in the class {@code HandUtil} returns an
     * ArrayList stores the cards the value of which can mapped to more
     * than one card in the card array <br>
     * for example, "AAABB" will return an ArrayList stores "AAB", <br>
     * "AAAAB" will return an ArrayList stores "AAA", <br>
     * "AABCC" will return an ArrayList stores "AC", <br>
     * "AABCD" will return an ArrayList stores "A", <br>
     * "ABCED" will return an empty ArrayList,
     * 
     * @param h
     *            h is the hand need to decide
     * @return an ArrayList stores the cards the value of which can mapped
     *         to more than one card in the card array
     * @see Card#getRankValue()
     */
    public static ArrayList<Card> getPair(Hand h) {
        /*
         * first initialize the lastRankValue for every card in the cards
         * array if the next card's rank value = lastRankValue, add the
         * card to the ArrayList assign the lastRankValue with the new
         * value.
         */
        Card cards[] = h.getCards();
        int last = -1;
        ArrayList<Card> tempc = new ArrayList<Card>();
        for (Card c : cards) {
            if (c.getRankValue() == last) {
                tempc.add(c);
            }
            last = c.getRankValue();
        }
        return tempc;
    }
}