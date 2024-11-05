package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerMoveIngredientParamTest {
    private int amountAddIngredients;
    private int oldIndexIngredient;
    private int newIndexIngredient;
    private int expectedResult;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @Mock
    Ingredient ingredient;

    public BurgerMoveIngredientParamTest(int amountAddIngredients, int oldIndexIngredient,
                                         int newIndexIngredient, int expectedResult) {
        this.amountAddIngredients = amountAddIngredients;
        this.oldIndexIngredient = oldIndexIngredient;
        this.newIndexIngredient = newIndexIngredient;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static final Object[][] getIngredientsForMoving() {
        return new Object[][] {
                {7, 4, 2, 7},
                {5, 0, 4, 5},
                {6, 1, 3, 6}
        };
    }

    @Test
    public void checkBurgerMoveIngredient() {
        Burger burger = new Burger();
        for(int i = 0; i < amountAddIngredients; i++) {
            burger.addIngredient(ingredient);
        }

        burger.moveIngredient(oldIndexIngredient, newIndexIngredient);
        assertEquals("При перемещении добавлен/удален ингредиент", expectedResult, burger.ingredients.size());
    }
}