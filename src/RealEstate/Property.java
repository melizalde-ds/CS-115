/**
* File: Property.java
* Description: This is a super class that degines the basic attributes of a property.
* Lessons Learned: How to create a super class
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 10/21/2023
*/
package RealEstate;

public abstract class Property {
    private String streetAddress;
    private String zip;
    private double listPrice = 0;
    private double appraisalPrice = 0;

    public Property() {
        this.streetAddress = "";
        this.zip = "";
    }

    public Property(String streetAddress, String zip) {
        this.streetAddress = streetAddress;
        this.zip = zip;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public double getAppraisalPrice() {
        return appraisalPrice;
    }

    protected void setAppraisalPrice(double appraisalPrice) {
        this.appraisalPrice = appraisalPrice;
    }
    
    public abstract void calculateAppraisalPrice();
}
