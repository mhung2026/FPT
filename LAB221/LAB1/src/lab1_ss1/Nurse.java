/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_ss1;

/**
 *
 * @author NGOMI
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Nurse extends Person {

    public String staffID;
    public String department;
    public String shift;
    public double salary;
    public String patient1;
    public String patient2;
    public HashMap<String, Nurse> hashmap = new HashMap<>();

    public Nurse() {

    }

    public Nurse(String staffID, String department, String shift, double salary, String patient1, String patient2) {
        this.staffID = staffID;
        this.department = department;
        this.shift = shift;
        this.salary = salary;
        this.patient1 = patient1;
        this.patient2 = patient2;
    }

    public Nurse(String staffID, String department, String shift, double salary, String patient1, String patient2, String id, String name, int age, String gender, String address, String phone) {
        super(id, name, age, gender, address, phone);
        this.staffID = staffID;
        this.department = department;
        this.shift = shift;
        this.salary = salary;
        this.patient1 = patient1;
        this.patient2 = patient2;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPatient1() {
        return patient1;
    }

    public void setPatient1(String patient1) {
        this.patient1 = patient1;
    }

    public String getPatient2() {
        return patient2;
    }

    public void setPatient2(String patient2) {
        this.patient2 = patient2;
    }

    public static Scanner getSc() {
        return sc;
    }

    public static void setSc(Scanner sc) {
        Nurse.sc = sc;
    }

    @Override
    public String toString() {
        return "Name: " + name + "| Age: " + age + "| Gender: " + gender + "| Address: " + address + "| Phone: " + phone + "| Department: " + department + "| Shift: " + shift + "| Salary: " + salary + "| Patient 01: " + patient1 + "| Patient 02:" + patient2;
    }

    private static Scanner sc = new Scanner(System.in);

    private Exception Exception() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String inputStaffId() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Id (Nxxx): ");
                String staffId = sc.nextLine();
                if (!staffId.matches("^N\\d{3}$")) {
                    throw new Exception("Id is incorrect");
                }
                Set<String> keyset = hashmap.keySet();
                for (String key : keyset) {
                    if (key.matches(staffId)) {
                        throw new Exception("The ID you entered already exists");
                    }
                }
                return staffId;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public void printNurse() {
        if (!hashmap.isEmpty()) {
            System.out.println("");
            System.out.println("_________LIST NURSE_________:");
            System.out.println("");
            Set<String> keyset = hashmap.keySet();
            for (String key : keyset) {
                System.out.println("StaffID=" + key + "| " + hashmap.get(key));
            }
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("List Nurse is empty!");
            System.out.println("");
        }
    }

    public int inputNurseNumber() {
        int nurseNumber;
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("How many nurses do you want to create?");
                nurseNumber = sc.nextInt();
                return nurseNumber;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public String inputDeparment() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Department: ");
                String department = sc.nextLine();
                if (department.length() < 3 || department.length() > 50) {
                    throw new Exception("Length from 3 to 50 characters");
                }
                return department;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public String inputShift() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Shift: ");
                String shift = sc.nextLine();
                if (shift.length() <= 0) {
                    throw new Exception("Invalid shift");
                }
                return shift;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public int inputSalary() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Salary: ");
                int salary = sc.nextInt();
                if (salary <= 0) {
                    throw new Exception("Invalid salary");
                }
                return salary;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public String inputPatient() {
        return "idPatient";

    }

    public void createNurse() {
        Person pe = new Person();
        this.staffID = inputStaffId();
        this.id = this.staffID;
        pe.input();
        this.department = inputDeparment();
        this.shift = inputShift();
        this.salary = inputSalary();
        this.patient1 = inputPatient();
        this.patient2 = inputPatient();

        Nurse nurse = new Nurse(staffID, department, shift, salary, patient1, patient2, id, name, age, gender, address, phone);
        hashmap.put(staffID, nurse);
    }

    public void createNurses() throws java.lang.Exception {

        int nurseNumber = inputNurseNumber();
        int i = 0, n = nurseNumber;

        while (nurseNumber != 0) {
            System.out.println("-----------");
            System.out.println("Input Nurse " + i++ + " : ");
            nurseNumber--;
            createNurse();
        }
        saveNurseToFile();
        System.out.println("");
        System.out.println("Created " + n + " more nurses.");
        System.out.println("");
    }

    public void searchNurse() {
        String s;
        boolean b = false;
        System.out.println("Enter name of Nurse: ");
        while (true) {
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
            if (!s.isEmpty()) {
                break;
            } else {
                System.out.println("Invalid");
            }
        }
        Set<String> keyset = hashmap.keySet();
        for (String key : keyset) {
            if (s.matches(hashmap.get(key).name)) {
                System.out.println("StaffID=" + key + "| " + hashmap.get(key));
                b = true;
            }
        }
        if (!b) {
            System.out.println("There is no nurse named " + s + " in the list");
        }
    }

    public void updateNurse() {
        printNurse();
        Set<String> keyset = hashmap.keySet();
        String s;
        boolean b = false;
        System.out.println("Enter the ID of the nurse you want to update: ");
        while (true) {
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
            if (!s.isEmpty()) {
                for (String key : keyset) {
                    if (key.matches(s)) {
                        b = true;
                        break;
                    }
                }
            }
            if (b = true) {
                break;
            }
            System.out.println("Invalid");
        }
        Person pe = new Person();
        hashmap.get(s).id = s;
        hashmap.get(s).name = inputName();
        hashmap.get(s).age = inputAge();
        hashmap.get(s).gender = inputGender();
        hashmap.get(s).address = inputAddress();
        hashmap.get(s).phone = inputPhone();
        hashmap.get(s).department = inputDeparment();
        hashmap.get(s).shift = inputShift();
        hashmap.get(s).salary = inputSalary();
        while (true) {
            System.out.println("Do you want to update other nurses (Y/N)?");
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
            if (s.equals("Y")) {
                updateNurse();
            } else if (s.equals("N")) {
                return;
            } else {
                System.out.println("Invalid");
            }
        }
    }

    public void deleteNurse() {
        boolean b = false;
        System.out.println("");
        System.out.println("------------LIST NURSE CAN DELETE-------------: :");
        System.out.println("");
        Set<String> keyset = hashmap.keySet();
        for (String key : keyset) {
            if (hashmap.get(key).patient1 == null && hashmap.get(key).patient2 == null) {
                System.out.println("StaffID=" + key + "| " + hashmap.get(key));
                b = true;
            }
        }
        if (!b) {
            System.out.println("No nurse can delete");
            return;
        }
        String s;
        b = false;
        System.out.println("Enter the ID of the nurse you want to delete: ");
        while (true) {
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
            if (!s.isEmpty()) {
                for (String key : keyset) {
                    if (key.matches(s)) {
                        b = true;
                        break;
                    }
                }
            }
            if (b) {
                if (hashmap.get(s).patient1 == null && hashmap.get(s).patient2 == null) {
                    break;
                } else {
                    System.out.println("This nurse you can't delete");
                    b = false;
                }

            };
            System.out.println("Invalid");

        }
        hashmap.remove(s);
        System.out.println("Successful!");

    }

    public String loadDataNurse() throws FileNotFoundException {
        File f = new File("E:\\PRO192\\Session01-Hello\\LAB1_SS1\\src\\File\\Nurse");
        if (!f.exists()) {
            System.out.println("");
            return "Load Data Nurse unsuccessful!";
        } else {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                String line = null;
                while ((line = br.readLine()) != null) {
                    StringTokenizer stk = new StringTokenizer(line, "|");
                    staffID = stk.nextToken().trim();
                    id = staffID;
                    name = stk.nextToken().trim();
                    age = Integer.parseInt(stk.nextToken().trim());
                    gender = stk.nextToken().trim();
                    address = stk.nextToken().trim();
                    phone = stk.nextToken().trim();
                    department = stk.nextToken().trim();
                    shift = stk.nextToken().trim();
                    salary = Double.parseDouble(stk.nextToken().trim());
                    patient1 = stk.nextToken().trim();
                    if (patient1.equals("null")) {
                        patient1 = null;
                    }
                    patient2 = stk.nextToken().trim();
                    if (patient2.equals("null")) {
                        patient2 = null;
                    }
                    Nurse n = new Nurse(staffID, department, shift, salary, patient1, patient2, id, name, age, gender, address, phone);
                    hashmap.put(staffID, n);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("");
        return "Load Data Nurse Successful!";
    }

    public String saveNurseToFile() throws Exception {
        File f = new File("E:\\PRO192\\Session01-Hello\\LAB1_SS1\\src\\File\\Nurse");
        if (hashmap.isEmpty()) {
            return "ListNurse is empty! Save list Nurse to file unsuccessful!";
        }
        PrintWriter pw = new PrintWriter(f);
        Set<String> keyset = hashmap.keySet();
        for (String key : keyset) {
            pw.println(key + "|" + hashmap.get(key).getName() + "|" + hashmap.get(key).getAge() + "|" + hashmap.get(key).getGender() + "|" + hashmap.get(key).getAddress() + "|" + hashmap.get(key).getPhone() + "|" + hashmap.get(key).getDepartment() + "|" + hashmap.get(key).getShift() + "|" + hashmap.get(key).getSalary() + "|" + hashmap.get(key).getPatient1() + "|" + hashmap.get(key).getPatient2());
        }
        if (pw != null) {
            pw.close();
        }
        return "Save list Nurse to file successful!";
    }
}
