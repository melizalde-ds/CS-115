/**
* File: Residential.java
* Description: This is a sub class that degines the basic attributes of a residential property.
* Lessons Learned: How to create a sub class
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 12/02/2023
*/
package RealEstate;

import java.util.HashMap;
import java.util.Set;

public abstract class Residential extends Property implements Biddable{
    private int bedCount;
    private int bathCount;
    private double squareFootage;
    private HashMap<String, Double> bids = new HashMap<String, Double>();

    public Residential() {
        super();
        this.bedCount = 0;
        this.bathCount = 0;
        this.squareFootage = 0.0;
    }

    public Residential(String streetAddress, int zip, int bedCount, int bathCount, double squareFootage) {
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

    @Override
    public HashMap<String, Double> getBids() {
        return bids;
    }

    @Override
    public Double getBid(String bidId) {
        return bids.get(bidId);
    }

    @Override
    public Set<String> getBidders() {
        return bids.keySet();
    }

    @Override
    public int getBidCount() {
        return bids.size();
    }

    @Override
    public void newBid(String bidder, Double bid) {
        bids.put(bidder, bid);
    }
}
