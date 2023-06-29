package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Register {

    public Register() {
    }

    public String inputIdProgram(HashMap hashmap) {
        System.out.println("Enter id of Program: ");
        while (true) {
            Scanner sc = new Scanner(System.in);
            String idProgram = sc.nextLine();
            Set<String> keyset = hashmap.keySet();
            if (!idProgram.isEmpty()) {
                for (String key : keyset) {
                    if (key.matches(idProgram)) {
                        return idProgram;
                    }
                }
                System.out.println("Invalid!");
            } else {
                System.out.println("Is empty!");
            }

        }
    }

    public String inputIdStudent(HashMap hashmap) {
        System.out.println("Enter id of Student: ");
        while (true) {
            Scanner sc = new Scanner(System.in);
            String idStudent = sc.nextLine();
            Set<String> keyset = hashmap.keySet();
            if (!idStudent.isEmpty()) {
                for (String key : keyset) {
                    if (key.matches(idStudent)) {
                        return idStudent;
                    }
                }
                System.out.println("Invalid!");
            } else {
                System.out.println("Is empty!");
            }

        }
    }

    public String inputRegistrationDate(String std, String end) {

        DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try {
                String a;
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter Registration Date: ");
                a = sc.nextLine();

                if (!a.isEmpty()) {
                    Date date = inputFormat.parse(a);
                    DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String reDate = outputFormat.format(date);

                    LocalDate st = LocalDate.parse(std);
                    LocalDate en = LocalDate.parse(end);
                    LocalDate mi = LocalDate.parse(reDate);
                    if ((st.isBefore(mi) || st.isEqual(mi)) && (en.isAfter(mi) || en.isEqual(mi))) {
                        return reDate;
                    } else {
                        System.out.println(std + " <= Date <= " + end);
                    }
                } else {
                    throw new Exception("Registration Date can not is empty!");
                }
            } catch (Exception ex) {
                System.out.println("Invalid");
            }
        }
    }

    public String inputEmail() {
        while (true) {
            System.out.print("Enter email: ");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (!email.isEmpty()) {
                if (email.contains("@gmail.com")) {
                    return email;
                } else {
                    System.out.println("@gmail.com");
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

    public void saveFile(String idProgram, String idStudent, Programs pro, Students stu, String date, String email, String phone) throws FileNotFoundException, IOException {
        String formatFile;
        while (true) {
            System.out.println("What format do you save the file in(doc/txt)?");
            Scanner sc = new Scanner(System.in);
            formatFile = sc.nextLine();
            if (formatFile.matches("doc")) {
                break;
            } else if (formatFile.matches("txt")) {
                break;
            }
            System.out.println("Invalid");
        }
        String namefile = "E:\\LAP211\\RegistrationForm\\" + idStudent.trim() + "_" + idProgram.trim() + "." + formatFile.trim();
        File file = new File(namefile);
        file.createNewFile();
        PrintWriter pw = new PrintWriter(file);
        pw.println("Aboard Program Registration Form:");
        pw.println();
        pw.println("Information Student:");
        pw.println("Student id: " + idStudent + "   Student Name: " + stu.getName());
        pw.println("Major: " + stu.getMajor() + "   Email: " + stu.getEmail() + "   Phone: " + stu.getPhone() + "   Passport: " + stu.getPassport());
        pw.println("Address: " + stu.getAddress() + "   Email of the parent: " + email + "  Phone of the parent: " + phone);
        pw.println();
        pw.println("Information of the aboard program:");
        pw.println();
        pw.println("Program’s id: " + pro.getID() + "   Program’s name: " + pro.getName());
        pw.println("Time: " + pro.getTime() + "     Days: " + pro.getDays() + "   Localtion: " + pro.getLocation() + "    Cost: " + pro.getCost() + "$");

        pw.println();
        pw.println("Information of the registration: ");
        pw.println();
        pw.println("registration date:" + date);

        if (pw != null) {
            pw.close();
        }

    }

}
