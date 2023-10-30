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

    public Condo(String streetAddress, String zip, int bedCount, int bathCount, double squareFootage, int floorLvl) {
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
}
