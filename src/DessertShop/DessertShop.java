/**
* File: DessertShop.java
* Description: This class is the main class that runs the Dessert Shop program.
* Lessons Learned: It helped me review the main class
* Instructor's Name: Barbara Chamberlin
*
* @author: Nelly Barrera and Miguel Elizalde
* @since: 11/04/2023
*/
package DessertShop;

import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;

public class DessertShop {
    private static HashMap<String, Customer> customerDB = new HashMap<String, Customer>();
    private static String customerName;

    public static void main(String[] args) {
        Order order = new Order();
        String paymentMethod;

        Scanner sIn = new Scanner(System.in);
        String choice;
        DessertItem orderItem;

        boolean close = false;
        boolean done = false;
        while (!close) {
            boolean payDone = false;
            while (!done) {
                System.out.println("\n1: Candy");
                System.out.println("2: Cookie");
                System.out.println("3: Ice Cream");
                System.out.println("4: Sunday");
                System.out.println("5: Admin Module");

                System.out.print("\nWhat would you like to add to the order? (1-5, Enter for done): ");
                choice = sIn.nextLine();

                if (choice.equals("")) {
                    while (!payDone) {
                        System.out.println("Please enter customer name: ");
                        customerName = sIn.nextLine();
                        if (customerDB.containsKey(customerName)) {
                            customerDB.get(customerName).addToHistory(order);
                        } else {
                            Customer customer = new Customer(customerName);
                            customerDB.put(customer.getName(), customer);
                            customerDB.get(customerName).addToHistory(order);
                        }
                        System.out.println("What form of payment would you like to use? (CASH, CARD, PHONE)");
                        paymentMethod = sIn.nextLine();
                        switch (paymentMethod.toUpperCase()) {
                            case "CASH":
                                order.setPayType(Payable.PayType.CASH);
                                payDone = true;
                                break;
                            case "CARD":
                                order.setPayType(Payable.PayType.CARD);
                                payDone = true;
                                break;
                            case "PHONE":
                                order.setPayType(Payable.PayType.PHONE);
                                payDone = true;
                                break;
                            default:
                                System.out.println("That is not a valid form of payment.");
                                break;
                        }
                    }
                    done = true;
                } else {
                    switch (choice) {
                        case "1":
                            orderItem = userPromptCandy();
                            order.add(orderItem);
                            System.out.printf("%n%s has been added to your order.%n", orderItem.getName());
                            break;
                        case "2":
                            orderItem = userPromptCookie();
                            order.add(orderItem);
                            System.out.printf("%n%s has been added to your order.%n", orderItem.getName());
                            break;
                        case "3":
                            orderItem = userPromptIceCream();
                            order.add(orderItem);
                            System.out.printf("%n%s has been added to your order.%n", orderItem.getName());
                            break;
                        case "4":
                            orderItem = userPromptSundae();
                            order.add(orderItem);
                            System.out.printf("%n%s has been added to your order.%n", orderItem.getName());
                            break;
                        case "5":
                            adminModule();
                            break;
                        default:
                            System.out.println("Invalid response:  Please enter a choice from the menu (1-5)");
                            break;
                    }// end of switch (choice)
                } // end of if (choice.equals(""))
            } // end of while (!done)
            System.out.println("\n");

            order.add(new Candy("Candy Corn", 1.5, .25));
            order.add(new Candy("Gummy Bears", .25, .35));
            order.add(new Cookie("Chocolate Chip", 6, 3.99));
            order.add(new IceCream("Pistachio", 2, .79));
            order.add(new Sundae("Vanilla", 3, .69, "Hot Fudge", 1.29));
            order.add(new Cookie("Oatmeal Raisin", 2, 3.45));

            /*
             * for (DessertItem dessert : order.getOrderList()) {
             * System.out.printf("%-16s $%-4.2f [Tax: $%-4.2f] \n", dessert.getName(),
             * dessert.calculateCost(),
             * dessert.calculateTax());
             * }
             * System.out.println("---------------------------------------------");
             * System.out.printf("Order Subtotal: $%-4.2f [Tax: $%-4.2f] \n",
             * order.orderCost(), order.orderTax());
             * System.out.printf("Order Total: $%-4.2f \n", (order.orderCost() +
             * order.orderTax()));
             * System.out.println("Total number of items in order: " + order.itemCount());
             */
            Collections.sort(order.getOrderList());
            System.out.println(order);
            System.out.println("----------------------------------------------------------------------------");
            String line1 = "Customer Name: " + customerName;
            String line2 = "Customer ID: " + customerDB.get(customerName).getID();
            String line3 = "Total Orders: " + customerDB.get(customerName).getOrderHistory().size();
            System.out.printf("%-29s%-29s%17s\n", line1, line2, line3);
            while (done) {
                System.out.println("\nHit enter to enter a new order");
                String enter = sIn.nextLine();
                if (enter.equals("")) {
                    done = false;
                }
            }
        }
    }

    private static DessertItem userPromptCandy() {
        String name;
        double weight = 0;
        double pricePerPound = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the candy: ");
        name = input.nextLine();
        do {
            try {
                System.out.println("Enter the weight of the candy: ");
                weight = input.nextDouble();
                if (weight <= 0) {
                    System.out.println("Invalid input. Please enter a number greater than 0.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        } while (weight <= 0);
        do {
            try {
                System.out.println("Enter the price per pound of the candy: ");
                pricePerPound = input.nextDouble();
                if (pricePerPound <= 0) {
                    System.out.println("Invalid input. Please enter a number greater than 0.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        } while (pricePerPound <= 0);
        return new Candy(name, weight, pricePerPound);
    }

    private static DessertItem userPromptCookie() {
        String name;
        int cookieQty = 0;
        double pricePerDozen = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the cookie: ");
        name = input.nextLine();
        do {
            try {
                System.out.println("Enter the number of cookies: ");
                cookieQty = input.nextInt();
                if (cookieQty <= 0) {
                    System.out.println("Invalid input. Please enter a number greater than 0.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        } while (cookieQty <= 0);
        do {
            try {
                System.out.println("Enter the price per dozen of the cookie: ");
                pricePerDozen = input.nextDouble();
                if (pricePerDozen <= 0) {
                    System.out.println("Invalid input. Please enter a number greater than 0.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        } while (pricePerDozen <= 0);
        return new Cookie(name, cookieQty, pricePerDozen);
    }

    private static DessertItem userPromptIceCream() {
        String name;
        int scoopCount = 0;
        double pricePerScoop = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the ice cream: ");
        name = input.nextLine();
        do {
            try {
                System.out.println("Enter the number of scoops: ");
                scoopCount = input.nextInt();
                if (scoopCount <= 0) {
                    System.out.println("Invalid input. Please enter a number greater than 0.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        } while (scoopCount <= 0);
        do {
            try {
                System.out.println("Enter the price per scoop of the ice cream: ");
                pricePerScoop = input.nextDouble();
                if (pricePerScoop <= 0) {
                    System.out.println("Invalid input. Please enter a number greater than 0.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        } while (pricePerScoop <= 0);
        return new IceCream(name, scoopCount, pricePerScoop);

    }

    private static DessertItem userPromptSundae() {
        IceCream iceCream = (IceCream) userPromptIceCream();
        String toppingName;
        double toppingPrice = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the topping: ");
        toppingName = input.nextLine();
        do {
            try {
                System.out.println("Enter the price of the topping: ");
                toppingPrice = input.nextDouble();
                if (toppingPrice <= 0) {
                    System.out.println("Invalid input. Please enter a number greater than 0.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        } while (toppingPrice <= 0);
        return new Sundae(iceCream.getName(), iceCream.getScoopCount(), iceCream.getPricePerScoop(), toppingName,
                toppingPrice);
    }

    private static void adminModule() {
        Scanner sIn = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            System.out.println("\n1: Shop Customer List");
            System.out.println("2: Customer Order History");
            System.out.println("3: Best Customer");
            System.out.println("4: Exit Admin Module");

            System.out.print("\nWhat would you like to do? (1-4): ");
            String choice = sIn.next();
            try {
                switch (Integer.parseInt(choice)) {
                    case 1:
                        String line1 = "Customer Name: ";
                        String line2 = "Customer ID: ";

                        System.out.println("Customer List: ");
                        for (String key : customerDB.keySet()) {
                            System.out.printf("%s%-16s %s%s\n", line1, key, line2, customerDB.get(key).getID());
                        }
                        break;
                    case 2:
                        System.out.println("Enter the name of the customer: ");
                        String customerName = sIn.next();
                        if (customerDB.containsKey(customerName)) {
                            for (int i = 0; i < customerDB.get(customerName).getOrderHistory().size(); i++) {
                                System.out.println("Order " + (i + 1) + ":");
                                System.out.println(customerDB.get(customerName).getOrderHistory().get(i));
                                System.out.println("\n");
                            }
                        } else {
                            System.out.println("Customer not found.");
                        }
                        break;
                    case 3:
                        Customer bestCustomer = null;
                        int bestCustomerOrders = 0;
                        for (String key : customerDB.keySet()) {
                            if (customerDB.get(key).getOrderHistory().size() > bestCustomerOrders) {
                                bestCustomer = customerDB.get(key);
                                bestCustomerOrders = bestCustomer.getOrderHistory().size();
                            }
                        }
                        System.out.println("The Dessert Shop's most valued customer is: " + bestCustomer.getName());
                        break;
                    case 4:
                        done = true;
                        break;
                    default:
                        System.out.println("Invalid response:  Please enter a choice from the menu (1-4)");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid response:  Please enter a choice from the menu (1-4)");
            }
        }
    }
}
