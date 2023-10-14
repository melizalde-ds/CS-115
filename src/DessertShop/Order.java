/**
* File: Order.java
* Description: This class creates an Order object.
* Lessons Learned: This helped me understand how to create a class that extends another class.
* Instructor's Name: Barbara Chamberlin
*
* @author: Nelly Barrera and Miguel Elizalde
* @since: 09/27/2023
*/
package DessertShop;

import java.util.ArrayList;

public class Order {
    private ArrayList<DessertItem> order;

    public Order() {
        this.order = new ArrayList<DessertItem>();
    }

    public ArrayList<DessertItem> getOrderList() {
        return order;
    }

    public void add(DessertItem dessert) {
        order.add(dessert);
    }

    public int itemCount() {
        return order.size();
    }

    public double orderCost() {
        double totalCost = 0;
        for (DessertItem dessert : order) {
            totalCost += dessert.calculateCost();
        }
        return totalCost;
    }

    public double orderTax() {
        double totalTax = 0;
        for(DessertItem dessert : order) {
            totalTax += dessert.calculateTax();
        }
        return totalTax;
    }

    @Override
    public String toString() {
        String outputStr = "";
        outputStr += "----------------------------------Receipt----------------------------------\n";
        for (DessertItem dessert : order) {
            outputStr += dessert.toString() + "\n";
        }
        outputStr += "----------------------------------------------------------------------------\n";
        String line1 = "Total number of items: " + itemCount();
        String line2_1 = "Order Subtotals: ";
        String line2_2 = String.format("$%4.2f", orderCost());
        String line2_3 = String.format("[Tax $%4.2f]", orderTax());
        String line3_1 = "Order Total: ";
        String line3_2 = String.format("$%4.2f", orderCost() + orderTax());
        outputStr += String.format("%s\n%-53s%s%17s\n%-53s%s", line1, line2_1, line2_2, line2_3, line3_1, line3_2);
        return outputStr;
    }
}
