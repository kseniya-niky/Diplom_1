package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private String type;
    private IngredientType expectedResult;

    public IngredientTypeTest(String type, IngredientType expectedResult) {
        this.type = type;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static final Object[][] getIngredientTypes() {
        return new Object[][] {
                {"SAUCE", SAUCE},
                {"FILLING", FILLING}
        };
    }

    @Test
    public void checkValueOfIngredientType() {
        assertEquals("Тип ингредиента не совпадает", expectedResult, IngredientType.valueOf(type));
    }
}