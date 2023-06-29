/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_ss1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author NGOMI
 */
public class Patient extends Person {

    public String patientId;
    public String diagnosis;
    public String admissionDate;
    public String dischargeDate;
    public String nurse1;
    public String nurse2;

    public Nurse nurse = new Nurse();
//    public HashMap<String, Patient> nursehashmap = new HashMap<>();

    public HashMap<String, Patient> hashmap = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    public DateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    public Patient() {

    }

    public Patient(String patientId, String diagnosis, String admissionDate, String dischargeDate, String nurse1, String nurse2) {
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.nurse1 = nurse1;
        this.nurse2 = nurse2;
    }

    public Patient(String patientId, String diagnosis, String admissionDate, String dischargeDate, String nurse1, String nurse2, String id, String name, int age, String gender, String address, String phone) {
        super(id, name, age, gender, address, phone);
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.nurse1 = nurse1;
        this.nurse2 = nurse2;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getNurse1() {
        return nurse1;
    }

    public void setNurse1(String nurse1) {
        this.nurse1 = nurse1;
    }

    public String getNurse2() {
        return nurse2;
    }

    public void setNurse2(String nurse2) {
        this.nurse2 = nurse2;
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

    @Override
    public String toString() {
        return "name=" + name + "| age=" + age + "| gender=" + gender + "| address=" + address + "| phone=" + phone + "| diagnosis=" + diagnosis + "| admissionDate=" + admissionDate + "| dischargeDate=" + dischargeDate + "| nurseAssigned1=" + nurse1 + "| nurseAssigned2=" + nurse2;
    }

    public String inputPatientId() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Id (Pxxx): ");
                String patientId = sc.nextLine();
                if (!patientId.matches("^P\\d{3}$")) {
                    throw new Exception("Id is incorrect");
                }
                Set<String> keyset = hashmap.keySet();
                for (String key : keyset) {
                    if (key.matches(patientId)) {
                        throw new Exception("The ID you entered already exists");
                    }
                }
                return patientId;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public String inputDiagonnis() {
        while (true) {
            System.out.print("Enter diagnosis: ");
            Scanner sc = new Scanner(System.in);
            diagnosis = sc.nextLine();
            if (!diagnosis.isEmpty()) {
                return diagnosis;
            }

            System.out.println("Diagnosis can not is empty!");
        }

    }

    public String inputAdmissionDate() {
        DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try {
                String a;
                System.out.print("Enter admissionDate: ");
                a = sc.nextLine();

                if (!a.isEmpty()) {
                    Date date = inputFormat.parse(a);
                    DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    admissionDate = outputFormat.format(date);
                    return admissionDate;
                } else {
                    throw new Exception("AdmissionDate can not is empty!");
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public String inputDischargeDate() {
        DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try {
                String a;
                System.out.print("Enter DischargeDate: ");
                a = sc.nextLine();

                if (!a.isEmpty()) {
                    Date date = inputFormat.parse(a);
                    DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    dischargeDate = outputFormat.format(date);
                    return dischargeDate;
                } else {
                    throw new Exception("DischargeDate can not is empty!");
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public void printPatient() {
        if (!hashmap.isEmpty()) {
            System.out.println("");
            System.out.println("_________LIST PATIENT_________:");
            System.out.println("");
            Set<String> keyset = hashmap.keySet();
            for (String key : keyset) {
                System.out.println("PatientID=" + key + ", " + hashmap.get(key));
            }
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("List Patient is empty!");
            System.out.println("");
        }
    }

    public int inputPatientNumber() {
        int patientNumber;
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("How many patient do you want to create?");
                patientNumber = sc.nextInt();
                return patientNumber;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public boolean searchNurse(String x) {
        Set<String> keyset = nurse.hashmap.keySet();
        for (String key : keyset) {
            if (key.matches(x)) {
                return (nurse.hashmap.get(key).patient1 == null || nurse.hashmap.get(key).patient2 == null) || (nurse.hashmap.get(key).patient1.matches("null") || nurse.hashmap.get(key).patient2.matches("null"));
            }
        }
        return false;
    }

    public void PrintListNurseValid() {
        Set<String> keyset = nurse.hashmap.keySet();
        System.out.println("");
        System.out.println("------------LIST NURSE VALID-------------");
        System.out.println("");

        for (String key : keyset) {
            if ((nurse.hashmap.get(key).getPatient1() == null || nurse.hashmap.get(key).getPatient2() == null) || (nurse.hashmap.get(key).getPatient1().matches("null") || nurse.hashmap.get(key).getPatient2().matches("null"))) {
                System.out.println("NurseID=" + key);
            };
        }
        System.out.println("");
    }

    public void update_Patient_for_Nurse(String n, String id) {
        try {
            Set<String> keyset = nurse.hashmap.keySet();
            for (String key : keyset) {
                if (key.matches(n)) {
                    if (nurse.hashmap.get(key).patient1 == null || nurse.hashmap.get(key).patient1.matches("null")) {
                        nurse.hashmap.get(key).setPatient1(id);
                    } else {
                        nurse.hashmap.get(key).setPatient2(id);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public String inputNurse(String x) {
        while (true) {
            try {
                PrintListNurseValid();//
                String nurseX;
                Scanner sc = new Scanner(System.in);
                nurseX = sc.nextLine();
                if (searchNurse(nurseX)) {
                    System.out.println("");
                    System.out.println("add Nurse successful!");
                    System.out.println("");

                    update_Patient_for_Nurse(nurseX, x);
                    return nurseX;

                } else {
                    System.out.println("Invalid");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void createPatient() {
        Person pe = new Person();
        this.patientId = inputPatientId();
        this.id = this.patientId;
        this.name = pe.inputName();
        this.age = pe.inputAge();
        this.gender = pe.inputGender();
        this.address = pe.inputAddress();
        this.phone = pe.inputPhone();
        this.diagnosis = inputDiagonnis();
        this.admissionDate = inputAdmissionDate();
        this.dischargeDate = inputDischargeDate();
        System.out.println("Enter StaffID of nurse 1: ");
        this.nurse1 = inputNurse(this.patientId);
        System.out.println("Enter StaffID of nurse 1: ");

        this.nurse2 = inputNurse(this.patientId);

        Patient patient = new Patient(patientId, diagnosis, admissionDate, dischargeDate, nurse1, nurse2, id, name, age, gender, address, phone);
        hashmap.put(patientId, patient);
    }

    public void createPatients() throws java.lang.Exception {

        int patientNumber = inputPatientNumber();
        int i = 0, n = patientNumber;

        while (patientNumber != 0) {
            System.out.println("-----------");
            System.out.println("Input Patient " + i++ + " : ");
            patientNumber--;
            createPatient();
        }
        savePatientToFile();
        System.out.println("");
        System.out.println("Created " + n + " more patients.");
        System.out.println("");
    }

    public void displayPatient() {
        String std, ed;
        Scanner sc = new Scanner(System.in);
        ArrayList<Patient> arr = new ArrayList<>(hashmap.values());
        while (true) {
            DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                String a;
                System.out.println("Enter start admissionDate: ");
                a = sc.nextLine();
                if (!a.isEmpty()) {
                    Date date = inputFormat.parse(a);
                    DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar c = Calendar.getInstance();
                    c.setTime(date);
                    c.add(Calendar.DATE, -1);
                    date = c.getTime();
                    std = outputFormat.format(date);
                    //  System.out.println("STD:" +std);
                    break;
                }
                throw new Exception("Invalid");
            } catch (Exception e) {
                System.out.println("");
                System.out.println("Invalid format!");
                System.out.println("");
            }
        }
        while (true) {
            DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                String a;
                System.out.println("Enter end admissionDate: ");
                a = sc.nextLine();
                if (!a.isEmpty()) {

                    Date date = inputFormat.parse(a);

                    DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar c = Calendar.getInstance();
                    c.setTime(date);
                    c.add(Calendar.DATE, 1);
                    date = c.getTime();
                    ed = outputFormat.format(date);
                    // System.out.println("ED" + ed);
                    break;
                }
                throw new Exception("Invalid");
            } catch (Exception e) {
                System.out.println("");
                System.out.println("Invalid format!");
                System.out.println("");
            }
        }
        LocalDate startDate = LocalDate.parse(std);
        LocalDate endDate = LocalDate.parse(ed);

        // Lọc danh sách bệnh nhân trong khoảng thời gian
        List<Patient> filteredPatients = new ArrayList<>();
        for (Patient p : arr) {
            LocalDate admissionDate = LocalDate.parse(p.getAdmissionDate());
            if (admissionDate.isAfter(startDate) && admissionDate.isBefore(endDate)) {
                filteredPatients.add(p);

            }
        }
        System.out.println("");
        System.out.println("-----------LIST OF PATIENTS-----------");
        System.out.println("Start date:" + std);
        System.out.println("End date:" + ed);
        System.out.println("");
        for (Patient p : filteredPatients) {
            System.out.println(p);
            //System.out.println("IDPatient=" + p.getId() + ", AdmissionDate=" + p.getAdmissionDate() + ", Fullname=" + p.getName() + ", Phone=" + p.getPhone() + ", Diagnosis=" + p.getDiagnosis());

        }
        System.out.println("");
    }
    public void printPatientwithDate() {
        String std;
        Scanner sc = new Scanner(System.in);
        ArrayList<Patient> arr = new ArrayList<>(hashmap.values());
        while (true) {
            DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                String a;
                System.out.println("Enter start admissionDate: ");
                a = sc.nextLine();
                if (!a.isEmpty()) {
                    Date date = inputFormat.parse(a);
                    DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
//                 
                    std = outputFormat.format(date);
//                   System.out.println("STD:" +std);
                    break;
                }
                throw new Exception("Invalid");
            } catch (Exception e) {
                System.out.println("");
                System.out.println("Invalid format!");
                System.out.println("");
            }
        }
        LocalDate startDate = LocalDate.parse(std);
        // Lọc danh sách bệnh nhân trong khoảng thời gian
        List<Patient> filteredPatients = new ArrayList<>();
        for (Patient p : arr) {
            LocalDate admissionDate = LocalDate.parse(p.getAdmissionDate());
            if (!admissionDate.equals(startDate)) {
                filteredPatients.add(p);
                System.out.println(p);
            }
        }
        System.out.println("");
        System.out.println("-----------LIST OF PATIENTS-----------");
        System.out.println("Start date:" + std);
        System.out.println("");
        for (Patient p : filteredPatients) {
            
           // if( p.admissionDate.matches(std))
//            System.out.println(p);
            System.out.println("IDPatient=" + p.getId() + ", AdmissionDate=" + p.getAdmissionDate() + ", Fullname=" + p.getName() + ", Phone=" + p.getPhone() + ", Diagnosis=" + p.getDiagnosis());

        }
        System.out.println("");
    }
    

    public void SortPatient() {
        String sb, so;
        ArrayList<Patient> arr = new ArrayList<>(hashmap.values());
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Sorted by(Name/Id): ");
            sb = sc.nextLine();
            if (sb.matches("Name") || sb.matches("Id")) {
                break;
            }
            System.out.println("Invalid");
        }
        while (true) {
            System.out.println("Sort order(ASC/DESC): ");
            so = sc.nextLine();
            if (so.matches("ASC") || so.matches("DESC")) {
                break;
            }
            System.out.println("Invalid");
        }

        if (sb.matches("Name")) {
            if (so.matches("ASC")) {
                Collections.sort(arr, (Patient p1, Patient p2) -> p1.getName().compareTo(p2.getName()));
                System.out.println("Sort names ASC: ");
                for (Patient entry : arr) {
                    System.out.println("PatientID" + entry.id + "| name=" + entry.name + "| age=" + entry.age + "| gender=" + entry.gender + "| address=" + entry.address + "| phone=" + entry.phone + "| diagnosis=" + entry.diagnosis + "| admissionDate=" + entry.admissionDate + "| dischargeDate=" + entry.dischargeDate + "| nurseAssigned1=" + entry.nurse1 + "| nurseAssigned2=" + entry.nurse2);
                }
            } else {
                Collections.sort(arr, (Patient p1, Patient p2) -> p2.getName().compareTo(p1.getName()));

                System.out.println("Sort names DESC: ");
                for (Patient entry : arr) {
                    System.out.println("PatientID" + entry.id + "| name=" + entry.name + "| age=" + entry.age + "| gender=" + entry.gender + "| address=" + entry.address + "| phone=" + entry.phone + "| diagnosis=" + entry.diagnosis + "| admissionDate=" + entry.admissionDate + "| dischargeDate=" + entry.dischargeDate + "| nurseAssigned1=" + entry.nurse1 + "| nurseAssigned2=" + entry.nurse2);
                }
            }
        } else {
            if (so.matches("ASC")) {
                Collections.sort(arr, (Patient p1, Patient p2) -> p1.getId().compareTo(p2.getId()));
                System.out.println("Sort ids ASC: ");
                for (Patient entry : arr) {
                    System.out.println("PatientID" + entry.id + "| name=" + entry.name + "| age=" + entry.age + "| gender=" + entry.gender + "| address=" + entry.address + "| phone=" + entry.phone + "| diagnosis=" + entry.diagnosis + "| admissionDate=" + entry.admissionDate + "| dischargeDate=" + entry.dischargeDate + "| nurseAssigned1=" + entry.nurse1 + "| nurseAssigned2=" + entry.nurse2);
                }
            } else {
                Collections.sort(arr, (Patient p1, Patient p2) -> p2.getId().compareTo(p1.getId()));
                System.out.println("Sort ids DESC: ");
                for (Patient entry : arr) {
                    System.out.println("PatientID=" + entry.id + "| name=" + entry.name + "| age=" + entry.age + "| gender=" + entry.gender + "| address=" + entry.address + "| phone=" + entry.phone + "| diagnosis=" + entry.diagnosis + "| admissionDate=" + entry.admissionDate + "| dischargeDate=" + entry.dischargeDate + "| nurseAssigned1=" + entry.nurse1 + "| nurseAssigned2=" + entry.nurse2);
                }
            }
        }
    }

    public String loadDataPatient() throws FileNotFoundException {
        File f = new File("E:\\PRO192\\Session01-Hello\\LAB1_SS1\\src\\File\\Patient");

        if (!f.exists()) {
            System.out.println("");
            return "Load Data Patient unsuccessful!";
        } else {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                String line = null;
                while ((line = br.readLine()) != null) {
                    StringTokenizer stk = new StringTokenizer(line, "|");
                    patientId = stk.nextToken().trim();
                    id = patientId;
                    name = stk.nextToken().trim();
                    age = Integer.parseInt(stk.nextToken().trim());
                    gender = stk.nextToken().trim();
                    address = stk.nextToken().trim();
                    phone = stk.nextToken().trim();
                    diagnosis = stk.nextToken().trim();
                    admissionDate = stk.nextToken().trim();
                    dischargeDate = (stk.nextToken().trim());
                    nurse1 = stk.nextToken().trim();
                    if (!nurse1.equals("null")) {
                        nurse1 = null;
                    }
                    nurse2 = stk.nextToken().trim();
                    if (!nurse2.equals("null")) {
                        nurse2 = null;
                    }
                    Patient p = new Patient(patientId, diagnosis, admissionDate, dischargeDate, nurse1, nurse2, id, name, age, gender, address, phone);
                    hashmap.put(patientId, p);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("");
        return "Load Data Patient Successful!";
    }

    public String savePatientToFile() throws Exception {
        File f = new File("E:\\PRO192\\Session01-Hello\\LAB1_SS1\\src\\File\\Patient");
        if (hashmap.isEmpty()) {
            return "ListNurse is empty! Save list Nurse to file unsuccessful!";
        }
        PrintWriter pw = new PrintWriter(f);
        Set<String> keyset = hashmap.keySet();
        for (String key : keyset) {
            pw.println(key + "|" + hashmap.get(key).getName() + "|" + hashmap.get(key).getAge() + "|" + hashmap.get(key).getGender() + "|" + hashmap.get(key).getAddress() + "|" + hashmap.get(key).getPhone() + "|" + hashmap.get(key).getDiagnosis() + "|" + hashmap.get(key).getAdmissionDate() + "|" + hashmap.get(key).getDischargeDate() + "|" + hashmap.get(key).getNurse1() + "|" + hashmap.get(key).getNurse2());
        }
        if (pw != null) {
            pw.close();
        }
        return "Save list Nurse to file successful!";
    }

}
