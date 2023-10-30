/**
* File: CustomerTest.java
* Description: This class tests the Customer class.
* Lessons Learned: This helped me understand how to create a test class.
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 10/28/2023
*/
package DessertShop;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {
    @Test
    public void getNameTest() {
        Customer c = new Customer("Miguel");
        assertEquals("Miguel", c.getName());
    }

    @Test
    public void setNameTest() {
        Customer c = new Customer("Miguel");
        c.setName("David");
        assertEquals("David", c.getName());
    }

    @Test
    public void getOrderHistoryTest() {
        Customer c = new Customer("Miguel");
        assertEquals(0, c.getOrderHistory().size());
    }

    @Test
    public void addToHistoryTest() {
        Customer c = new Customer("Miguel");
        Order o = new Order();
        c.addToHistory(o);
        assertEquals(1, c.getOrderHistory().size());
    }

    @Test
    public void getIDTest() {
        Customer c = new Customer("Miguel");
        assertEquals(1004, c.getID());
    }
}
