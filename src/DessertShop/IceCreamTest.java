/**
* File: IceCreamTest.java
* Description: This class tests the IceCream class.
* Lessons Learned: This helped me understand how to test a subclass.
* Instructor's Name: Barbara Chamberlin
*
* @author: Nelly Barrera and Miguel Elizalde
* @since: 09/27/2023
*/
package DessertShop;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class IceCreamTest {
    @Test
    public void getScoopCountTestNull() {
        IceCream i = new IceCream();
        int count = i.getScoopCount();
        assertEquals(count, 0);
    }

    @Test
    public void getScoopCountTestFull() {
        IceCream i = new IceCream("Ice Cream", 1, 1);
        int count = i.getScoopCount();
        assertEquals(count, 1);
    }

    @Test
    public void setScoopCountTest() {
        IceCream i = new IceCream();
        i.setScoopCount(5);
        int count = i.getScoopCount();
        assertEquals(count, 5);
    }
    
    @Test
    public void getPricePerScoopTestNull() {
        IceCream i = new IceCream();
        double price = i.getPricePerScoop();
        assertEquals(price, 0, 0);
    }

    @Test
    public void getPricePerScoopTestFull() {
        IceCream i = new IceCream("Ice Cream", 1, 1);
        double price = i.getPricePerScoop();
        assertEquals(price, 1, 0);
    }

    @Test
    public void setPricePerScoopTest() {
        IceCream i = new IceCream();
        i.setPricePerScoop(50);
        double price = i.getPricePerScoop();
        assertEquals(price, 50, 0);
    }

    @Test
    public void calculateCostTest() {
        IceCream i = new IceCream("Ice Cream", 1, 1);
        double cost = i.calculateCost();
        assertEquals(cost, 1, 0);
    }

    @Test
    public void calculateTaxTest() {
        IceCream i = new IceCream("Ice Cream", 1, 1);
        double tax = i.calculateTax();
        assertEquals(tax, 0.0725, 0);
    }
}
