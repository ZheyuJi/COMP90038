
/**
 * this class contains the main method and it is the entrance of the
 * program
 * 
 * this program accepts command line parameters that represents cards of a
 * poker game. if there are only 5 cards, or one player, this program just
 * give the information of the player's hand. if there are more than one
 * player, this program will the give the information of there hands, and
 * then compare their hand and give the winners' information after their
 * hands' information.
 * 
 * @author name: 
 * @author login name:
 * @author Student ID:
 * 
 */

public class Poker {
    public static void main(String[] args) {
        Game game = new Game(args);
        System.out.print(game);

    }
}
