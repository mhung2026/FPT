/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.util.Scanner;

/**
 *
 * @author NGOMI
 */
public class Menu {

    public static void display() {
        System.out.println(" ______________ M E N U ______________");
        System.out.println("|                                     |");
        System.out.println("|  1. Selection Sort                  |");
        System.out.println("|  2. Insertion Sort                  |");
        System.out.println("|  3. Bubble Sort                     |");
        System.out.println("|  4. Quick Sort                      |");
        System.out.println("|  5. Merge Sort                      |");
        System.out.println("|  6. Heap Sort                       |");
        System.out.println("|  7. Raidx Sort                      |");
        System.out.println("|  _. Others - Quit                   |");
        System.out.println("|_____________________________________|");
        System.out.println("");
    }

    public static String choose() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return sc.nextLine();
    }
}
