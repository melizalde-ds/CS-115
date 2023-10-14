/**
* File: CookieTest.java
* Description: This class tests the Cookie class.
* Lessons Learned: It helped me review many things about JUnit.
* Instructor's Name: Barbara Chamberlin
*
* @author: Nelly Barrera and Miguel Elizalde
* @since: 09/27/2023
*/
package DessertShop;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class CookieTest {
    @Test
    public void getCookieQtyNulll() {
        Cookie c = new Cookie();
        int qty = c.getCookieQty();
        assertEquals(qty, 0);
    }

    @Test
    public void getCookieQtyFull() {
        Cookie c = new Cookie("Cookie", 1, 1);
        int qty = c.getCookieQty();
        assertEquals(qty, 1);
    }

    @Test
    public void setCookieQtyTest() {
        Cookie c = new Cookie();
        c.setCookieQty(12);
        int qty = c.getCookieQty();
        assertEquals(qty, 12);
    }

    @Test
    public void getPricePerDozenTestNull() {
        Cookie c = new Cookie();
        double price = c.getPricePerDozen();
        assertEquals(price, 0, 0);
    }

    @Test
    public void getPricePerDozenTestFull() {
        Cookie c = new Cookie("Cookie", 1, 1);
        double price = c.getPricePerDozen();
        assertEquals(price, 1, 0);
    }

    @Test
    public void setPricePerDozenTest() {
        Cookie c = new Cookie();
        c.setPricePerDozen(35.4);
        double price = c.getPricePerDozen();
        assertEquals(price, 35.4, 0);
    }

    @Test
    public void calculateCostTest() {
        Cookie c = new Cookie("Cookie", 12, 1);
        double cost = c.calculateCost();
        assertEquals(cost, 1, 0);
    }
    
    @Test
    public void calculateTaxTest() {
        Cookie c = new Cookie("Cookie", 12, 1);
        double tax = c.calculateTax();
        assertEquals(tax, 0.0725, 0);
    }
}
