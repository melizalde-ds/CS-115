/**
* File: Person.java
* Description: Person class.
* Lessons Learned: This project helped me remember many java syntax and the use of LocalDate
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde Cruz
* @since: 09/23/2023
*/

package Week2;

import java.time.LocalDate;

public class Person {
    String name;
    LocalDate dob;
    String gender;
    String phone;

    public Person() {
        this.name = "name";
        this.dob = LocalDate.parse("1900-01-01");
        this.gender = "gender";
        this.phone = "000-000-0000";
    }

    public Person(String name, String dob, String gender, String phone) {
        this.name = name;
        this.dob = LocalDate.parse(dob);
        this.gender = gender;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = LocalDate.parse(dob);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }  
}
