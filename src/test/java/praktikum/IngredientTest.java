package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static praktikum.services.Constants.*;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    @Mock
    IngredientType type;

    @Test
    public void checkIngredientMethodGetName() {
        Ingredient ingredient = new Ingredient(type, INGREDIENT_NAME, INGREDIENT_PRICE);
        assertEquals("Объект ingredient создан с другим именем", INGREDIENT_NAME, ingredient.getName());
    }

    @Test
    public void checkIngredientMethodGetPrice() {
        Ingredient ingredient = new Ingredient(type, INGREDIENT_NAME, INGREDIENT_PRICE);
        assertEquals("Объект ingredient создан с другой ценой", INGREDIENT_PRICE, ingredient.getPrice(), 0);
    }

    @Test
    public void checkIngredientMethodGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, INGREDIENT_NAME, INGREDIENT_PRICE);
        assertEquals("Тип ингредиента не совпадает", IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }
}