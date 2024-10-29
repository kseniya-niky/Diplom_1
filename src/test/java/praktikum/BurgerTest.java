package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void checkBurgerMethodSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals("Переменная bun не установлена", bun, burger.bun);
    }

    @Test
    public void checkBurgerMethodGetPriceCallBunGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.getPrice();
        Mockito.verify(bun).getPrice();
    }

    @Test
    public void checkBurgerMethodGetPriceCallIngredientGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.getPrice();
        Mockito.verify(ingredient).getPrice();
    }

    @Test
    public void checkBurgerMethodGetReceiptCallBunGetName() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.getReceipt();
        Mockito.verify(bun, Mockito.times(2)).getName();
    }

    @Test
    public void checkBurgerMethodGetReceiptCallIngredientGetName() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);

        burger.getReceipt();
        Mockito.verify(ingredient).getName();
    }

    @Test
    public void checkBurgerMethodGetReceiptCallIngredientGetType() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);

        burger.getReceipt();
        Mockito.verify(ingredient).getType();
    }
}