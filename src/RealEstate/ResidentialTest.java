/**
* File: ResidentialTest.java
* Description: Test class for Residential.java
* Lessons Learned: Test classes are very useful to make sure that the code is working as expected.
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 10/14/2023
*/
package RealEstate;

import org.junit.Test;
import static org.junit.Assert.*;

public class ResidentialTest {
    @Test
    public void getBedCountNull() {
        House h = new House();
        assertEquals(0, h.getBedCount());
    }

    @Test
    public void getBedCountFull() {
        House h = new House("123 Main St", 12345, 2, 2, 1500.0, 0.5);
        assertEquals(2, h.getBedCount());
    }

    @Test
    public void setBedCount() {
        House h = new House();
        h.setBedCount(2);
        assertEquals(2, h.getBedCount());
    }

    @Test
    public void getBathCountNull() {
        House h = new House();
        assertEquals(0, h.getBathCount());
    }

    @Test
    public void getBathCountFull() {
        House h = new House("123 Main St", 12345, 2, 2, 1500.0, 0.5);
        assertEquals(2, h.getBathCount());
    }

    @Test
    public void setBathCount() {
        House h = new House();
        h.setBathCount(2);
        assertEquals(2, h.getBathCount());
    }

    @Test
    public void getSquareFootageNull() {
        House h = new House();
        assertEquals(0.0, h.getSquareFootage(), 0.0);
    }

    @Test
    public void getSquareFootageFull() {
        House h = new House("123 Main St", 12345, 2, 2, 1500.0, 0.5);
        assertEquals(1500.0, h.getSquareFootage(), 0.0);
    }

    @Test
    public void setSquareFootage() {
        House h = new House();
        h.setSquareFootage(1500.0);
        assertEquals(1500.0, h.getSquareFootage(), 0.0);
    }
}
