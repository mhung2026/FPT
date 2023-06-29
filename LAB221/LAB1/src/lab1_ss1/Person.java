/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_ss1;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author NGOMI
 */
public class Person {

    protected String id;
    protected String name;
    protected int age;
    protected String gender;
    protected String address;
    protected String phone;

    public Person() {
    }

    public Person(String id, String name, int age, String gender, String address, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private Scanner sc = new Scanner(System.in);

    public String inputName() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);

                System.out.print("Enter the person's name: ");
                String name = sc.nextLine();
                if (name.length() < 5 || name.length() > 20) {
                    throw new Exception("Invalid name");
                }
                return name;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public int inputAge() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the person's age: ");
                int age = sc.nextInt();
                if (age < 1 || age > 150) {
                    throw new Exception("Invalid age");
                }
                return age;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public String inputGender() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the person's gender (M/F): ");
                String gender = sc.nextLine();
                if (gender.length() != 1) {
                    throw new Exception("Invalid gender");
                } else {
                    if (gender.equals("m")) {
                        return "Male";
                    }
                    if (gender.equals("f")) {
                        return "Female";
                    }
                    if (gender.equals("M")) {
                        return "Male";
                    }
                    if (gender.equals("F")) {
                        return "Female";
                    }
                    throw new Exception("Invalid gender");

                }

            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public boolean checkPhone(String input) {
        if (input.isEmpty()) {
            return false;
        }
        if (!input.startsWith("0")) {
            return false;
        }
        if (input.length() != 10) {
            return false;
        }
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                return false;
            }
        }

        return true;
    }

    public String inputPhone() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the person's phone number: ");
                String phone = sc.nextLine();
                if (!checkPhone(phone)) {
                    throw new Exception("Invalid phone");
                }
                return phone;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public String inputAddress() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the person's address: ");
                String address = sc.nextLine();
                if (address.length() < 5 || address.length() > 20) {
                    throw new Exception("Invalid address");
                }
                return address;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public void input() {
        this.name = inputName();
        this.age = inputAge();
        this.gender = inputGender();
        this.phone = inputPhone();
        this.address = inputAddress();
    }

}
