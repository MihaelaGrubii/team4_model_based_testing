package coffee.test;

import coffee.exceptions.RecipeException;
import com.coffee.AddRecipe4;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.test.TestBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@GraphWalker(value = "random(time_duration(1))", start = "e_Start")
public class TestAddRecipeeHappyPath extends ExecutionContext implements AddRecipe4 {
    private AddRecipeAdapter addRecipeAdapter = new AddRecipeAdapter();
    private static String NAME = "GP";
    private static String PRICE = "35.99";
    private static String COFFEE = "5";
    private static String SUGAR = "2";
    private static String MILK = "1";
    private static String CHOCOLATE = "1";
    private static String REASON = "must be a positive integer";
    private static final int recipesToAdd = 1;
    private static int recipesAdded = 0;
    public final static Path MODEL_PATH = Paths.get("com/coffee/AddRecipe4.graphml");


    @BeforeExecution
    public void setup() {
        System.out.println("Model: setup"); // http://graphwalker.github.io/fixtures/
        addRecipeAdapter.init();
    }

    @AfterExecution
    public void teardown() {
        System.out.println("Model: teardown"); // http://graphwalker.github.io/fixtures/
        addRecipeAdapter.reset();
    }

    @Override
    public void e_SetAmtCoffee() {
        try {
            addRecipeAdapter.set_coffee();
            Assert.assertEquals(addRecipeAdapter.coffeeUnits, COFFEE);
        } catch (RecipeException e) {
            Assert.assertTrue(e.getMessage().contains(REASON));
            e.printStackTrace();
        }

    }

    @Override
    public void e_CatchExceptionChocolateParcing() {
        Assert.assertTrue(addRecipeAdapter.catchExceptionReason("Chocolate "+REASON));
    }

    @Override
    public void v_Name_Set() {
        System.out.println("Name " + addRecipeAdapter.name + " is set.");
    }

    @Override
    public void v_AMTCoffee_Parsed() {
        System.out.println("Coffee units that are set as " + addRecipeAdapter.coffeeUnits + " are being parsed.");
    }

    @Override
    public void e_SetPrice() {
        try {
            addRecipeAdapter.set_price();
            Assert.assertEquals(addRecipeAdapter.price, PRICE);
        } catch (RecipeException e) {
            Assert.assertTrue(e.getMessage().contains(REASON));
            e.printStackTrace();
        }
    }

    @Override
    public void e_SetName() {
        addRecipeAdapter.set_name();
        Assert.assertEquals(addRecipeAdapter.name, NAME);
    }

    @Override
    public void e_SelectAddRecipes() {
        System.out.println("User selects add recipe option 1.");
    }

    @Override
    public void v_AmtSugar_Parsed() {
        System.out.println("Sugar units that are set as " + addRecipeAdapter.sugarUnits + " are being parsed.");
    }

    @Override
    public void v_AmtSugar_Set() {
        try {
            addRecipeAdapter.set_sugar();
            Assert.assertEquals(addRecipeAdapter.sugarUnits, SUGAR);
        } catch (RecipeException e) {
            Assert.assertTrue(e.getMessage().contains(REASON));
            e.printStackTrace();
        }
    }

    @Override
    public void v_UserInputs_Received() {
        System.out.println("Inputs Received");
        System.out.println("name:" + addRecipeAdapter.name);
        System.out.println("price:" + addRecipeAdapter.price);
        System.out.println("sugar:" + addRecipeAdapter.sugarUnits);
        System.out.println("coffee:" + addRecipeAdapter.coffeeUnits);
        System.out.println("milk:" + addRecipeAdapter.milkUnits);
        System.out.println("chocolate:" + addRecipeAdapter.coffeeUnits);
    }

    @Override
    public void v_Price_Set() {
        System.out.println("Price for new recipe is set as" + addRecipeAdapter.price);
    }

    @Override
    public void v_Receipe_Submited() {
        Assert.assertEquals((NAME + " successfully added."), addRecipeAdapter.reportIfRecipeAdded());
    }

    @Override
    public void e_ReportSuccessAndComplete() {
        Assert.assertTrue(addRecipeAdapter.singleRecipeAddedSuccessfully());
    }

    @Override
    public void v_AmtMilk_Parsed() {
        System.out.println("Milk units that are set as " + addRecipeAdapter.milkUnits + " are being parsed.");
    }

    @Override
    public void e_Start() {
        System.out.println("Powering up the Coffee Machine Application!");
    }

    @Override
    public void v_Price_Parsed() {
        System.out.println("Price set as " + addRecipeAdapter.price + " is being parsed.");
    }

    @Override
    public void v_AMTCoffee_Set() {
        System.out.println("Coffee units for new recipe are being set as " + addRecipeAdapter.coffeeUnits);

    }

    @Override
    public void e_ParseMilk() {
        try {
            int i = addRecipeAdapter.parse_milk();
            Assert.assertEquals(i + " must be equal to " + Integer.parseInt(MILK), i, Integer.parseInt(MILK));
        } catch (RecipeException e) {
            Assert.assertTrue(e.getMessage().contains(REASON));
            e.printStackTrace();
        }
    }

    @Override
    public void e_NewRecipeInputValues() {
        System.out.println("Inputting the new recipe values!!!!");
    }

    @Override
    public void e_ReportFailureAndComplete() {
        Assert.assertFalse(addRecipeAdapter.singleRecipeAddedSuccessfully());
    }

    @Override
    public void e_ParseSugar() {
        try {
            int i = addRecipeAdapter.parse_sugar();
            Assert.assertEquals(i + " must be equal to " + Integer.parseInt(SUGAR), i, Integer.parseInt(SUGAR));
        } catch (RecipeException e) {
            Assert.assertTrue(e.getMessage().contains(REASON));
            e.printStackTrace();
        }
    }

    @Override
    public void e_SingleRecipeAdd() {

    }

    @Override
    public void v_RecipeException_Occurred() {
        System.out.println("RECIPE EXCEPTION OCCURRED !!!");
    }

    @Override
    public void v_MainMenu_Loaded() {
        System.out.println("Loading...Main Menu");
    }

    @Override
    public void v_AddRecipe_Selected() {
        System.out.println("Add Recipe Selected");
    }

    @Override
    public void e_ParseCoffee() {
        try {
            int i = addRecipeAdapter.parse_coffee();
            Assert.assertEquals(i + " must be equal to " + Integer.parseInt(COFFEE), i, Integer.parseInt(COFFEE));
        } catch (RecipeException e) {
            Assert.assertTrue(e.getMessage().contains(REASON));
            e.printStackTrace();
        }
    }

    @Override
    public void v_NewRecipe_Initiated() {
        addRecipeAdapter.newRecipe();
    }

    @Override
    public void e_ReadUserInputs() {
        addRecipeAdapter.setUserInput(NAME, PRICE, COFFEE, MILK, CHOCOLATE);
    }

    @Override
    public void e_ThrowRecipeExceptionDueToName() {
        Assert.assertTrue(addRecipeAdapter.catchExceptionReason("Name must be valid"));
    }

    @Override
    public void e_CatchExceptionPriceParcing() {
        Assert.assertTrue(addRecipeAdapter.catchExceptionReason(REASON));
    }

    @Override
    public void v_AmtChocolate_Parsed() {
        System.out.println("Chocolate set as " + addRecipeAdapter.chocolateUnits + " is being parsed.");
    }

    @Override
    public void e_ParsePrice() {
        try {
            int i = addRecipeAdapter.parse_price();
            Assert.assertEquals(i + " must be equal to " + Integer.parseInt(PRICE), i, Integer.parseInt(PRICE));
        } catch (RecipeException e) {
            Assert.assertTrue(e.getMessage().contains("must be a positive integer"));
            e.printStackTrace();
        }
    }

    @Override
    public void v_AmtMilk_Set() {
        System.out.println("Milk units for new recipe are being set as " + addRecipeAdapter.milkUnits);
    }

    @Override
    public void e_SetAmtMilk() {
        try {
            addRecipeAdapter.set_milk();
            Assert.assertEquals(addRecipeAdapter.milkUnits, MILK);
        } catch (RecipeException e) {
            Assert.assertTrue(e.getMessage().contains("must be a positive integer"));
            e.printStackTrace();
        }
    }

    @Override
    public void v_Execution_Completed() {
        System.out.println("Add recipe execution completed");
    }

    @Override
    public void e_ParseChocolate() {
        try {
            int i = addRecipeAdapter.parse_chocolate();
            Assert.assertEquals(i + " must be equal to " + Integer.parseInt(CHOCOLATE), i, Integer.parseInt(CHOCOLATE));
        } catch (RecipeException e) {
            Assert.assertTrue(e.getMessage().contains("must be a positive integer"));
            e.printStackTrace();
        }
    }

    @Override
    public void v_AmtChocolate_Set() {
        System.out.println("Chocolate set as " + addRecipeAdapter.chocolateUnits + " is set.");
    }

    @Override
    public void e_CatchExceptionCoffeParcing() {
        Assert.assertTrue(addRecipeAdapter.catchExceptionReason("must be a positive integer"));
    }

    @Override
    public void e_SetAmtSugar() {
        try {
            addRecipeAdapter.set_sugar();
            Assert.assertEquals(addRecipeAdapter.sugarUnits, SUGAR);
        } catch (RecipeException e) {
            Assert.assertTrue(e.getMessage().contains("must be a positive integer"));
            e.printStackTrace();
        }

    }

    @Override
    public void e_SetAmtChocolate() {
        try {
            addRecipeAdapter.set_chocolate();
            Assert.assertEquals(addRecipeAdapter.chocolateUnits, CHOCOLATE);
        } catch (RecipeException e) {
            Assert.assertTrue(e.getMessage().contains("must be a positive integer"));
            e.printStackTrace();
        }
    }

    @Override
    public void e_LoadTheMainMenu() {
        System.out.println("Load the Menu");
    }

    @Override
    public void e_CatchExceptionMilkParcing() {
        Assert.assertTrue(addRecipeAdapter.catchExceptionReason(REASON));
    }

    @Override
    public void e_CatchExceptionSugarParcing() {
        Assert.assertTrue(addRecipeAdapter.catchExceptionReason(REASON));
    }

    @Test
    public void functionalTest() {
        new TestBuilder()
                .addModel(MODEL_PATH, new RandomPath(new EdgeCoverage(100)), "e_Start")
                .execute();
    }

    //can be counted as one of the tests.
    @Test
    public void stabilityTest() {
        new TestBuilder()
                .addModel(MODEL_PATH, new RandomPath(new TimeDuration(30, TimeUnit.SECONDS)), "e_Start")
                .execute();
    }
}
