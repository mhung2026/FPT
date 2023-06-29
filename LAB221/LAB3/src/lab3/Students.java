package lab3;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Students {

    private String id;
    private String name;
    private String major;
    private String email;
    private String phone;
    private String passport;
    private String address;

    public Students() {

    }

    public Students(String id, String name, String major, String email, String phone, String passport, String address) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.email = email;
        this.phone = phone;
        this.passport = passport;
        this.address = address;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String inputId(HashMap hashmap) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Id (Sxxx): ");
                String id = sc.nextLine();
                if (!id.matches("^S\\d{3}$")) {
                    throw new Exception("Id is incorrect");
                }
                Set<String> keyset = hashmap.keySet();
                for (String key : keyset) {
                    if (key.matches(id)) {
                        throw new Exception("The ID you entered already exists");
                    }
                }
                return id;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public String inputName() {
        while (true) {
            System.out.print("Enter name: ");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            if (!name.isEmpty()) {
                return name;
            } else {
                System.out.println("Name can not is empty!");
            }
        }
    }

    public String inputMajor() {
        while (true) {
            System.out.print("Enter major (SE/SB/GD/MC): ");
            Scanner sc = new Scanner(System.in);
            String major = sc.nextLine();
            if (!major.isEmpty()) {
                if (major.matches("SE") || major.matches("SB") || major.matches("GD") || major.matches("MC")) {
                    return major;
                } else {
                    System.out.println("Invalid!");
                }
            } else {
                System.out.println("Major can not is empty!");
            }
        }
    }

    public String inputEmail() {
        while (true) {
            System.out.print("Enter email: ");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (!email.isEmpty()) {
                if (email.contains("@fpt.edu.vn")) {
                    return email;
                } else {
                    System.out.println("@fpt.edu.vn");
                }
            } else {
                System.out.println("Email can not is empty!");
            }
        }
    }

    public String inputPhone() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter phone: ");
                String phone = sc.nextLine();
                if (!phone.matches("^0\\d{9}$")) {
                    throw new Exception("Phone is incorrect");
                } else {
                    return phone;
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public String inputPassport() {
        while (true) {
            System.out.print("Enter passport: ");
            Scanner sc = new Scanner(System.in);
            String passport = sc.nextLine();
            if (!passport.isEmpty()) {
                return passport;
            }

            System.out.println("Passport can not is empty!");
        }
    }

    public String inputAddress() {
        while (true) {
            System.out.print("Enter address: ");
            Scanner sc = new Scanner(System.in);
            String address = sc.nextLine();
            if (!address.isEmpty()) {
                return address;
            } else {
                System.out.println("Address can not is empty!");
            }
        }
    }

    public Students input(HashMap hashmap) {
        String id = inputId(hashmap);
        String name = inputName();
        String major = inputMajor();
        String email = inputEmail();
        String phone = inputPhone();
        String passport = inputPassport();
        String address = inputAddress();
        Students p = new Students(id, name, major, email, phone, passport, address);
        return p;
    }

}
