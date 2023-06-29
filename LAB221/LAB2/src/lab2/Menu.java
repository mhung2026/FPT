/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Scanner;

/**
 *
 * @author NGOMI
 */
public class Menu {
    public static void display(){
        System.out.println(" __________ M E N U __________");
        System.out.println("|                             |");
        System.out.println("|  Manage flower              |");
        System.out.println("|  1. Add a flower            |");
        System.out.println("|  2. Find a flower           |");
        System.out.println("|  3. Update a flower         |");
        System.out.println("|  4. Delete a flower         |");
        System.out.println("|  5. Print flower            |");        
        System.out.println("|   ----------------------    |");
        System.out.println("|  Manage Order               |");
        System.out.println("|  6. Add an order            |");
        System.out.println("|  7. Display orders          |");
        System.out.println("|  8. Sort orders             |");
        System.out.println("|  9. Print orders            |");
        System.out.println("|   ----------------------    |");
        System.out.println("|  10. Save data              |");
        System.out.println("|  11. Load data              |");
        System.out.println("|  _. Others - Quit           |");
        System.out.println("|_____________________________|");
        System.out.println("");
        
    }
    public static String choose(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return sc.nextLine();
    }
}
