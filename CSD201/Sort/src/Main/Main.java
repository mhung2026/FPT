/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Menu.Menu;
import java.util.Scanner;
import sort.BubbleSort;
import sort.HeapSort;
import sort.InsertionSort;
import sort.QuickSort;
import sort.SelectionSort;
import sort.MergeSort;
import sort.RaidxSort;

/**
 *
 * @author NGOMI
 */
public class Main {

    public static void main(String[] args) {

        while (true) {
            int[] arr = {7, 3, 5, 9, 11, 8, 6, 15, 10, 12, 14};
            Menu.display();
            String choice = Menu.choose();
            switch (choice) {
                case "1":
                    SelectionSort se = new SelectionSort();
                    se.selectionSort(arr);
                    break;
                case "2":
                    InsertionSort in = new InsertionSort();
                    in.InsertionSort(arr);
                    break;
                case "3":
                    BubbleSort bu = new BubbleSort();
                    bu.bubbleSort(arr);
                    break;
                case "4":
                    QuickSort qu = new QuickSort();
                    qu.quickSort(arr, 0, arr.length - 1);
                    System.out.println("Quick Sort:");
                    System.out.print("Array: ");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i] + "; ");
                    }
                    System.out.println("");
                    break;
                case "5":
                    MergeSort me = new MergeSort();
                    me.mergeSort(arr, 0, arr.length - 1);
                    System.out.println("Merge Sort:");
                    System.out.print("Array: ");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i] + "; ");
                    }
                    System.out.println("");
                    break;
                case "6":
                    HeapSort he = new HeapSort();
                    he.HeapSort(arr);
                    System.out.println("Heap Sort:");
                    System.out.print("Array: ");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i] + "; ");
                    }
                    System.out.println("");
                    break;
                case "7":
                    RaidxSort ra = new RaidxSort();
                    ra.radixSort(arr, arr.length);
                    System.out.println("Raidx Sort:");
                    System.out.print("Array: ");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i] + "; ");
                    }
                    System.out.println("");
                    break;
                default:

                    System.exit(0);

            }

        }
    }

}
