package sort;

public class SelectionSort {

    public SelectionSort() {
    }
    
    // Độ phức tạp Big-O: O(n^2)
    // Ưu điểm: Code nhanh, dễ hiểu
    // Nhược điểm: Độ phức tạp lớn

    public void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {          // Bắt đầu duyệt
            for (int j = i + 1; j < arr.length; j++) {      // Tìm kiếm phần tử nhỏ hơn i hiện tại
                if (arr[i] > arr[j]) {                      // So sánh giá trị
                    int swapTemp = arr[i];                  // Swap 2 giá trị 
                    arr[i] = arr[j];
                    arr[j] = swapTemp;
                }
            }
        }
        System.out.println("Selection Sort: ");
        System.out.print("Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "; ");
        }
        System.out.println("");
    }

}
