/**
* File: PersonTest.java
* Description: JUnit tests for Person.java methods
* Lessons Learned: It helped me understand a little bit more how to debugg without printing everything.
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde Cruz
* @since: 09/23/2023
*/

package Week2;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.*;

public class PersonTest {
    @Test
    public void getNameTestNull() {
        Person p = new Person();
        String name = p.getName();
        assertEquals(name, "name");
    }

    @Test
    public void getNameTestFull() {
        Person p = new Person("Jenny", "2003-05-05", "F", "801-867-5309");
        String name = p.getName();
        assertEquals(name, "Jenny");
    }

    @Test
    public void setNameTest() {
        Person p = new Person("Jenny", "2003-05-05", "F", "801-867-5309");
        p.setName("Jhony");
        String name = p.getName();
        assertEquals(name, "Jhony");
    }

    @Test
    public void getDobTestNull() {
        Person p = new Person();
        LocalDate dob = p.getDob();
        assertEquals(dob, LocalDate.parse("1900-01-01"));
    }

    @Test
    public void getDobTestFull() {
        Person p = new Person("Jenny", "2003-05-05", "F", "801-867-5309");
        LocalDate dob = p.getDob();
        assertEquals(dob, LocalDate.parse("2003-05-05"));
    }

    @Test
    public void setDobTest() {
        Person p = new Person("Jenny", "2003-05-05", "F", "801-867-5309");
        p.setDob("2004-06-08");
        LocalDate dob = p.getDob();
        assertEquals(dob, LocalDate.parse("2004-06-08"));
    }

    @Test
    public void getGenderTestNull() {
        Person p = new Person();
        String gender = p.getGender();
        assertEquals(gender, "gender");
    }

    @Test
    public void getGenderTestFull() {
        Person p = new Person("Jenny", "2003-05-05", "F", "801-867-5309");
        String gender = p.getGender();
        assertEquals(gender, "F");
    }

    @Test
    public void setGenderTest() {
        Person p = new Person("Jenny", "2003-05-05", "F", "801-867-5309");
        p.setGender("M");
        String gender = p.getGender();
        assertEquals(gender, "M");
    }

    @Test
    public void getPhoneTestNull() {
        Person p = new Person();
        String phone = p.getPhone();
        assertEquals(phone, "000-000-0000");
    }

    @Test
    public void getPhoneTestFull() {
        Person p = new Person("Jenny", "2003-05-05", "F", "801-867-5309");
        String phone = p.getPhone();
        assertEquals(phone, "801-867-5309");
    }

    @Test
    public void setPhoneTest() {
        Person p = new Person("Jenny", "2003-05-05", "F", "801-867-5309");
        p.setPhone("385-852-6512");
        String phone = p.getPhone();
        assertEquals(phone, "385-852-6512");
    }
}
