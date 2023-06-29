
package sort;

public class QuickSort {

    public QuickSort() {
    }

    public void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end); // Gán phần tử chốt
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];               // Vị trí pilot ở cuối cùng
        int i = (begin - 1);                // Index trả về

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {          // Nếu vị trí nhỏ hơn vị trí chốt thì chuyển nó qua bên trái
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];          // Di chuyển phần tử chốt về sau
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;
        return i + 1;

    }

}
