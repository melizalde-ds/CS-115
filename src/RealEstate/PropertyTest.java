/**
* File: PropertyTest.java
* Description: Test class for Property.java
* Lessons Learned: Test classes are very useful to make sure that the code is working as expected.
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 10/21/2023
*/
package RealEstate;

import org.junit.Test;
import static org.junit.Assert.*;

public class PropertyTest {
    @Test
    public void getStreetAddressNull() {
        Condo c = new Condo();
        assertEquals("", c.getStreetAddress());
    }

    @Test
    public void getStreetAddressFull() {
        Condo c = new Condo("123 Main St", 12345, 3, 2, 2, 1);
        assertEquals("123 Main St", c.getStreetAddress());
    }
    
    @Test
    public void setStreetAddress() {
        Condo c = new Condo();
        c.setStreetAddress("123 Main St");
        assertEquals("123 Main St", c.getStreetAddress());
    }

    @Test
    public void getZipNull() {
        Condo c = new Condo();
        assertEquals(0, c.getZip());
    }

    @Test
    public void getZipFull() {
        Condo c = new Condo("123 Main St", 12345, 3, 2, 2, 1);
        assertEquals(12345, c.getZip());
    }

    @Test
    public void setZip() {
        Condo c = new Condo();
        c.setZip(12345);
        assertEquals(12345, c.getZip());
    }
}
