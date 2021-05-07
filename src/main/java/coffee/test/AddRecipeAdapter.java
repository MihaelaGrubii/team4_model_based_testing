package coffee.test;

import coffee.CoffeeMaker;
import coffee.Recipe;
import coffee.exceptions.RecipeException;
import org.junit.Assert;

public class AddRecipeAdapter {
    //1.initiate SUT
    private Recipe recipe = new Recipe();
    public String name;
    public String price;
    public String sugarUnits;
    public String milkUnits;
    public String chocolateUnits;
    public String coffeeUnits;
    private boolean recipeAdded = false;
    private RecipeException recipeException = new RecipeException("");
    private static CoffeeMaker coffeeMaker;

    //2.create functions which gives a brief about what model does
    public void init() {
        System.out.println("Adapter: init SUT");
    }

    public void reset() {
        System.out.println("Adapter: reset SUT");
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void newRecipe(){
        this.recipe =new Recipe();
    }

    public void waitForUserInput() {
        System.out.println("waiting for user input ...");
    }

    public void setUserInput(String name, String price, String coffeeUnits, String milkUnits, String chocolateUnits) {
        this.name = name;
        this.price = price;
        this.coffeeUnits = coffeeUnits;
        this.milkUnits = milkUnits;
        this.coffeeUnits = coffeeUnits;
    }

    public void initiateRecipe() {
        System.out.println(" initiate new recipe: " + this.name);
    }

    public void set_name() {
        recipe.setName(this.name);
    }

    public int parse_price() throws RecipeException {
        if (recipeException.getMessage().isEmpty()) {
            try {
                return Integer.parseInt(this.price);
            } catch (NumberFormatException e) {
                recipeException = new RecipeException("Price must be a positive integer");
                throw recipeException;
            }
        } else {
            throw recipeException;
        }
    }

    public void set_price() throws RecipeException {
        try {
            recipe.setPrice(this.price);
        } catch (NumberFormatException e) {
            recipeException = new RecipeException("Price must be a positive integer");
            throw recipeException;
        }
    }

    public int parse_coffee() throws RecipeException {

        if (recipeException.getMessage().isEmpty()) {
            try {
                return Integer.parseInt(this.coffeeUnits);
            } catch (NumberFormatException e) {
                recipeException = new RecipeException("Units of coffee must be a positive integer");
                throw recipeException;
            }
        } else {
            throw recipeException;
        }

    }

    public void set_coffee() throws RecipeException {
        try {
            recipe.setAmtCoffee(this.coffeeUnits);
        } catch (NumberFormatException e) {
            recipeException = new RecipeException("Units of coffee must be a positive integer");
            throw recipeException;
        }
    }

    public int parse_chocolate() throws RecipeException {

        if (recipeException.getMessage().isEmpty()) {
            try {
                return Integer.parseInt(this.chocolateUnits);
            } catch (NumberFormatException e) {
                recipeException = new RecipeException("Units of chocolate must be a positive integer");
                throw recipeException;
            }
        } else {
            throw recipeException;
        }
    }

    public void set_chocolate() throws RecipeException {
        try {
            recipe.setAmtChocolate(this.chocolateUnits);
        } catch (NumberFormatException e) {
            recipeException = new RecipeException("Units of chocolate must be a positive integer");
            throw recipeException;
        }
    }

    public int parse_sugar() throws RecipeException {

        if (recipeException.getMessage().isEmpty()) {
            try {
                return Integer.parseInt(this.sugarUnits);
            } catch (NumberFormatException e) {
                recipeException = new RecipeException("Units of sugar must be a positive integer");
                throw recipeException;
            }
        } else {
            throw recipeException;
        }
    }

    public void set_sugar() throws RecipeException {
        try {
            recipe.setAmtSugar(this.sugarUnits);
        } catch (NumberFormatException e) {
            recipeException = new RecipeException("Units of sugar must be a positive integer");
            throw recipeException;
        }
    }

    public int parse_milk() throws RecipeException {

        if (recipeException.getMessage().isEmpty()) {
            try {
                return Integer.parseInt(this.milkUnits);
            } catch (NumberFormatException e) {
                recipeException = new RecipeException("Units of milk must be a positive integer");
                throw recipeException;
            }
        } else {
            throw recipeException;
        }

    }

    public void set_milk() throws RecipeException {
        try {
            recipe.setAmtMilk(this.milkUnits);
        } catch (RecipeException e) {
            recipeException = new RecipeException("Units of milk must be a positive integer");
            throw recipeException;
        }
    }

    public boolean catchExceptionReason(String reason) {
        return recipeException.getMessage().toLowerCase().contains(reason.toLowerCase());
    }

    public boolean singleRecipeAddedSuccessfully() {
        recipeAdded = coffeeMaker.addRecipe(recipe);
        return recipeAdded;
    }

    public String reportIfRecipeAdded() {
        if (recipeAdded) {
            recipeAdded = false;
            return (name + " successfully added.");
        } else {
            return (name + " could not be added.");
        }
    }


}