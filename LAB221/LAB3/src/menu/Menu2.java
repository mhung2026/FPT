/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.Scanner;

/**
 *
 * @author NGOMI
 */
public class Menu2 {

    public static void display() {
        System.out.println(" ____________________________________");
        System.out.println(" Manage students:");
        System.out.println("  1. Displays all students");
        System.out.println("  2. Add a new student");
        System.out.println("  3. Edit information a student by id");
        System.out.println("  _. Back to main menu");
        System.out.println(" ____________________________________");
        System.out.println("");
    }

    public static String choose() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return sc.nextLine();
    }

}
