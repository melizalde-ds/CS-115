/**
* File: Cookie.java
* Description: This class creates a Cookie object.
* Lessons Learned: This helped me understand how to create a class that extends another class.
* Instructor's Name: Barbara Chamberlin
*
* @author: Nelly Barrera and Miguel Elizalde
* @since: 09/27/2023
*/
package DessertShop;

public class Cookie extends DessertItem implements SameItem{
    private int cookieQty;
    private double pricePerDozen;

    public Cookie() {
        super();
        super.setPackaging("");
        this.cookieQty = 0;
        this.pricePerDozen = 0;
    }

    public Cookie(String name, int cookieQty, double pricePerDozen) {
        super(name);
        super.setPackaging("Box");
        this.cookieQty = cookieQty;
        this.pricePerDozen = pricePerDozen;
    }

    public int getCookieQty() {
        return cookieQty;
    }

    public void setCookieQty(int cookieQty) {
        this.cookieQty = cookieQty;
    }

    public double getPricePerDozen() {
        return pricePerDozen;
    }

    public void setPricePerDozen(double pricePerDozen) {
        this.pricePerDozen = pricePerDozen;
    }

    @Override
    public double calculateCost() {
        return cookieQty * (pricePerDozen / 12);
    }

    @Override
    public String toString() {
        String line1 = this.getName() + " Cookie" + String.format(" (%s)", getPackaging());
        String line2_1 = String.format("%d cookies @ $%4.2f/dozen:", getCookieQty(), getPricePerDozen());
        String line2_2 = String.format("$%-4.2f", calculateCost());
        String line2_3 = String.format("[Tax $%4.2f]", calculateTax());
        String outputStr = String.format("%s\n\t%-45s%s%17s", line1, line2_1, line2_2, line2_3);
        return outputStr;
    }

    @Override
    public boolean sameItem(Object o) {
        if (o instanceof Cookie) {
            Cookie c = (Cookie) o;
            if (this.getName().equals(c.getName()) && this.getPricePerDozen() == c.getPricePerDozen()) {
                return true;
            }
        }
        return false;
    }
}
