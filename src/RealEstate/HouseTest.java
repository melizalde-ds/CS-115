/**
* File: HouseTest.java
* Description: Test class for House.java
* Lessons Learned: Test classes are very useful to make sure that the code is working as expected.
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 10/14/2023
*/package RealEstate;

import org.junit.Test;
import static org.junit.Assert.*;

public class HouseTest {
    @Test
    public void getYardAcresNull() {
        House h = new House();
        assertEquals(0.0, h.getYardAcres(), 0.0);
    }

    @Test
    public void getYardAcresFull() {
        House h = new House("123 Main St", "12345", 2, 2, 1500.0, 0.5);
        assertEquals(0.5, h.getYardAcres(), 0.0);
    }

    @Test
    public void setYardAcres() {
        House h = new House();
        h.setYardAcres(0.5);
        assertEquals(0.5, h.getYardAcres(), 0.0);
    }

    @Test
    public void calculateAppraisalPrice() {
        House h = new House("123 Main St", "12345", 2, 2, 1500.0, 0.5);
        h.calculateAppraisalPrice();
        assertEquals(189500, h.getAppraisalPrice(), 0.0);
    }
}
