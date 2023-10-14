/**
* File: SundaeTest.java
* Description: This class tests the Sundae class.
* Lessons Learned: This helped me understand how to test a subclass.
* Instructor's Name: Barbara Chamberlin
*
* @author: Nelly Barrera and Miguel Elizalde
* @since: 09/27/2023
*/
package DessertShop;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class SundaeTest {
    @Test
    public void getToppingNameTestNull() {
        Sundae s = new Sundae();
        String name = s.getToppingName();
        assertEquals(name, "");
    }

    @Test
    public void getToppingNameTestFull() {
        Sundae s = new Sundae("Sundae", 1, 1, "Topping", 1);
        String name = s.getToppingName();
        assertEquals(name, "Topping");
    }

    @Test
    public void setToppingNameTest() {
        Sundae s = new Sundae();
        s.setToppingName("Topping");
        String name = s.getToppingName();
        assertEquals(name, "Topping");
    }

    @Test
    public void getToppingPriceTestNull() {
        Sundae s = new Sundae();
        double price = s.getToppingPrice();
        assertEquals(price, 0, 0);
    }

    @Test
    public void getToppingPriceTestFull() {
        Sundae s = new Sundae("Sundae", 1, 1, "Topping", 1);
        double price = s.getToppingPrice();
        assertEquals(price, 1, 0);
    }

    @Test
    public void setToppingPriceTest() {
        Sundae s = new Sundae();
        s.setToppingPrice(5);
        double price = s.getToppingPrice();
        assertEquals(price, 5, 0);
    }

    @Test
    public void calculateCostTest() {
        Sundae s = new Sundae("Sundae", 1, 1, "Topping", 1);
        double cost = s.calculateCost();
        assertEquals(cost, 2, 0);
    }

    @Test
    public void calculateTaxTest() {
        Sundae s = new Sundae("Sundae", 1, 1, "Topping", 1);
        double tax = s.calculateTax();
        assertEquals(tax, 0.145, 0);
    }
}
