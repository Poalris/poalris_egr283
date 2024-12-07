package edu.mtc.egr283.rb;

public class Unit {
	
	private String name;
	
	/**
	 * Default Constructor for the Unit class.
	 */
	public Unit()
	{
		this(null);
	}//end - default 'no-args' constructor
	
	/**
	 * Constructor that has a string input, and it sets the
	 * unit of the recipe.
	 * @param newName modifies and replaces the current Unit
	 * with the new one.
	 */
	public Unit(String newName)
	{
		this.setName(newName);
	}//end - constructor
	
	
	/**
	 * Accessor method to grab the name of the unit.
	 * @return The unit of the String.
	 */
	public String getName()
	{
		return this.name;
	}//end - getName
	
	/**
	 * Mutator method to modify the name of the unit.
	 * @param newName inserts the new name for the String that is in question.
	 */
	public void setName(String newName)
	{
		this.name = newName;
	}//end - setName
	
	/**
	 * Standard toString method for displaying the string of
	 * the Unit 
	 * @return the string of the Unit class.
	 */
	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		//null pointer check
		if(name != null)
		{
			sb.append(this.getName());
		}else
		{
			sb.append("No listed unit of Measure!!");
		}//end - if/else statement
		return sb.toString();
	}//end - toString(Overridden)
	
}//end - class Unit
