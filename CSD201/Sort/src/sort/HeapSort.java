/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 *
 * @author NGOMI
 */
public class HeapSort {

    public HeapSort() {
    }
    
    public void HeapSort(int arr[]){
        int n = arr.length;
        for(int i = n/2-1; i >= 0; i--){
            heapify(arr, n, i);
        }
        for(int i = n-1; i> 0; i--){
            int swapTemp = arr[0];
            arr[0] = arr[i];
            arr[i] = swapTemp;
            heapify(arr, i, 0);
        }
    }
    private void heapify(int arr[], int n, int i){
        int max = i;
        int l = 2*i;
        int r = 2*i + 1;
        if(l<n && arr[l] > arr[max]){
            max = l;
        }
        if(r<n && arr[r] > arr[max]){
            max = r;
        }
        if(max != i){
            int swapTemp = arr[max];
            arr[max] = arr[i];
            arr[i] = swapTemp;
            heapify(arr, n, max);
        }
        
    }
       
}
