package edu.mtc.egr283.rb;

import java.util.Scanner;

public class RecipeBox {
	
	private DLL<Recipe> recipes;
	private Scanner input;
	private int choice;
	private String nameOrDescription;
	private int locationOfInput;
	
	public RecipeBox()
	{
		this.recipes = new DLL<Recipe>();
		this.input = new Scanner(System.in);
	}//end - Constructor
	
	/**
	 * Displays the UI, and also gives the choices that the user can make/use.
	 * pretty much implemented everything so it could just be instantiated and call
	 * this method to run the program.
	 */
	public void display()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("*********** Recipe Box ***********\n\n");
		sb.append("Select any option(0 to 9)\n");
		sb.append("1. Add a recipe at the head of the box\n");
		sb.append("2. Add a recipe at a specific location\n");
		sb.append("3. Add a recipe at the end of the box\n");
		sb.append("4. Delete a recipe\n");
		sb.append("5. Edit a recipe\n");
		sb.append("6. Display a list of the Recipes in the box\n");
		sb.append("7. Display a recipe (Name, Ingredients List, and Instructions List)\n");
		sb.append("8. Display Only the Ingredients List of a Recipe\n");
		sb.append("9. Display Only the Instructions List of a Recipe\n");
		sb.append("0. Exit");
		System.out.println(sb.toString());
		this.choice = this.input.nextInt();
		switch(this.choice)
		{
			case 1:
			{
				String decision = "yes";
				while(decision.equalsIgnoreCase("yes"))
				{
					System.out.println("Enter the recipe which you want to add at the head of the recipe box:");
					this.nameOrDescription = input.next();
					this.recipes.addAtHead(new Recipe(this.nameOrDescription));
					System.out.println("Do you want to continue? (yes/no)");
					decision = this.input.next();
				}//end - while loop
				this.display();
				break;
			}
			case 2:
			{
				String decision = "yes";
				while(decision.equalsIgnoreCase("yes"))
				{
					System.out.println("Enter the recipe which you want to add in the recipe box:");
					this.nameOrDescription = input.next();
					System.out.println("Enter the specific location where you want to add a recipe");
					this.locationOfInput = input.nextInt();
					this.recipes.addAtPosition(this.locationOfInput, new Recipe(this.nameOrDescription));
					System.out.println("Do you want to Continue? (yes/no)");
					decision = this.input.next();
				}//end - while loop
				this.display();
				break;
			}
			case 3:
			{
				String decision = "yes";
				while(decision.equalsIgnoreCase("yes"))
				{
					System.out.println("Enter the recipe which you want to add at the end of the recipe box:");
					this.nameOrDescription = input.next();
					this.recipes.addAtTail(new Recipe(this.nameOrDescription));
					System.out.println("Do you want to Continue? (yes/no)");
					decision = this.input.next();
				}//end - while loop
				this.display();
				break;
			}
			case 4:
			{
				String decision = "yes";
				while(decision.equalsIgnoreCase("yes"))
				{
					System.out.println("Enter the recipe which you want to delete from the recipe list:");
					this.nameOrDescription = input.next();
					this.locationOfInput = this.findRecipeIndex(new Recipe(nameOrDescription));
					this.recipes.remove(this.recipes.get(locationOfInput));
					System.out.println("Do you want to Continue? (yes/no)");
					decision = this.input.next();
				}//end - while loop
			}
			case 5:
			{
				System.out.println("List the recipe that you want to edit: ");
				this.nameOrDescription = input.next();
				locationOfInput = this.findRecipeIndex(new Recipe(this.nameOrDescription));
				this.recipes.get(locationOfInput);
				System.out.println("Select any submenu option (1 to 11)");
				System.out.println("1. Add an ingredient at the head of the list");
				System.out.println("2. Add an ingredient at a specific location");
				System.out.println("3. Add an ingredient at the end of the list");
				System.out.println("4. Delete an ingredient");
				System.out.println("5. Display the Ingredients List of a recipe");
				System.out.println("6. Add an instruction at the head of the list");
				System.out.println("7. Add an instruction at a specific location");
				System.out.println("8. Add an instruction at the end of the list");
				System.out.println("9. Delete an instruction");
				System.out.println("10. Display the Instructions List of a recipe");
				System.out.println("11. Go back to the main menu");
				System.out.println();
				this.choice = this.input.nextInt();
				switch(this.choice)
				{
					case 1:
					{
						
					}
					case 2:
					{
						
					}
					case 3:
					{
						
					}
					case 4:
					{
						
					}
					case 5:
					{
						
					}
					case 6:
					{
						
					}
					case 7:
					{
						
					}
					case 8:
					{
						
					}
					case 9:
					{
						
					}
					case 10:
					{
						
					}
					case 11:
						this.display();
						break;
					default:
						while(this.choice <= 1 || this.choice >= 13)
						{
							System.out.println("Invalid Input!");
							this.choice = this.input.nextInt();
						}//end - while loop
						
				}
				break;
			}
			case 6 :
			{
				System.out.println("Recipes in recipe list are: ");
				this.displayAllRecipes();
				this.display();
				break;
			}
			case 7 :
			{
				System.out.println("Enter which recipe you would like to look at:");
				nameOrDescription = input.next();
				Recipe dummyRecipe = new Recipe(nameOrDescription);
				locationOfInput = this.findRecipeIndex(dummyRecipe);
				this.displayARecipe(this.recipes.get(locationOfInput));
				this.display();
				break;
			}
			case 8 :
			{
				System.out.println("Enter which recipe's ingredients you would like to look at:");
				nameOrDescription = input.next();
				Recipe dummyRecipe = new Recipe(nameOrDescription);
				locationOfInput = this.findRecipeIndex(dummyRecipe);
				this.displayIngredients(this.recipes.get(locationOfInput));
				this.display();
				break;
			}
			case 9 :
			{
				System.out.println("Enter which recipe's instructions you would like to look at:");
				nameOrDescription = input.next();
				Recipe dummyRecipe = new Recipe(nameOrDescription);
				locationOfInput = this.findRecipeIndex(dummyRecipe);
				this.displayInstructions(this.recipes.get(locationOfInput));
				this.display();
				break;
			}
			case 0:
			{
				System.out.println("Thank you for using the Recipe Box Application");
				System.exit(0);
			}
			default:
				while(this.choice >= 0 || this.choice <= 9)
				{
					System.out.println("Invalid input, try again: ");
					this.display();
				}//end - while loop
		}//end - switch statements
	}//end - displayMainMenu
	
	/**
	 * Finds the index of the desired recipe.
	 * @param input the string that is needed to find the recipe
	 * @return the index of where the recipe is placed at
	 */
	private int findRecipeIndex(Recipe input)
	{
		DLLNode<Recipe> cursor = this.recipes.getHead().getNext();
		int index = 0;
		
		//continue to loop until we reach the end of the list
		//or we find the target data
		while(!cursor.equals(this.recipes.getTail()) && (!cursor.getNodeData().equals(input)))
		{
			cursor = cursor.getNext();
			++index;
		}//end - while loop
		
		//manually set index to -1 if we cannot fine the target data.
		if(!cursor.getNodeData().equals(input))
		{
			index = -1;
		}
		return index;
	}//end - find Recipe
	
	
	private void displayAllRecipes()
	{
		for(int i = 0; i < this.recipes.size(); i++)
		{
			if(this.recipes.get(i) == null)
			{
				break;
			}
			System.out.println(this.recipes.get(i).getName());
		}//end - displayAllRecipes
	}//end - displayAllRecipes
	
	private void displayARecipe(Recipe disRecipe)
	{
		Recipe targetRecipe = this.recipes.get(this.findRecipeIndex(disRecipe));
		System.out.println(targetRecipe.toString());
	}//end - displayARecipe
	
	private void displayIngredients(Recipe disRecipe)
	{
		Recipe targetRecipe = this.recipes.get(this.findRecipeIndex(disRecipe));
		System.out.println(targetRecipe.toStringIngredients());
	}//end - displayARecipe
	
	private void displayInstructions(Recipe disRecipe)
	{
		Recipe targetRecipe = this.recipes.get(this.findRecipeIndex(disRecipe));
		System.out.println(targetRecipe.toStringInstructions());
	}//end - displayARecipe
	
}//end - Class RecipeBox
