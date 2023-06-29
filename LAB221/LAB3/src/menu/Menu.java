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
public class Menu {
    public static void display(){
        System.out.println(" ______________ M E N U ______________");
        System.out.println("|                                     |");
        System.out.println("|  1. Manage aboard programs          |");
        System.out.println("|  2. Manage students                 |");
        System.out.println("|  3. Register a program for a student|");
        System.out.println("|  4. Report                          |");
        System.out.println("|  _. Others - Quit                   |");
        System.out.println("|_____________________________________|");
        System.out.println("");    
    }
    public static String choose(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return sc.nextLine();
    }
}
