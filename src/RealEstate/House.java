/**
* File: House.java
* Description: This is a sub class that degines the basic attributes of a house.
* Lessons Learned: How to create a sub class
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 10/14/2023
*/
package RealEstate;

public class House extends Residential {
    private double yardAcres;

    public House() {
        super();
        this.yardAcres = 0.0;
    }

    public House(String streetAddress, int zip, int bedCount, int bathCount, double squareFootage,
            double yardAcres) {
        super(streetAddress, zip, bedCount, bathCount, squareFootage);
        this.yardAcres = yardAcres;
    }

    public double getYardAcres() {
        return yardAcres;
    }

    public void setYardAcres(double yardAcres) {
        this.yardAcres = yardAcres;
    }

    @Override
    public void calculateAppraisalPrice() {
        Double d = getYardAcres();
        this.setAppraisalPrice((getSquareFootage() * 97) + (getBedCount() * 10000) + (getBathCount() * 12000)
                + (d.intValue() * 10000));
    }

    @Override
    public String toString() {
        String s = "----------------------------------------------------------------------------------\n";
        String line1_1 = "Residence Type: House";
        String line1_2 = "Address: " + getStreetAddress();
        String line1_3 = "Zip Code: " + getZip();
        s += String.format("%-30s %-30s %s\n", line1_1, line1_2, line1_3);
        s += "----------------------------------------------------------------------------------\n";
        s += String.format("%s %d\n", "Bedrooms:", getBedCount());
        s += String.format("%s %d\n", "Bathrooms:", getBathCount());
        s += String.format("%s %.2f ft2\n", "Sq Footage:", getSquareFootage());
        s += String.format("%s %.2f\n", "Yard Size (Acres):", getYardAcres());
        s += "----------------------------------------------------------------------------------\n";
        s += String.format("%s $%,.2f\n", "Appraisal Price:", getAppraisalPrice());
        s += String.format("%s $%,.2f\n", "Listing Price:", getListPrice());
        s += "----------------------------------------------------------------------------------\n";
        return s;
    }
}
