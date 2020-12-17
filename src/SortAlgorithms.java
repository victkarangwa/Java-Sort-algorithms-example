
//Reg. No.: 219000110
/**
 * Program to generate 1000 random numbers from 1-100 and
 * sort them with:
 * Selection sort,
 * Merge sort,
 * Quick sort
 * and Insertion sort
 */

import java.util.concurrent.ThreadLocalRandom;

public class SortAlgorithms {
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    public static void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }
    public static void merge(int[] left_arr,int[] right_arr, int[] arr,int left_size, int right_size){

        int i=0,l=0,r = 0;
        //The while loops check the conditions for merging
        while(l<left_size && r<right_size){

            if(left_arr[l]<right_arr[r]){
                arr[i++] = left_arr[l++];
            }
            else{
                arr[i++] = right_arr[r++];
            }
        }
        while(l<left_size){
            arr[i++] = left_arr[l++];
        }
        while(r<right_size){
            arr[i++] = right_arr[r++];
        }
    }

    public static void mergeSort(int [] arr, int len){
        if (len < 2){return;}

        int mid = len / 2;
        int [] left_arr = new int[mid];
        int [] right_arr = new int[len-mid];

        //Dividing array into two and copying into two separate arrays
        int k = 0;
        for(int i = 0;i<len;++i){
            if(i<mid){
                left_arr[i] = arr[i];
            }
            else{
                right_arr[k] = arr[i];
                k = k+1;
            }
        }
        // Recursively calling the function to divide the subarrays further
        mergeSort(left_arr,mid);
        mergeSort(right_arr,len-mid);
        // Calling the merge method on each subdivision
        merge(left_arr,right_arr,arr,mid,len-mid);
    }

    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    public static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

    public static void main(String a[]){
        int array[] = new int[1000];
        for (int i = 0; i < 1000; i++)
        {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 100 + 1);
            array[i] = randomNum;
        }

        System.out.println("Before Sort algorithms:");
        for(int i:array){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("===========================");
        System.out.println("\n");

        selectionSort(array);//sorting array using selection sort
        System.out.println("After Selection Sort:");
        for(int i:array){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("===========================");
        System.out.println("\n");

        insertionSort(array);//sorting array using insertion sort

        System.out.println("After Insertion Sort:");
        for(int i:array){
            System.out.print(i+" ");
        }

        System.out.println();
        System.out.println("===========================");
        System.out.println("\n");


        mergeSort(array,array.length);//sorting array using Merge sort
        System.out.println("After Merge Sort:");
        for(int i:array){
            System.out.print(i+" ");
        }

        System.out.println();
        System.out.println("===========================");
        System.out.println("\n");

        quickSort(array,0, array.length-1);//sorting array using Quick sort
        System.out.println("After Quick Sort:");
        for(int i:array){
            System.out.print(i+" ");
        }

        System.out.println();
        System.out.println("===========================");
        System.out.println("\n");



    }
}  