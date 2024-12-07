package edu.mtc.egr283.rb;

public class RecipeIngredient {
	private double quantity;
	private Ingredient ingredient;
	private Unit unit;
	
	private static final Integer minimumVal = Integer.MIN_VALUE;
	private static final String SPACE = " ";
	
	/**
	 * Default constructor; builds a constructor
	 * that values contain either the minimum value
	 * or 'null'.
	 */
	public RecipeIngredient()
	{
		this(null, null);
	}//end - default 'no-args' constructor
	
	/**
	 * Constructor that passes the ingredient and Unit, but
	 * leaves the quantity null.
	 * @param newIngredient ingredient that will be built with the constructor.
	 * @param newUnit unit that will be built with the constructor.
	 */
	public RecipeIngredient(Ingredient newIngredient, Unit newUnit)
	{
		this(minimumVal, newIngredient, newUnit);
	}//end - constructor(Ingredient, Unit)
	
	/**
	 * Constructor the builds the quantity of the ingredient,
	 * the unit, and the quantity of the ingredient.
	 * @param newQuantity quantity that of the ingredient that will be passed with the constructor.
	 * @param newIngredient ingredient that will be passed with constructor.
	 * @param newUnit unit that will be passed with the constructor.
	 */
	public RecipeIngredient(double newQuantity, Ingredient newIngredient, Unit newUnit)
	{
		this.setQuantity(newQuantity);
		this.setIngredient(newIngredient);
		this.setUnit(newUnit);
	}//end - constructor(Double, Ingredient, Unit)
	
	/**
	 * Accessor method to grab the
	 * quantity of the ingredient.
	 * @return the double Quantity of the ingredient.
	 */
	public double getQuantity()
	{
		return this.quantity;
	}//end - getQuantity
	
	/**
	 * Accessor method to grab the
	 * name of the ingredient needed.
	 * @return the necessary ingredient.
	 */
	public Ingredient getIngredient()
	{
		return this.ingredient;
	}//end - getIngredient
	
	/**
	 * Accessor method to grab the Unit of
	 * measurement needed for the ingredient.
	 * @return the unit of measurement.
	 */
	public Unit getUnit()
	{
		return this.unit;
	}//end - getUnit
	
	
	/**
	 * Mutator method to modify the unit of 
	 * measurement in question.
	 * @param newQuantity the new quantity needed in the RecipeIngredient.
	 */
	public void setQuantity(double newQuantity)
	{
		this.quantity = newQuantity;
	}//end - setQuantity
	
	
	/**
	 * Mutator method for modifying the ingredient
	 * @param newIngredient the new ingredient needed in the RecipeIngredient.
	 */
	public void setIngredient(Ingredient newIngredient)
	{
		this.ingredient = newIngredient;
	}//end - setIngredient
	
	/**
	 * Mutator method for modifying the unit
	 * @param newUnit the new unit needed for the RecipeIngredient
	 */
	public void setUnit(Unit newUnit)
	{
		this.unit = newUnit;
	}//end - setQuantity
	
	/**
	 * Standard toString method
	 * @return the toString of the StringBuffer appending the recipe.
	 */
	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		//Null pointer check
		if(this.getIngredient() != null && this.getUnit() != null)
		{
			sb.append(this.getQuantity() + RecipeIngredient.SPACE);
			sb.append(this.getUnit() + RecipeIngredient.SPACE);
			sb.append(this.getIngredient());
		}else
		{
			sb.append("Ingredient or Unit is NULL");
		}//end - if/else statement
		
		return sb.toString();
	}//end - toString
	
}//end - class RecipeIngredient
