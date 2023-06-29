    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_ss1;

import java.util.Scanner;

/**
 *
 * @author NGOMI
 */
public class Hospital extends Menu {

    public static void main(String[] args) throws Exception {
        Patient patient = new Patient();
        while (true) {
            display();
            String choice = choose();
            switch (choice) {
                case "1":
                    patient.nurse.createNurses();
                    break;
                case "2":
                    patient.nurse.searchNurse();
                    break;
                case "3":
                    patient.nurse.updateNurse();
                    break;
                case "4":
                    patient.nurse.deleteNurse();
                    break;
                case "5":
                    patient.nurse.printNurse();
                    break;
                case "6":
                    patient.createPatients();
                    break;
                case "7":
                    patient.displayPatient();
                    break;
                case "8":
                    patient.SortPatient();
                    break;
                case "9":
                    patient.printPatient();
                    break;
                case "10":
                    System.out.println(patient.nurse.saveNurseToFile());
                    System.out.println(patient.savePatientToFile());
                    break;
                case "11":
                    System.out.println(patient.nurse.loadDataNurse());
                    System.out.println(patient.loadDataPatient());
                    break;
                case "12":
                    patient.printPatientwithDate();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
