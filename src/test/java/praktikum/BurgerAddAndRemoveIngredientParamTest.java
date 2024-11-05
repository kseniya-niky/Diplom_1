package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BurgerAddAndRemoveIngredientParamTest {
    private int amountAddIngredients;
    private int amountRemoveIngredients;
    private int expectedResult;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @Mock
    Ingredient ingredient;

    public BurgerAddAndRemoveIngredientParamTest(int amountAddIngredients, int amountRemoveIngredients, int expectedResult) {
        this.amountAddIngredients = amountAddIngredients;
        this.amountRemoveIngredients = amountRemoveIngredients;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static final Object[][] getIngredientsForRemoving() {
        return new Object[][] {
                {4, 2, 2},
                {12, 8, 4},
                {3, 3, 0},
                {4, 1, 0},
                {10, 5, 3}
        };
    }

    @Test
    public void checkBurgerMethodAddAndRemoveIngredients() {
        Burger burger = new Burger();
        for(int i = 0; i < amountAddIngredients; i++) {
            burger.addIngredient(ingredient);
        }

        for(int k = amountAddIngredients-1; k >= amountAddIngredients - amountRemoveIngredients; k--) {
            burger.removeIngredient(k);
        }

        int countIngredients = burger.ingredients.size();
        assertEquals("Длина списка ингредиентов не совпадает", expectedResult, countIngredients);
    }
}