/**
* File: CondoTest.java
* Description: Test class for Condo.java
* Lessons Learned: Test classes are very useful to make sure that the code is working as expected.
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 10/14/2023
*/
package RealEstate;

import org.junit.Test;
import static org.junit.Assert.*;

public class CondoTest {
    @Test
    public void getFloorNumberNull() {
        Condo c = new Condo();
        assertEquals(0, c.getFloorLvl());
    }

    @Test
    public void getFloorNumberFull() {
        Condo c = new Condo("123 Main St", "12345", 2, 2, 1500.0, 2);
        assertEquals(2, c.getFloorLvl());
    }

    @Test
    public void setFloorNumber() {
        Condo c = new Condo();
        c.setFloorLvl(2);
        assertEquals(2, c.getFloorLvl());
    }

    @Test
    public void calculateAppraisalPrice() {
        Condo c = new Condo("123 Main St", "12345", 2, 2, 1500.0, 2);
        c.calculateAppraisalPrice();
        assertEquals(178000, c.getAppraisalPrice(), 0.0);
    }
}
