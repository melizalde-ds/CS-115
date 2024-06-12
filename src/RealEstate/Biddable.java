/**
* File: biddable.java
* Description: This is an interface that degines the basic attributes of a biddable property.
* Lessons Learned: How to create an interface
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 12/02/2023
*/
package RealEstate;

import java.util.HashMap;
import java.util.Set;

public interface Biddable {
    /* Takes no arguments and returns a HashMap<String, Double> containing a list of bidder names (key) and their associated bid (value). */
    public HashMap<String, Double> getBids();

    /* Takes a String argument and returns the Double value for the associated String key in a HashMap<String, Double>. */
    public Double getBid(String bidId);

    /* Takes no arguments and returns a Set<String> of keys from a HashMap<String, Double>. */
    public Set<String> getBidders();

    /* Takes no arguments and returns the number of bids in the HashMap<String, Double>. */
    public int getBidCount();

    /* Returns void. Either updates the value for the key or adds a new key/value pair in a HashMap<String, Double>. */
    public void newBid(String bidder, Double bid);
}
