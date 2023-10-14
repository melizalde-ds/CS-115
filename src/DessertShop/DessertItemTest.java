/**
* File: DessertItemTest.java
* Description: This class tests the DessertItem class.
* Lessons Learned: This helped me understand how to test a superclass.
* Instructor's Name: Barbara Chamberlin
*
* @author: Nelly Barrera and Miguel Elizalde
* @since: 09/27/2023
*/
package DessertShop;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class DessertItemTest {
    @Test
    public void getNameTestNull() {
        DessertItem d = new Candy();
        String name = d.getName();
        assertEquals(name, "");
    }

    @Test
    public void getNameTestFull() {
        DessertItem d = new Candy("Dessert", 1.00, 1.00);
        String name = d.getName();
        assertEquals(name, "Dessert");
    }

    @Test
    public void setNameTest() {
        DessertItem d = new Candy();
        d.setName("Dessert");
        String name = d.getName();
        assertEquals(name, "Dessert");
    }

    @Test
    public void getTaxPercentTest() {
        DessertItem d = new Candy();
        double taxPercent = d.getTaxPercent();
        assertEquals(taxPercent, 7.25, 0.0);
    }

    @Test
    public void setTaxPercentTest() {
        DessertItem d = new Candy();
        d.setTaxPercent(8.25);
        double taxPercent = d.getTaxPercent();
        assertEquals(taxPercent, 8.25, 0.0);
    }

    @Test
    public void getPackagingTest() {
        DessertItem d = new Candy();
        String packaging = d.getPackaging();
        assertEquals(packaging, "");
    }

    @Test
    public void setPackagingTest() {
        DessertItem d = new Candy();
        d.setPackaging("Box");
        String packaging = d.getPackaging();
        assertEquals(packaging, "Box");
    }

    @Test
    public void calculateTaxTest() {
        DessertItem d = new Candy("Dessert", 1.00, 1.00);
        double tax = d.calculateTax();
        assertEquals(tax, 0.0725, 0.0);
    }

}
