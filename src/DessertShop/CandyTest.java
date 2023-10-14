/**
* File: CandyTest.java
* Description: This class tests the Candy class.
* Lessons Learned: This helped me understand more the assertEquals method with double.
* Instructor's Name: Barbara Chamberlin
*
* @author: Nelly Barrera and Miguel Elizalde
* @since: 09/27/2023
*/
package DessertShop;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class CandyTest {
    @Test
    public void getCandyWeightTestNull() {
        Candy c = new Candy();
        double weight = c.getCandyWeight();
        assertEquals(weight, 0, 0);
    }

    @Test
    public void getCandyWeightTestFull() {
        Candy c = new Candy("Candy", 1, 1);
        double weight = c.getCandyWeight();
        assertEquals(weight, 1, 0);
    }

    @Test
    public void setCandyWeightTest() {
        Candy c = new Candy();
        c.setCandyWeight(25);
        double weight = c.getCandyWeight();
        assertEquals(weight, 25, 0);
    }

    @Test
    public void getCandyPricePerPoundTestNull() {
        Candy c = new Candy();
        double price = c.getCandyPricePerPound();
        assertEquals(price, 0, 0);
    }

    @Test
    public void getCandyPricePerPoundTestFull() {
        Candy c = new Candy("Candy", 1, 1);
        double price = c.getCandyPricePerPound();
        assertEquals(price, 1, 0);
    }

    @Test
    public void setCandyPricePerPoundTest() {
        Candy c = new Candy();
        c.setCandyPricePerPound(25.4);
        double price = c.getCandyPricePerPound();
        assertEquals(price, 25.4, 0);
    }

    @Test
    public void calculateCostTest() {
        Candy c = new Candy("Candy", 1, 1);
        double cost = c.calculateCost();
        assertEquals(cost, 1, 0);
    }

    @Test
    public void calculateTaxTest() {
        Candy c = new Candy("Candy", 1, 1);
        double tax = c.calculateTax();
        assertEquals(tax, 0.0725, 0.0);
    }
}
