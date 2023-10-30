/**
* File: Residential.java
* Description: This is a sub class that degines the basic attributes of a residential property.
* Lessons Learned: How to create a sub class
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 10/14/2023
*/
package RealEstate;

public abstract class Residential extends Property {
    private int bedCount;
    private int bathCount;
    private double squareFootage;

    public Residential() {
        super();
        this.bedCount = 0;
        this.bathCount = 0;
        this.squareFootage = 0.0;
    }

    public Residential(String streetAddress, String zip, int bedCount, int bathCount, double squareFootage) {
        super(streetAddress, zip);
        this.bedCount = bedCount;
        this.bathCount = bathCount;
        this.squareFootage = squareFootage;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public int getBathCount() {
        return bathCount;
    }

    public void setBathCount(int bathCount) {
        this.bathCount = bathCount;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public abstract void calculateAppraisalPrice();
}
