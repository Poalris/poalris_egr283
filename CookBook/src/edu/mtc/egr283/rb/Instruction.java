package edu.mtc.egr283.rb;

public class Instruction {

	private String instructions;
	
	public Instruction()
	{
		this(null);
	}//end - default 'No-Args' constructor
	
	public Instruction(String newInstructions)
	{
		this.setInstructions(newInstructions);
	}//end - constructor(String)
	
	/**
	 * Accessor method that grabs the instructions of the recipe
	 * without calling the variable itself.
	 * @return the string for the instructions to the recipe.
	 */
	public String getInstructions()
	{
		return this.instructions;
	}//end - getInstructions
	
	
	/**
	 * Mutator Method that sets the new instructions for the
	 * recipe. 
	 * @param newInstructions the new instructions for the recipe.
	 */
	public void setInstructions(String newInstructions)
	{
		this.instructions = newInstructions;
	}//end - setInstructions
	
	/**
	 * Standard toString method to display the string of the instructions.
	 * @return the String(s) listing off the instructions.
	 */
	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		//null pointer check
		if(this.getInstructions() != null)
		{
			sb.append(this.getInstructions());
		}else
		{
			sb.append("No instructions for this Recipe!");
		}//end - if/else statement
		return sb.toString();
	}//end - toString(Overridden)
}//end - class Instruction
