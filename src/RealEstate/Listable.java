package RealEstate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public interface Listable {
    /* Takes no arguments and returns a HashMap<String, Residential> containing a list of street addresses (key) and their associated residences (value) */
    public HashMap<String, Residential> getListings();

    /* Takes a String argument and returns the Residential value for the associated String key in a HashMap<String, Residential> */
    public Residential getListing(String listingId);

    /* Takes no arguments and returns a Set<String> of keys from a HashMap<String, Residential> */
    public Set<String> getAddresses();

    /* Takes no arguments and returns a Collection<Residential> of values from a HashMap<String, Residential> */
    public Collection<Residential> getResidences();

    /* Takes no arguments and returns the number of listings in the HashMap<String, Residential> */
    public int getListingCount();

    /* Returns void. Adds a new key/value pair in a HashMap<String, Residential> */
    public void addListing(String address, Residential residence);
}
