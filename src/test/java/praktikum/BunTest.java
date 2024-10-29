package praktikum;

import org.junit.Test;
import praktikum.services.Constants;

import static org.junit.Assert.*;

public class BunTest {
    @Test
    public void checkBunMethodGetName() {
        Bun bun = new Bun(Constants.BUN_NAME, Constants.BUN_PRICE);
        assertEquals("Объект bun создан с другим именем", Constants.BUN_NAME, bun.getName());
    }

    @Test
    public void checkBunMethodGetPrice() {
        Bun bun = new Bun(Constants.BUN_NAME, Constants.BUN_PRICE);
        assertEquals("Объект bun создан с другой ценой", Constants.BUN_PRICE, bun.getPrice(), 0);
    }
}