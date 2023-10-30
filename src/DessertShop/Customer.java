/**
* File: Cookie.java
* Description: This class creates a Cookie object.
* Lessons Learned: This helped me understand how to create a class that extends another class.
* Instructor's Name: Barbara Chamberlin
*
* @author: Nelly Barrera and Miguel Elizalde
* @since: 10/28/2023
*/
package DessertShop;

import java.util.ArrayList;

public class Customer {
    private String custName;
    private ArrayList<Order> orderHistory;
    private int custID;
    private static int nextID = 1000;

    public Customer(String custName) {
        this.custName = custName;
        this.orderHistory = new ArrayList<>();
        this.custID = nextID++;
    }

    public String getName() {
        return custName;
    }

    public void setName(String custName) {
        this.custName = custName;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addToHistory(Order o) {
        this.orderHistory.add(o);
    }

    public int getID() {
        return custID;
    }
    
}
