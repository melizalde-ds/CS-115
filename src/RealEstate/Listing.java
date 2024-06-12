package RealEstate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Listing implements Listable {
    HashMap<String, Residential> listings;

    public Listing() {
        listings = new HashMap<String, Residential>();
    }

    @Override
    public HashMap<String, Residential> getListings() {
        return listings;
    }

    @Override
    public Residential getListing(String listingId) {
        return listings.get(listingId);
    }

    @Override
    public Set<String> getAddresses() {
        return listings.keySet();
    }

    @Override
    public Collection<Residential> getResidences() {
        return listings.values();
    }

    @Override
    public int getListingCount() {
        return listings.size();
    }

    @Override
    public void addListing(String address, Residential residence) {
        listings.put(address, residence);
    }

}
