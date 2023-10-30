/**
* File: Order.java
* Description: This class creates an Order object.
* Lessons Learned: This helped me understand how to create a class that extends another class.
* Instructor's Name: Barbara Chamberlin
*
* @author: Nelly Barrera and Miguel Elizalde
* @since: 10/21/2023
*/
package DessertShop;

import java.util.ArrayList;

public class Order implements Payable {
    private ArrayList<DessertItem> order;
    private PayType payMethod;

    public Order() {
        this.order = new ArrayList<DessertItem>();
        this.payMethod = PayType.CASH;
    }

    public ArrayList<DessertItem> getOrderList() {
        return order;
    }

    public void add(DessertItem dessert) {
        int flag = 0;
        if (dessert instanceof Candy) {
            Candy c = (Candy) dessert;
            for (int i = 0; i < order.size(); i++) {
                if (order.get(i) instanceof Candy) {
                    Candy candyItem = (Candy) order.get(i);
                    if (candyItem.sameItem(c)) {
                        candyItem.setCandyWeight(candyItem.getCandyWeight() + c.getCandyWeight());
                        flag = 1;
                        break;
                    }
                }
            }
        }
        if (dessert instanceof Cookie) {
            Cookie c = (Cookie) dessert;
            for (int i = 0; i < order.size(); i++) {
                if (order.get(i) instanceof Cookie) {
                    Cookie cookieItem = (Cookie) order.get(i);
                    if (cookieItem.sameItem(c)) {
                        cookieItem.setCookieQty(cookieItem.getCookieQty() + c.getCookieQty());
                        flag = 1;
                        break;
                    }
                }
            }
            
        }
        if (flag == 0) {
            order.add(dessert);
        }

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
        for (DessertItem dessert : order) {
            totalTax += dessert.calculateTax();
        }
        return totalTax;
    }

    @Override
    public PayType getPayType() {
        return payMethod;
    }

    @Override
    public void setPayType(PayType payType) {
        this.payMethod = payType;
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
        String line4 = "Paid for with " + getPayType();
        outputStr += String.format("%s\n%-53s%s%17s\n%-53s%s\n%s", line1, line2_1, line2_2, line2_3, line3_1, line3_2,
                line4);
        return outputStr;
    }
}
