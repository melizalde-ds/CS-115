/**
* File: Condo.java
* Description: This is a sub class that degines the basic attributes of a condo.
* Lessons Learned: How to create a sub class
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 10/14/2023
*/
package RealEstate;

public class Condo extends Residential {
    private int floorLvl;

    public Condo() {
        super();
        this.floorLvl = 0;
    }

    public Condo(String streetAddress, int zip, int bedCount, int bathCount, double squareFootage, int floorLvl) {
        super(streetAddress, zip, bedCount, bathCount, squareFootage);
        this.floorLvl = floorLvl;
    }

    public int getFloorLvl() {
        return floorLvl;
    }

    public void setFloorLvl(int floorLvl) {
        this.floorLvl = floorLvl;
    }

    @Override
    public void calculateAppraisalPrice() {
        this.setAppraisalPrice((getSquareFootage()*88)+(getBedCount()*8000)+(getBathCount()*10000)+((getFloorLvl()-1)*10000));
    }

    @Override
    public String toString() {
        String s = "----------------------------------------------------------------------------------\n";
        String line1_1 = "Residence Type: Condo";
        String line1_2 = "Address: " + getStreetAddress();
        String line1_3 = "Zip Code: " + getZip();
        s += String.format("%-30s %-30s %s\n", line1_1, line1_2, line1_3);
        s += "----------------------------------------------------------------------------------\n";
        s += String.format("%s %d\n", "Bedrooms:", getBedCount());
        s += String.format("%s %d\n", "Bathrooms:", getBathCount());
        s += String.format("%s %.2f ft2\n", "Sq Footage:", getSquareFootage());
        s += String.format("%s %d\n", "Floor:", getFloorLvl());
        s += "----------------------------------------------------------------------------------\n";
        s += String.format("%s $%,.2f\n", "Appraisal Price:", getAppraisalPrice());
        s += String.format("%s $%,.2f\n", "Listing Price:", getListPrice());
        s += "----------------------------------------------------------------------------------\n";
        return s;
    }
}
