/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

public class InsertionSort {

    public InsertionSort() {
    }

    // Độ phức tạp Big-O: O(n^2)
    // Ưu điểm: Code nhanh, dễ hiểu
    // Nhược điểm: Độ phức tạp lớn
    public void InsertionSort(int arr[]) {
        {
            int i, j, x;
            for (i = 1; i < arr.length; i++) {
                x = arr[i];
                j = i;
                while (j > 0 && x < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    j--;
                };
                arr[j] = x;
            }
        }

        System.out.println("Insertion Sort:");
        System.out.print("Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "; ");
        }
        System.out.println("");
    }

}
