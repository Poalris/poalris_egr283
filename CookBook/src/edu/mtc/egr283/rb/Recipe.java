package edu.mtc.egr283.rb;

public class Recipe {
	private String name;
	private DLL<RecipeIngredient> ingredients;
	private DLL<Instruction> instructions;
	
	/**
	 * Constructor for the Recipe; no 'null' default since it doesn't
	 * really matter in this case
	 * @param newName new Name of the recipe to be inserted in.
	 */
	public Recipe(String newName)
	{
		this.setName(newName);
		this.ingredients = new DLL<RecipeIngredient>();
		this.instructions = new DLL<Instruction>();
	}//end - constructor
	
	/**
	 * grabs the name of the Recipe
	 * @return the name of the recipe
	 */
	public String getName()
	{
		return this.name;
	}//end - getName
	
	/**
	 * Modifies the name of the recipe
	 * @param newName the new name of the recipe
	 */
	public void setName(String newName) 
	{
		this.name = newName;
	}//end - newName
	
	/**
	 * Normal overridden toString; displays the ingredients in the recipe
	 * as well as the instructions on how to make the recipe.
	 */
	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		
		if(this.ingredients.getHead() != null && this.instructions.getHead() != null)
		{
			sb.append("Name: " + this.getName());
			sb.append("\n\n");
			sb.append("Ingredients List: \n");
			for(int i = 0; i < this.sizeOfIngredients(); ++i)
			{
				sb.append(this.ingredients.get(i).toString() + "\n");
			}//end - for loop(ingredients)
			sb.append("\n");
			sb.append("Instructions list: \n");
			for(int i = 0; i < this.sizeOfInstructions(); ++i)
			{
				sb.append(i + ". " + this.instructions.get(i).toString() + "\n");
			}//end - for loop
		}//end - if statement
		return sb.toString();
	}//end - toString(Overridden)
	
	
	/**
	 * Standard toString method; only difference is that is displays just
	 * the Ingredients needed for the recipe.
	 * @return the String of Ingredients needed for the recipe.
	 */
	public String toStringIngredients()
	{
		StringBuffer sb = new StringBuffer();
		if(this.ingredients.getHead() != null)
		{
			sb.append("Ingredients for recipe " + this.getName() + "");
			for(int i = 0; i < this.sizeOfIngredients(); ++i)
			{
				sb.append(this.ingredients.get(i).toString() + "\n");
			}//end - for loop(ingredients)
		}//end - if statement
		return sb.toString();
	}//end - toStringIngredients
	
	/**
	 * Derivative of the toString method, where it displays only the Instructions
	 * for the Recipe.
	 * @return the toString of the instructions for how to make the recipe.
	 */
	public String toStringInstructions()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("Instructions for recipe " + this.getName() + " are: \n");
		for(int i = 0; i < this.sizeOfInstructions(); ++i)
		{
			sb.append(i + ". " + this.instructions.get(i).toString() + "\n");
		}//end - for loop
		return sb.toString();
	}//end - toStringInstructions
	
	//METHODS FOR DLL INGREDIENT
	
	/**
	 * Adds the ingredient at the head of the LinkedList, but also checks to see if the
	 * ingredient is in the list before adding.
	 * @param newIngredient new Ingredient to be added
	 */
	public void addIngredientAtHead(RecipeIngredient newIngredient)
	{
		RecipeIngredient cursor = this.ingredients.get(0);
		for(int i = 0; i < this.sizeOfIngredients(); ++i)
		{
			if(newIngredient.getIngredient().equals(cursor.getIngredient()))
			{
				System.out.println("Ingredient already exists in this recipe.");
				break;
			}else
			{
				cursor = this.ingredients.get(i);
			}//end - if/else statement
		}//end - for loop
		if(cursor == null || !newIngredient.getIngredient().equals(cursor.getIngredient()))
		{
			this.ingredients.addAtHead(newIngredient);
		}//end - if statement
	}//end - addIngredientAtHead
	
	/**
	 * Adds the ingredient at the specified location of the LinkedList
	 * @param newIngredient new Ingredient to be added
	 */
	public void addIngredientAtPosition(int position, RecipeIngredient newIngredient)
	{
		RecipeIngredient cursor = this.ingredients.get(0);
		for(int i = 0; i < this.sizeOfIngredients(); ++i)
		{
			if(newIngredient.getIngredient().equals(cursor.getIngredient()))
			{
				System.out.println("Ingredient already exists in this recipe.");
				break;
			}else
			{
				cursor = this.ingredients.get(i);
			}//end - if/else statement
		}//end - for loop
		if(!newIngredient.getIngredient().equals(cursor.getIngredient()))
		{
			this.ingredients.addAtPosition(position, newIngredient);
		}//end - if statement
	}//end - addIngredientAtPosition
	
	/**
	 * Adds the ingredient at the head of the LinkedList
	 * @param newIngredient new Ingredient to be added
	 */
	public void addIngredientAtTail(RecipeIngredient newIngredient)
	{
		RecipeIngredient cursor = this.ingredients.get(0);
		for(int i = 0; i < this.sizeOfIngredients(); ++i)
		{
			if(newIngredient.getIngredient().equals(cursor.getIngredient()))
			{
				System.out.println("Ingredient already exists in this recipe.");
				break;
			}else
			{
				cursor = this.ingredients.get(i);
			}//end - if/else statement
		}//end - for loop
		if(!newIngredient.getIngredient().equals(cursor.getIngredient()))
		{
			this.ingredients.addAtTail(newIngredient);
		}//end - if statement
	}//end - addIngredientAtTail
	
	/**
	 * Removes the ingredient from the LinkedList
	 * @param position the ingredient that is going to get removed.
	 * @return the ingredient that is going to get removed.
	 */
	public RecipeIngredient removeIngredient(int position)
	{
		return this.ingredients.remove(position);
	}//end - removeIngredient
	
	/**
	 * Shows the size of the ingredients linked list.
	 * @return the size of the ingredients via. int.
	 */
	public int sizeOfIngredients()
	{
		return this.ingredients.size();
	}//end - sizeOfIngredients
	
	
	
	//METHODS FOR DLL INSTRUCTIONS
	
	/**
	 * Adds the instruction at the head of the LinkedList.
	 * @param newInstruction new instruction to be added
	 */
	public void addInstructionAtHead(Instruction newInstruction)
	{
		this.instructions.addAtHead(newInstruction);
	}//end - addInstructionAtHead
	
	/**
	 * Adds the instruction at the specified location of the LinkedList
	 * @param newInstruction new instruction to be added
	 */
	public void addInstructionAtPosition(int position, Instruction newInstruction)
	{
		this.instructions.addAtPosition(position, newInstruction);
	}//end - addInstructionAtPosition
	
	/**
	 * Adds the instruction at the head of the LinkedList
	 * @param newInstruction new instruction to be added
	 */
	public void addInstructionAtTail(Instruction newInstruction)
	{
		this.instructions.addAtTail(newInstruction);
	}//end - addInstructionAtTail
	
	/**
	 * Removes the Instruction from the linked list via its
	 * position/index
	 * @param position
	 * @return the position of the instruction that is desired to be removed.
	 */
	public Instruction removeInstruction(int position)
	{
		return this.instructions.remove(position);
	}//end - removeInstruction
	
	/**
	 * Displays the number of instructions/steps in
	 * the DLL.
	 * @return the sizing of the DLL.
	 */
	public int sizeOfInstructions()
	{
		return this.instructions.size();
	}//end - sizeOfInstruction
	
}//end - class Recipe
