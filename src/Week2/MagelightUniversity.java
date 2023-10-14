/**
* File: MagelightUniversity.java
* Description: A short program that creates an ArrayList of Person objects and prints them
* Lessons Learned: It helped me remeber how to use printf
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde Cruz
* @since: 09/23/2023
*/

package Week2;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class MagelightUniversity {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("Rachel", "1993-05-12", "F", "801-555-1212"));
        people.add(new Person("Jose", "2004-12-01", "M", "480-555-1212"));
        people.add(new Person("Prya", "2001-02-27", "F", "385-555-1212"));
        people.add(new Person("Bob", "1984-06-06", "M", "916-555-1212"));

        LocalDate today = LocalDate.now();

        String format = "%-15s %-6s %-8s %-20s \n";
        System.out.printf(format, "Name", "Age", "Gender", "Phone");
        System.out.println("----------------------------------------------------------");
        for (Person p : people) {
            Period age = Period.between(p.getDob(), today);
            System.out.printf(format, p.getName(), age.getYears(), p.getGender(), p.getPhone());
        }
    }
}
