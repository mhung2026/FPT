/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author NGOMI
 */
public class Report {

    public String inputIdStudent(HashMap hashmap) {
        System.out.print("Enter id of Student: ");
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
                System.out.println("Don't have id!");

            } else {
                System.out.println("Is Empty!");
            }

        }
    }

    public String inputIdProgram(HashMap hashmap) {
        System.out.print("Enter id of Program: ");
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
                System.out.println("Don't have id!");
            } else {
                System.out.println("Is Empty!");
            }

        }
    }

    public void printOut(HashMap pro, HashMap stu) {

        String idStudent = inputIdStudent(stu);
        boolean bool = false;
        Set<String> keyset = pro.keySet();
        for (String key : keyset) {
            String nameFileTxt = "E:\\LAP211\\RegistrationForm\\" + idStudent.trim() + "_" + key.trim() + ".txt";
            String nameFileDoc = "E:\\LAP211\\RegistrationForm\\" + idStudent.trim() + "_" + key.trim() + ".doc";
            File fileTxt = new File(nameFileTxt);
            File fileDoc = new File(nameFileDoc);
            if (fileTxt.exists()) {
                bool = true;
                try {
                    Scanner sc = new Scanner(fileTxt);
                    String content = "";
//                    System.out.println("------------------");
                    while (sc.hasNextLine()) {
                        content += sc.nextLine() + "\r\n";
                    }
                    System.out.println(content);

                    System.out.println("------------------");
                    sc.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Error");
                }
            }
            if (fileDoc.exists()) {
                bool = true;
                try {
                    Scanner sc = new Scanner(fileDoc);
                    String content = "";
//                    System.out.println("------------------");
                    while (sc.hasNextLine()) {
                        content += sc.nextLine() + "\r\n";
                    }
                    System.out.println(content);

                    System.out.println("------------------");
                    sc.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Error");
                }
            }
        }
        if (!bool) {
            System.out.println("Don't have!");
        }
    }

    public void printOut2(HashMap pro, HashMap<String, Students> stu) {
//        String idProgram = inputIdStudent(stu);

        Set<String> idPro = pro.keySet();
        Set<String> idStu = stu.keySet();
        boolean bool = false;
        for (String keyStu : idStu) {
            int sum = 0;
            for (String keyPro : idPro) {
                String nameFileTxt = "E:\\LAP211\\RegistrationForm\\" + keyStu.trim() + "_" + keyPro.trim() + ".txt";
                String nameFileDoc = "E:\\LAP211\\RegistrationForm\\" + keyStu.trim() + "_" + keyPro.trim() + ".doc";

                File fileTxt = new File(nameFileTxt);
                if (fileTxt.exists()) {
                    sum++;
                    if (sum >= 2) {
                        System.out.println("Program have Id: " + keyStu);
                        System.out.println("Name: " + stu.get(keyStu).getName() + "| Major: " + stu.get(keyStu).getMajor() + "| Email: " + stu.get(keyStu).getEmail() + "| Phone: " + stu.get(keyStu).getPhone() + "| Passport: " + stu.get(keyStu).getPassport() + "| Address: " + stu.get(keyStu).getAddress());
                        System.out.println("");
                        break;
                    }

                }
                File fileDoc = new File(nameFileDoc);
                if (fileDoc.exists()) {
                    sum++;
                    if (sum >= 2) {
                        System.out.println("Program have Id: " + keyStu);
                        System.out.println("Name: " + stu.get(keyStu).getName() + "| Major: " + stu.get(keyStu).getMajor() + "| Email: " + stu.get(keyStu).getEmail() + "| Phone: " + stu.get(keyStu).getPhone() + "| Passport: " + stu.get(keyStu).getPassport() + "| Address: " + stu.get(keyStu).getAddress());
                        System.out.println("");
                        break;
                    }

                }
            }
        }
        if (bool) {
            System.out.println("Don't have!");
        }

    }

    public void count(HashMap pro, HashMap stu) {
        String idProgram = inputIdProgram(pro);

        Set<String> idStu = stu.keySet();
        int sum = 0;
        for (String keyStu : idStu) {
            String nameFileTxt = "E:\\LAP211\\RegistrationForm\\" + keyStu.trim() + "_" + idProgram + ".txt";
            String nameFileDoc = "E:\\LAP211\\RegistrationForm\\" + keyStu.trim() + "_" + idProgram + ".txt";

            File fileTxt = new File(nameFileTxt);
            if (fileTxt.exists()) {
                sum++;
            }
            File fileDoc = new File(nameFileDoc);
            if (fileDoc.exists()) {
                sum++;
            }
        }
        System.out.println("Count students that registered the program: " + sum);
        System.out.println("");
    }

}
