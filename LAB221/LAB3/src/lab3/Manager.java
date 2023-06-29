package lab3;

import java.util.Scanner;
import menu.Menu4;
import menu.Menu2;
import menu.Menu1;
import menu.Menu;

public class Manager {

    public static void main(String[] args) throws Exception {
        IC ic = new IC();
        ic.loadDataPrograms();
        ic.loadDataStudents();
        while (true) {
            Menu.display();
            String choice = Menu.choose();
            switch (choice) {
                case "1":
                    while (true) {
                        boolean bool = true;
                        Menu1.display();
                        String choice1 = Menu1.choose();
                        switch (choice1) {
                            case "1":
                                ic.displayPrograms();
                                break;
                            case "2":
                                ic.inputPrograms();
                                break;
                            case "3":
                                ic.editInformationPrograms();
                                break;
                            case "4":
                                ic.searchPrograms();
                                break;
                            default:
                                bool = false;
                                break;
                        }
                        if (!bool) {
                            break;
                        }
                    }
                    break;
                case "2":
                    while (true) {
                        boolean bool = true;
                        Menu2.display();
                        String choice2 = Menu2.choose();
                        switch (choice2) {
                            case "1":
                                ic.displayStudents();
                                break;
                            case "2":
                                ic.inputStudents();
                                System.out.println("");
                                break;
                            case "3":
                                ic.editInformationStudents();
                                System.out.println("");
                                break;
                            default:
                                bool = false;
                                break;
                        }
                        if (!bool) {
                            break;
                        }
                    }
                    break;
                case "3":
                    ic.inputRegister();
                    break;
                case "4":

                    while (true) {
                        boolean bool = true;
                        Menu4.display();
                        String choice4 = Menu4.choose();
                        switch (choice4) {
                            case "1":
                                ic.printOut();
                                break;
                            case "2":
                                ic.printOut2();
                                break;
                            case "3":
                                ic.count();
                                break;
                            default:
                                bool = false;
                                break;
                        }
                        if (!bool) {
                            break;
                        }
                    }
                    break;
                default:
                    while (true) {
                        System.out.println("Do you want save data (Y/N)?");
                        Scanner sc = new Scanner(System.in);
                        String s = sc.nextLine();
                        if (s.matches("Y")) {
                            ic.saveFilePrograms();
                            ic.saveFileStudents();
                            System.exit(0);
                        } else if (s.matches("N")) {
                            System.exit(0);
                        }
                    }

            }
        }
    }

}
