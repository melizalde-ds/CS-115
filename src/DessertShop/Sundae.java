/**
* File: Sundae.java
* Description: This class creates a Sundae object.
* Lessons Learned: This helped me understand how to create a class that extends another class.
* Instructor's Name: Barbara Chamberlin
*
* @author: Nelly Barrera and Miguel Elizalde
* @since: 09/27/2023
*/
package DessertShop;

public class Sundae extends IceCream {
    private String toppingName;
    private double toppingPrice;

    public Sundae() {
        super();
        super.setPackaging("");
        this.toppingName = "";
        this.toppingPrice = 0;
    }

    public Sundae(String name, int scoopCount, double pricePerScoop, String toppingName, double toppingPrice) {
        super(name, scoopCount, pricePerScoop);
        super.setPackaging("Boat");
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + toppingPrice;
    }

    @Override
    public String toString() {
        String line1 = getToppingName() + this.getName() + " Sundae" + String.format(" (%s)", getPackaging());
        String line2 = String.format("%d scoops of %s @ $%4.2f/scoop:", getScoopCount(), getName(), getPricePerScoop());
        String line3_1 = String.format("%s topping @ $%4.2f:", getToppingName(), getToppingPrice());
        String line3_2 = String.format("$%4.2f", calculateCost());
        String line3_3 = String.format("[Tax $%4.2f]", calculateTax());
        String outputStr = String.format("%s\n\t%-45s\n\t%-45s%s%17s", line1, line2, line3_1, line3_2, line3_3);
        return outputStr;
    }
}
