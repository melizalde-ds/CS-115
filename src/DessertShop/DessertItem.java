/**
* File: DessertItem.java
* Description: This class creates a DessertItem object.
* Lessons Learned: This helped me review how to create a superclass.
* Instructor's Name: Barbara Chamberlin
*
* @author: Barbara Chamberlin
* @since: 09/27/2023
*/
package DessertShop;

public abstract class DessertItem implements Packaging {
    private String packaging;
    private String name;
    private double taxPercent = 7.25;

    public DessertItem() {
        this.name = "";
    }

    public DessertItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public abstract double calculateCost();

    public double calculateTax() {
        return calculateCost() * (taxPercent / 100);
    }
}
