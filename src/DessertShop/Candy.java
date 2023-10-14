/**
* File: Candt.java
* Description: This class creates a Candy object.
* Lessons Learned: It helped me understand how to create a class that extends another class.
* Instructor's Name: Barbara Chamberlin
*
* @author: Nelly Barrera and Miguel Elizalde
* @since: 09/27/2023
*/

package DessertShop;

public class Candy extends DessertItem {
    private double candyWeight;
    private double candyPricePerPound;

    public Candy() {
        super();
        super.setPackaging("");
        this.candyWeight = 0;
        this.candyPricePerPound = 0;
    }

    public Candy(String name, double candyWeight, double candyPricePerPound) {
        super(name);
        super.setPackaging("Bag");
        this.candyWeight = candyWeight;
        this.candyPricePerPound = candyPricePerPound;
    }

    public double getCandyWeight() {
        return candyWeight;
    }

    public void setCandyWeight(double candyWeight) {
        this.candyWeight = candyWeight;
    }

    public double getCandyPricePerPound() {
        return candyPricePerPound;
    }

    public void setCandyPricePerPound(double candyPricePerPound) {
        this.candyPricePerPound = candyPricePerPound;
    }

    @Override
    public double calculateCost() {
        return candyWeight * candyPricePerPound;
    }

    @Override
    public String toString() {
        String line1 = this.getName() + String.format(" (%s)", getPackaging());
        String line2_1 = String.format("%4.2f lbs. @ $%4.2f/lb.:", getCandyWeight(), getCandyPricePerPound());
        String line2_2 = String.format("$%4.2f", calculateCost());
        String line2_3 = String.format("[Tax $%4.2f]", calculateTax());
        String outputStr = String.format("%s\n\t%-45s%s%17s", line1, line2_1, line2_2, line2_3);
        return outputStr;
    }
}
