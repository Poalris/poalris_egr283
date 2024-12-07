package edu.mtc.egr283.rb;

public class Ingredient {
	
	private String name;
	
	public Ingredient()
	{
		this(null);
	}//end - default 'no-args' constructor
	
	public Ingredient(String newName)
	{
		this.setName(newName);
	}//end - constructor
	
	/**
	 * Accessor method of grabbing the name of the ingredient
	 * @return the name of the ingredient.
	 */
	public String getName()
	{
		return this.name;
	}//end - getName
	
	/**
	 * Mutator method modifying the name of the ingredient.
	 * @param newName the name replacing the old name of the ingredient.
	 */
	public void setName(String newName)
	{
		this.name = newName;
	}//end - setName
	
	/**
	 * Standard toString method; builds a string for the class
	 * ingredient.
	 * @return the toString of a StringBuffer containing the
	 * name of the Ingredient. 
	 */
	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		//Null pointer check
		if(name != null)
		{
			sb.append(this.getName());
		}else
		{
			sb.append("No ingredients given");
		}//end - if/else statement
		return sb.toString();
	}//end - toString(Overridden)
	
}//end - class Ingredient
