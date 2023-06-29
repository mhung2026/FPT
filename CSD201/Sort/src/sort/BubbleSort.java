/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;


public class BubbleSort {

    public BubbleSort() {
    }

    // Độ phức tạp Big-O: O(n^2)
    // Ưu điểm: Code nhanh, dễ hiểu
    // Nhược điểm: Độ phức tạp lớn
    
    public void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;                                    // Vị trí nhỏ nhất hiện tại là i
            for (int j = i + 1; j < arr.length; j++) {      // Duyệt tìm kiếm vị trí giá trị nhỏ nhất từ đoạn [i+1,n] và gán vào min
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int swapTemp = arr[i];                          // Swap vị trí i và vị trí có giá trị nhỏ nhất trong đoạn [i,n]
            arr[i] = arr[min];
            arr[min] = swapTemp;
        }
        System.out.println("Bubble Sort: ");
        System.out.print("Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "; ");
        }
        System.out.println("");
    }

}
