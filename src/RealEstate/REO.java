/**
* File: REO.java
* Description: This class is the main class that runs the program. It has a menu that allows the user to navigate through the program.
* Lessons Learned: It helped me review the main class
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 12/03/2023
*/
package RealEstate;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class REO {
    private static Listing reoListings = new Listing();

    public static void main(String[] args) {
        Scanner sIn = new Scanner(System.in);
        boolean close = false;
        while (!close) {
            System.out.println("-----------------------------------------");
            System.out.printf("%25s\n", "Main Menu");
            System.out.println("-----------------------------------------");
            System.out.println("1: Listings");
            System.out.println("2: Bids");
            System.out.println("What would you like to do? (1-2):");
            String input = sIn.nextLine();
            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        listings();
                        break;
                    case 2:
                        bids();
                        break;
                    default:
                        System.out.println("Invalid input. Please enter a number between 1 and 2");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 2");
            }
        }
    }

    private static void listings() {
        Scanner sIn = new Scanner(System.in);
        boolean close = false;
        while (!close) {
            System.out.println("-----------------------------------------");
            System.out.printf("%25s\n", "Listing Menu");
            System.out.println("-----------------------------------------");
            System.out.println("1: Add Listing");
            System.out.println("2: Show Listings");
            System.out.println("3: Auto Populate Listings (Dev Tool)");
            System.out.println("ENTER: Exit back to the previous menu");
            System.out.println("What would you like to do? (1-3):");
            String input = sIn.nextLine();
            if (input.equals("")) {
                close = true;
            } else {
                try {
                    int choice = Integer.parseInt(input);
                    switch (choice) {
                        case 1:
                            addListing();
                            break;
                        case 2:
                            showListings();
                            break;
                        case 3:
                            autoPopulate();
                            break;
                        default:
                            System.out.println("Invalid input. Please enter a number between 1 and 3");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 3");
                }
            }
        }
    }

    private static void addListing() {
        Scanner sIn = new Scanner(System.in);
        boolean close = false;
        while (!close) {
            System.out.println("-----------------------------------------");
            System.out.printf("%25s\n", "Add Listing Menu");
            System.out.println("-----------------------------------------");
            System.out.println("1: Add House");
            System.out.println("2: Add Condo");
            System.out.println("ENTER: Exit back to the previous menu");
            System.out.println("What would you like to do? (1-2):");
            String input = sIn.nextLine();
            if (input.equals("")) {
                close = true;
            } else {
                try {
                    int choice = Integer.parseInt(input);
                    switch (choice) {
                        case 1:
                            addHouse();
                            break;
                        case 2:
                            addCondo();
                            break;
                        default:
                            System.out.println("Invalid input. Please enter a number between 1 and 2");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 2");
                }
            }
        }
    }

    private static void addHouse() {
        Scanner sIn = new Scanner(System.in);
        boolean close = false;
        String address = "";
        int zipCode = 0;
        int bedCount = 0;
        int bathCount = 0;
        double squareFootage = 0.0;
        double yardAcres = 0.0;

        while (!close) {
            try {
                System.out.println("Enter the address of the house:");
                address = sIn.nextLine();
                System.out.println("Enter the zip code of the house:");
                zipCode = Integer.parseInt(sIn.nextLine());
                System.out.println("Enter the number of bedrooms in the house:");
                bedCount = Integer.parseInt(sIn.nextLine());
                System.out.println("Enter the number of bathrooms in the house:");
                bathCount = Integer.parseInt(sIn.nextLine());
                System.out.println("Enter the square footage of the house:");
                squareFootage = Double.parseDouble(sIn.nextLine());
                System.out.println("Enter the yard acres of the house:");
                yardAcres = Double.parseDouble(sIn.nextLine());
                close = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        House house = new House(address, zipCode, bedCount, bathCount, squareFootage, yardAcres);
        house.calculateAppraisalPrice();
        System.out.println(
                "\nThe appraisal price of the house is: " + String.format("$%,.2f", house.getAppraisalPrice()));
        while (close) {
            try {
                System.out.println("Enter the list price of the house:");
                house.setListPrice(Double.parseDouble(sIn.nextLine()));
                close = false;
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        reoListings.addListing(address, house);
        System.out.println("You have created a new listing!");
        System.out.println(house.toString());
    }

    private static void addCondo() {
        Scanner sIn = new Scanner(System.in);
        boolean close = false;
        String address = "";
        int zipCode = 0;
        int bedCount = 0;
        int bathCount = 0;
        double squareFootage = 0.0;
        int floorNumber = 0;

        while (!close) {
            try {
                System.out.println("Enter the address of the condo:");
                address = sIn.nextLine();
                System.out.println("Enter the zip code of the condo:");
                zipCode = Integer.parseInt(sIn.nextLine());
                System.out.println("Enter the number of bedrooms in the condo:");
                bedCount = Integer.parseInt(sIn.nextLine());
                System.out.println("Enter the number of bathrooms in the condo:");
                bathCount = Integer.parseInt(sIn.nextLine());
                System.out.println("Enter the square footage of the condo:");
                squareFootage = Double.parseDouble(sIn.nextLine());
                System.out.println("Enter the floor number of the condo:");
                floorNumber = Integer.parseInt(sIn.nextLine());
                close = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        Condo condo = new Condo(address, zipCode, bedCount, bathCount, squareFootage, floorNumber);
        condo.calculateAppraisalPrice();
        System.out.println(
                "\nThe appraisal price of the condo is: " + String.format("$%,.2f", condo.getAppraisalPrice()));
        while (close) {
            try {
                System.out.println("Enter the list price of the condo:");
                condo.setListPrice(Double.parseDouble(sIn.nextLine()));
                close = false;
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        reoListings.addListing(address, condo);
        System.out.println("You have created a new listing!");
        System.out.println(condo.toString());
    }

    private static void showListings() {
        int count = 0;
        System.out.println("Current Listings for REO:");
        for (String address : reoListings.getAddresses()) {
            System.out.println("Listing No: " + ++count);
            System.out.println(reoListings.getListing(address).toString());
        }
    }

    private static void autoPopulate() {
        House house1 = new House("34 Elm", 95129, 3, 2, 2200, .2);
        house1.calculateAppraisalPrice();
        house1.setListPrice(house1.getAppraisalPrice() * 1.1);
        reoListings.addListing("34 Elm", house1);
        House house2 = new House("42 Hitchhikers", 95136, 4, 3, 2800, .3);
        house2.calculateAppraisalPrice();
        house2.setListPrice(house2.getAppraisalPrice() * 1.1);
        reoListings.addListing("42 Hitchhikers", house2);
        Condo condo1 = new Condo("4876 Industrial", 95177, 3, 1, 1800, 3);
        condo1.calculateAppraisalPrice();
        condo1.setListPrice(condo1.getAppraisalPrice() * 1.1);
        reoListings.addListing("4876 Industrial", condo1);
        House house3 = new House("2654 Oak", 84062, 5, 53, 4200, .5);
        house3.calculateAppraisalPrice();
        house3.setListPrice(house3.getAppraisalPrice() * 1.1);
        reoListings.addListing("2654 Oak", house3);
        Condo condo2 = new Condo("9875 Lexington", 84063, 2, 1, 1500, 1);
        condo2.calculateAppraisalPrice();
        condo2.setListPrice(condo2.getAppraisalPrice() * 1.1);
        reoListings.addListing("9875 Lexington", condo2);
        Condo condo3 = new Condo("3782 Market", 84066, 3, 1, 1800, 2);
        condo3.calculateAppraisalPrice();
        condo3.setListPrice(condo3.getAppraisalPrice() * 1.1);
        reoListings.addListing("3782 Market", condo3);
        House house4 = new House("7608 Glenwood", 84055, 6, 3, 3900, .4);
        house4.calculateAppraisalPrice();
        house4.setListPrice(house4.getAppraisalPrice() * 1.1);
        reoListings.addListing("7608 Glenwood", house4);
        House house5 = new House("1220 Apple", 84057, 8, 7, 7900, 1);
        house5.calculateAppraisalPrice();
        house5.setListPrice(house5.getAppraisalPrice() * 1.1);
        reoListings.addListing("1220 Apple", house5);
        System.out.println("8 listings have been added to the REO listings for testing purposes.");
    }

    private static void bids() {
        Scanner sIn = new Scanner(System.in);
        boolean close = false;
        while (!close) {
            System.out.println("-----------------------------------------");
            System.out.printf("%25s\n", "Bids Menu");
            System.out.println("-----------------------------------------");
            System.out.println("1: Add New Bid");
            System.out.println("2: Show Existing Bids");
            System.out.println("3: Auto Populate Bids (Dev Tool)");
            System.out.println("ENTER: Exit back to the previous menu");
            System.out.println("What would you like to do? (1-3):");
            String input = sIn.nextLine();
            if (input.equals("")) {
                close = true;
            } else {
                try {
                    int choice = Integer.parseInt(input);
                    switch (choice) {
                        case 1:
                            addBid();
                            break;
                        case 2:
                            showBids();
                            break;
                        case 3:
                            autoPopulateBids();
                            break;
                        default:
                            System.out.println("Invalid input. Please enter a number between 1 and 3");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 3");
                }
            }
        }
    }

    private static void addBid() {
        Scanner sIn = new Scanner(System.in);
        boolean close = false;
        int count;
        while (!close) {
            count = 0;
            System.out.println("Current Listings for REO:");
            System.out.printf("%-8s%s\n", "No.", "Property (bids)");
            System.out.println("-----------------------------------------");
            for (String address : reoListings.getAddresses()) {
                System.out.printf("%d: %s (%d)\n", ++count, address, reoListings.getListing(address).getBidCount());
            }
            System.out.println("ENTER: Exit back to the previous menu.\n");
            System.out.println("Which listing would you like to add a bid?: ");
            String input = sIn.nextLine();
            if (input.equals("")) {
                close = true;
            } else {
                try {
                    int choice = Integer.parseInt(input);
                    Residential property = reoListings
                            .getListing((String) Array.get(reoListings.getAddresses().toArray(), choice - 1));
                    if (choice > 0 && choice <= count) {
                        System.out.println(property.toString());
                        System.out.println("Enter the name of the bidder:");
                        String bidder = sIn.nextLine();
                        System.out.println("Enter the bid amount:");
                        Double bid = Double.parseDouble(sIn.nextLine());
                        property.newBid(bidder, bid);
                        System.out
                                .println(
                                        "New bid for property '" + property.getStreetAddress() + "' has been added!\n");
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and " + count);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and " + count);
                }
            }
        }
    }

    private static void showBids() {
        Scanner sIn = new Scanner(System.in);
        boolean close = false;
        int count;
        while (!close) {
            count = 0;
            System.out.println("\nCurrent Listings for REO:");
            System.out.printf("%-8s%s\n", "No.", "Property (bids)");
            System.out.println("-----------------------------------------");
            for (String address : reoListings.getAddresses()) {
                System.out.printf("%d: %s (%d)\n", ++count, address, reoListings.getListing(address).getBidCount());
            }
            System.out.println("ENTER: Exit back to the previous menu.\n");
            System.out.println("For which property would you like to see the current bids?: ");
            String input = sIn.nextLine();
            if (input.equals("")) {
                close = true;
            } else {
                try {
                    int choice = Integer.parseInt(input);
                    Residential property = reoListings
                            .getListing((String) Array.get(reoListings.getAddresses().toArray(), choice - 1));
                    if (choice > 0 && choice <= count) {
                        System.out.println(property.toString());
                        System.out.println("Current bids for this listing:");
                        System.out.println("-----------------------------------------");
                        System.out.printf("%8s%20s\n", "Bidder", "Bid Amount");
                        System.out.println("-----------------------------------------");
                        for (String bidder : property.getBidders()) {
                            System.out.printf("%-20s%s\n", bidder, String.format("$%,.2f", property.getBid(bidder)));
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and " + count);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and " + count);
                }
            }
        }
    }

    private static void autoPopulateBids() {
        Random r = new Random();
        int finalCount;
        String[] autoBidders = { "Patric Stewart", "Walter Koenig", "William Shatner", "Leonard Nimoy",
                "DeForect Kelley", "James Doohan", "George Takei", "Majel Barrett", "Nichelle Nichol", "Jonathan Frank",
                "Marina Sirtis", "Brent Spiner", "Gates McFadden", "Michael Dorn", "LeVar Burton", "Wil Wheaton",
                "Colm Meaney", "Michelle Forbes" };
        for (String address : reoListings.getAddresses()) {
            finalCount = 0;
            Residential property = reoListings.getListing(address);
            for (int i = 0; i < r.nextInt(8)+2; i++) {
                property.newBid(autoBidders[r.nextInt(autoBidders.length)], (1+(r.nextDouble(.2)-.1))*property.getAppraisalPrice());
                finalCount++;
            }
            System.out.println(finalCount + " new bids have been added to listing " + property.getStreetAddress() + " ("+property.getBidCount()+").");
        }
        
    }
}
