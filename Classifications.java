/**
 * this enum clarifies the 9 possible classifications of a hand
 * 
 * @author name: 
 * @author login name:
 * @author Student ID: 
 * 
 */
public enum Classifications {
	/**
	 * it represents a Straight Flush
	 * <br> for example  "3D 4D 5D 6D 7D"
	 */
	Straightflush("%s-high straight flush"),
	
	/**
	 * it represents a Four of a kind
	 * <br> for example  "3D 3D 3D 3C 7D"
	 */
	Fourofakind("Four %ss"),
	
	/**
	 * it represents a Full house
	 * <br> for example  "3D 3D 3C 7S 7D"
	 */
	Fullhouse("%ss full of %ss"),
	
	/**
	 * it represents a Flush
	 * <br> for example  "3D 5D 6D TD KD"
	 */
	Flush("%s-high flush"),
	
	/**
	 * it represents a Straight 
	 * <br> for example  "3C 4S 5D 6D 7H"
	 */
	Straight("%s-high straight"),
	
	/**
	 * it represents a Three of a kind
	 * <br> for example  "3D 3S 3H 6D TD"
	 */
	Threeofakind("Three %ss"),
	
	/**
	 * it represents a Two Pair
	 * <br> for example  "3D 3S 5D 6H 7D"
	 */
	Twopair("%ss over %ss"),
	
	/**
	 * it represents a One Pair
	 * <br> for example  "3D 4D 5D 7H 7D"
	 */
	Onepair("Pair of %ss"),
	
	/**
	 * it represents a High Card
	 * <br> for example  "3D 4H 5S 7D AC"
	 */
	Highcard("%s-high");
	
	
	/**
	 * this is a constructor accept a description to create a new rank
	 * @param description  this is used to describe the classification
	 */
	private Classifications(String description) {
		this.description=description;
	}
	
	/** Cache the description for the classification */
	private String description;
	
	/**
	 * Returns a string representation of the classification. 
	 * The {@code toString} method for class {@code classification} 
	 * returns a string of the classification description.
	 * @return a string representation of the classification.
	 * @see #description
	 */
	public String toString(){
		return this.description;
	}
	
	
	
}
