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
public class BurgerAddIngredientParamTest {
    private int amountAddIngredients;
    private int expectedResult;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @Mock
    Ingredient ingredient;

    public BurgerAddIngredientParamTest(int amountAddIngredients, int expectedResult) {
        this.amountAddIngredients = amountAddIngredients;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static final Object[][] getIngredientsForAdding() {
        return new Object[][] {
                {6, 6},
                {3, 3},
                {45, 45},
                {2, 0},
                {4, 7}
        };
    }

    @Test
    public void checkBurgerMethodAddIngredients() {
        Burger burger = new Burger();
        for(int i = 0; i < amountAddIngredients; i++) {
            burger.addIngredient(ingredient);
        }

        int countIngredients = burger.ingredients.size();
        assertEquals("Длина списка ингредиентов не совпадает", expectedResult, countIngredients);
    }
}