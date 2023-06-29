package lab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class IC {
    
    //E:\LAP211\RegistrationForm

    public HashMap<String, Programs> program = new HashMap<>();
    public HashMap<String, Students> student = new HashMap<>();

    // FUNTION 1 ///////////////////////////////////////////////////////////////
    
    public void displayPrograms() {
        System.out.println("");
        System.out.println("Display all programs");
        Set<String> keyset = program.keySet();
        for (String key : keyset) {
            System.out.println("Program have Id: " + key);
            System.out.println("Name: " + program.get(key).getName() + "| Time: " + program.get(key).getTime() + "| FromDate: " + program.get(key).getFromDate() + "| End Date: " + program.get(key).getEndDate() + "| Days: " + program.get(key).getDays() + "| Location: " + program.get(key).getLocation() + "| Cost: " + program.get(key).getCost() + "| Content: " + program.get(key).getContent());
            System.out.println("");
        }
        System.out.println("------------------------");
    }

    public void inputPrograms() {
        Programs p = new Programs();
        p = p.input(program);
        program.put(p.getID(), p);
    }

    public void editInformationPrograms() {
        String s;
        System.out.println("Enter the ID of programs you want to edit information: ");
        while (true) {
            boolean bool = false;
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
            Set<String> keyset = program.keySet();
            if (!s.isEmpty()) {
                for (String key : keyset) {
                    if (key.matches(s)) {
                        bool = true;
                        break;
                    }
                }
            }
            if (bool) {
                break;
            }
            System.out.println("Invalid");
        }
        Programs p = new Programs();
        program.get(s).setName(p.inputName());
        program.get(s).setTime(p.inputTime());
        program.get(s).setFromDate(p.inputFromDate());
        program.get(s).setEndDate(p.inputEndDate(program.get(s).getFromDate()));
        program.get(s).setDays(p.inputDays());
        program.get(s).setLocotion(p.inputLocation());
        program.get(s).setCost(p.inputCost());
        program.get(s).setContent(p.inputContent());

    }

    public void searchPrograms() {
        String s;

        System.out.println("Enter the ID of programs you want to edit information: ");
        while (true) {
            boolean bool = false;
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
            Set<String> keyset = program.keySet();
            if (!s.isEmpty()) {
                for (String key : keyset) {
                    if (key.matches(s)) {
                        System.out.println("Program have Id: " + key);
                        System.out.println("Name: " + program.get(key).getName() + "| Time: " + program.get(key).getTime() + "| FromDate: " + program.get(key).getFromDate() + "| End Date: " + program.get(key).getEndDate() + "| Days: " + program.get(key).getDays() + "| Location: " + program.get(key).getLocation() + "| Cost: " + program.get(key).getCost() + "| Content: " + program.get(key).getContent());
                        System.out.println("");

                        bool = true;
                        break;
                    }
                }
            }
            if (bool) {
                break;
            }
            System.out.println("Invalid");
        }
    }

    public void loadDataPrograms() throws FileNotFoundException {
        File f = new File("E:\\PRO192\\Session01-Hello\\LAB3\\src\\file\\Programs");
        if (!f.exists()) {
            System.out.println("Load Data unsuccessful!");
            return;
        } else {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                String line = null;
                while ((line = br.readLine()) != null) {
                    StringTokenizer stk = new StringTokenizer(line, "|");
                    String ID = stk.nextToken().trim();
                    String name = stk.nextToken().trim();
                    String time = stk.nextToken().trim();
                    String fromDate = stk.nextToken().trim();
                    String endDate = stk.nextToken().trim();
                    int days = Integer.parseInt(stk.nextToken().trim());
                    String location = stk.nextToken().trim();
                    int cost = Integer.parseInt(stk.nextToken().trim());
                    String content = stk.nextToken().trim();
                    Programs p = new Programs(ID, name, time, fromDate, endDate, days, location, cost, content);
                    this.program.put(p.getID(), p);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void saveFilePrograms() throws Exception {
        File f = new File("E:\\PRO192\\Session01-Hello\\LAB3\\src\\file\\Programs");
        if (program.isEmpty()) {
            System.out.println("Data is empty! Save file unsuccessful!");
            return;
        }
        PrintWriter pw = new PrintWriter(f);
        Set<String> keyset = program.keySet();
        for (String key : keyset) {
            pw.println(key + "|" + program.get(key).getName() + "|" + program.get(key).getTime() + "|" + program.get(key).getFromDate() + "|" + program.get(key).getEndDate() + "|" + program.get(key).getDays() + "|" + program.get(key).getLocation() + "|" + program.get(key).getCost() + "|" + program.get(key).getContent());
        }
        if (pw != null) {
            pw.close();
        }
    }

    // FUNTION 2 ///////////////////////////////////////////////////////////////
    
    public void displayStudents() {
        System.out.println("");
        System.out.println("Display all student:");
        System.out.println("");
        Set<String> keyset = student.keySet();
        for (String key : keyset) {
            System.out.println("Student have Id: " + key);
            System.out.println("Name: " + student.get(key).getName() + "| Major: " + student.get(key).getMajor() + "| Email: " + student.get(key).getEmail() + "| Phone: " + student.get(key).getPhone() + "| Passport: " + student.get(key).getPassport() + "| Address: " + student.get(key).getAddress());
            System.out.println("");
        }
        System.out.println("------------------------");
    }

    public void inputStudents() {
        Students p = new Students();
        p = p.input(student);
        student.put(p.getId(), p);
    }

    public void editInformationStudents() {
        String s;
        System.out.println("Enter the ID of programs you want to edit information: ");
        while (true) {
            boolean bool = false;
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
            Set<String> keyset = student.keySet();
            if (!s.isEmpty()) {
                for (String key : keyset) {
                    if (key.matches(s)) {
                        bool = true;
                        break;
                    }
                }
            }
            if (bool) {
                break;
            }
            System.out.println("Invalid");
        }
        Students p = new Students();
        student.get(s).setName(p.inputName());
        student.get(s).setMajor(p.inputMajor());
        student.get(s).setEmail(p.inputEmail());
        student.get(s).setPhone(p.inputPhone());
        student.get(s).setPassport(p.inputPassport());
        student.get(s).setAddress(p.inputAddress());

    }

    public void loadDataStudents() throws FileNotFoundException {
        File f = new File("E:\\PRO192\\Session01-Hello\\LAB3\\src\\file\\Students");
        if (!f.exists()) {
            System.out.println("Load Data unsuccessful!");
            return;
        } else {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                String line = null;
                while ((line = br.readLine()) != null) {
                    StringTokenizer stk = new StringTokenizer(line, "|");
                    String id = stk.nextToken().trim();
                    String name = stk.nextToken().trim();
                    String major = stk.nextToken().trim();
                    String email = stk.nextToken().trim();
                    String phone = stk.nextToken().trim();
                    String passport = stk.nextToken().trim();
                    String address = stk.nextToken().trim();
                    Students p = new Students(id, name, major, email, phone, passport, address);
                    this.student.put(p.getId(), p);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void saveFileStudents() throws FileNotFoundException {
        File f = new File("E:\\PRO192\\Session01-Hello\\LAB3\\src\\file\\Students");
        if (student.isEmpty()) {
            System.out.println("Data is empty! Save file unsuccessful!");
            return;
        }
        PrintWriter pw = new PrintWriter(f);
        Set<String> keyset = student.keySet();
        for (String key : keyset) {
            pw.println(key + "|" + student.get(key).getName() + "|" + student.get(key).getMajor() + "|" + student.get(key).getEmail() + "|" + student.get(key).getPhone() + "|" + student.get(key).getPassport() + "|" + student.get(key).getAddress());
        }
        if (pw != null) {
            pw.close();
        }
    }

    // FUNTION 3 ///////////////////////////////////////////////////////////////
    
    public void inputRegister() throws FileNotFoundException, IOException {
        Register re = new Register();
        String idProgram = re.inputIdProgram(program);
        String idStudent = re.inputIdStudent(student);
        String registerDate = re.inputRegistrationDate(program.get(idProgram).getFromDate(), program.get(idProgram).getEndDate());
        String emailParent = re.inputEmail();
        String phoneParent = re.inputPhone();
        re.saveFile(idProgram, idStudent, program.get(idProgram), student.get(idStudent), registerDate, emailParent, phoneParent);
    }
    
    // FUNTION 4 ///////////////////////////////////////////////////////////////
    
    public void printOut(){
        Report re = new Report();
        re.printOut(program, student);
    }
    
    public void printOut2(){
        Report re = new Report();
        re.printOut2(program, student);
    }    
    
    public void count(){
        Report re = new Report();
        re.count(program, student);
    }
}
