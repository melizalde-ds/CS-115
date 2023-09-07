package Week1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Lab1a {
    public static void main(String[] args) {
        // Variables and input
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Boolean done = true;
        String response;
        int num;

        // Getting the list of numbers and validating the input
        System.out.println("In this program, you will enter a list of numbers.");
        while (done) {
            System.out.print("Please enter a number (or hit the <Enter> key to stop): ");
            response = input.nextLine();
            if (response.equals("")) {
                done = false;
                break;
            } else {
                try {
                    num = Integer.parseInt(response);
                    numbers.add(num);
                } catch (Exception e) {
                    System.out.println("Invalid response. '" + response + "' is not a number.");
                }
            }
        }

        // Sorting the list of numbers and getting the sum and max values
        Collections.sort(numbers);
        int sum = addNumbers(numbers);
        int max = largestNumber(numbers);

        // Printing the results
        System.out.println("The total of the list of numbers is: " + sum);
        System.out.println("The biggest number in the list is: " + max);

        // Closing the input 
        input.close();
    }

    // Methods
    // Method to add the numbers in the list
    private static int addNumbers(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    // Method to get the largest number in the list
    private static int largestNumber(ArrayList<Integer> numbers) {
        int largest = numbers.get(numbers.size() - 1);
        return largest;
    }
}
