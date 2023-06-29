
package sort;

public class MergeSort {

    public MergeSort() {
    }

    public void mergeSort(int arr[], int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = (begin + end) / 2;
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }
    private void merge(int arr[], int begin, int mid, int end){
        int n1 = mid - begin + 1;
        int n2 = end - mid;
        int tempL[] = new int[n1];
        int tempR[] = new int[n2];
        for(int i = 0; i<n1; i++){
            tempL[i] = arr[begin + i];
        }
        for(int i = 0; i < n2; i++){
            tempR[i] = arr[mid + 1 + i];
        }
        int i = 0, j=0;
        int k = begin;
        while (i<n1 && j<n2){
            if(tempL[i]<tempR[j]){
                arr[k++] = tempL[i++];
            } else{
                arr[k++] = tempR[j++];
            }
        }
        while(i<n1){
            arr[k++] = tempL[i++];
        }
        while(j < n2){
            arr[k++] = tempR[j++];
        }
    }

//    private void merge(int arr[], int begin, int mid, int end) {
//        if (!(begin <= mid) && (mid <= end)) {
//            return;
//        }
//        int n, i, j, k, x;
//        n = begin - end + 1;
//        int[] b = new int[n];
//        i = begin;
//        j = mid + 1;
//        k = 0;
//        while (i <= mid && j <= end) {
//            if (arr[i] < arr[j]) {
//                b[k++] = arr[i++];
//            } else {
//                b[k++] = arr[j++];
//            }
//        }
//        while (i <= mid) {
//            b[k++] = arr[i++];
//        }
//        while (j <= end) {
//            b[k++] = arr[j++];
//        }
//        k = 0;
//        for (i = begin; i <= end; i++) {
//            arr[i] = b[k++];
//        }
//    }

}
