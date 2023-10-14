/**
* File: IceCream.java
* Description: This class creates an IceCream object.
* Lessons Learned: This helped me understand how to create a class that extends another class.
* Instructor's Name: Barbara Chamberlin
*
* @author: Nelly Barrera and Miguel Elizalder
* @since: 09/27/2023
*/
package DessertShop;

public class IceCream extends DessertItem {
    private int scoopCount;
    private double pricePerScoop;

    public IceCream() {
        super();
        super.setPackaging("");
        this.scoopCount = 0;
        this.pricePerScoop = 0;
    }

    public IceCream(String name, int scoopCount, double pricePerScoop) {
        super(name);
        super.setPackaging("Bowl");
        this.scoopCount = scoopCount;
        this.pricePerScoop = pricePerScoop;
    }

    public int getScoopCount() {
        return scoopCount;
    }

    public void setScoopCount(int scoopCount) {
        this.scoopCount = scoopCount;
    }

    public double getPricePerScoop() {
        return pricePerScoop;
    }

    public void setPricePerScoop(double pricePerScoop) {
        this.pricePerScoop = pricePerScoop;
    }

    @Override
    public double calculateCost() {
        return scoopCount * pricePerScoop;
    }

    @Override
    public String toString() {
        String line1 = this.getName() + " Ice Cream" + String.format(" (%s)", getPackaging());
        String line2_1 = String.format("%d scoops @ $%4.2f/scoop:", getScoopCount(), getPricePerScoop());
        String line2_2 = String.format("$%4.2f", calculateCost());
        String line2_3 = String.format("[Tax $%4.2f]", calculateTax());
        String outputStr = String.format("%s\n\t%-45s%s%17s", line1, line2_1, line2_2, line2_3);
        return outputStr;
    }
}
