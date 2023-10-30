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

    public House(String streetAddress, String zip, int bedCount, int bathCount, double squareFootage,
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
        this.setAppraisalPrice((getSquareFootage()*97)+(getBedCount()*10000)+(getBathCount()*12000)+(d.intValue()*10000));
    }
}
