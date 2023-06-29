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
public class Menu4 {

    public static void display() {
        System.out.println(" ____________________________________");
        System.out.println(" Report:");
        System.out.println("  1. Print out the registration by student’s id    ");
        System.out.println("  2. Print out the students that registered more than 2 programs       ");
        System.out.println("  3. Count students that registered the program");
        System.out.println("  _. Back to main menu                  ");
        System.out.println(" ____________________________________");
        System.out.println("");
    }

    public static String choose() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return sc.nextLine();
    }
}
