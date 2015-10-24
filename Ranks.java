/**
 * this enum clarifies the 13 possible ranks of a card
 * 
 * @author name: 
 * @author login name:
 * @author Student ID:
 * 
 */
public enum Ranks {
	/**
	 * it represents a rank with value 2
	 */
	_2("2",2),
	
	/**
	 * it represents a rank with value 3
	 */
	_3("3",3), 
	
	/**
	 * it represents a rank with value 4
	 */
	_4("4",4), 
	
	/**
	 * it represents a rank with value 5
	 */
	_5("5",5),
	
	/**
	 * it represents a rank with value 6
	 */
	_6("6",6),  
	
	/**
	 * it represents a rank with value 7
	 */
	_7("7",7),
	
	/**
	 * it represents a rank with value 8
	 */
	
	_8("8",8), 
	/**
	 * it represents a rank with value 9
	 */
	_9("9",9),
	
	/**
	 * it represents a rank with value 10
	 */
	_T("10",10), 
	
	/**
	 * it represents a rank with value Jack
	 */
	_J("Jack",11),
	
	/**
	 * it represents a rank with value Queen
	 */
	_Q("Queen",12),
	
	/**
	 * it represents a rank with value King
	 */
	_K("King",13), 
	
	/**
	 * it represents a rank with value Ace
	 */
	_A("Ace",14);
	
	/** Cache the name of the Rank */
	private String name;
	
	/** Cache the value for the card */
	private int value;
	
	/**
	 * this is a constructor accept a name and a value to create a new rank
	 * @param name  name is the name of the Rank
	 * @param value  value is the value of the Rank
	 */
	Ranks(String name, int value){
		this.name=name;
		this.value=value;
	}
	
	/**
	 * use the method to get the name of the rank
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * use the method to get the name of the rank
	 * @return value
	 */
	public int getValue(){
		return value;
	}
	
	/**
	 * Returns a string representation of the Rank. 
	 * The {@code toString} method for class {@code Rank} 
	 * returns a string of the rank's name
	 * @return a string representation of the card.
	 * @see #name
	 */
	public String toString(){
		return name;
	}
		
}
