package sortings;

public class merge_sort {

    public static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void MergeSort(int arr[], int si, int ei) {
        int mid = si + (ei - si) / 2;
        // it can be (si-ei)/2
        // base case
        if (si >= ei) {
            return;
        }
        // kaam
        MergeSort(arr, si, mid);
        MergeSort(arr, mid + 1, ei);
        Merge(arr, si, mid, ei);
    }

    public static void Merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        // leftover left side elements
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        // leftover right side elements
        while (j <= ei) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        // copy from temp to original array
        for (k = 0; k < temp.length; k++) {
            arr[si + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int arr[] = {6, 4, 5, 1, 3, 7};
        PrintArray(arr);
        MergeSort(arr, 0, arr.length - 1);
        PrintArray(arr);
    }
}
/*
 MergeSort(0,5)
 ├─ MergeSort(0,2)
 │   ├─ MergeSort(0,1)
 │   │   ├─ MergeSort(0,0) → return
 │   │   ├─ MergeSort(1,1) → return
 │   │   └─ Merge(0,0,1) → [4,6]
 │   ├─ MergeSort(2,2) → return
 │   └─ Merge(0,1,2) → [4,5,6]
 ├─ MergeSort(3,5)
 │   ├─ MergeSort(3,4)
 │   │   ├─ MergeSort(3,3) → return
 │   │   ├─ MergeSort(4,4) → return
 │   │   └─ Merge(3,3,4) → [1,3]
 │   ├─ MergeSort(5,5) → return
 │   └─ Merge(3,4,5) → [1,3,7]
 └─ Merge(0,2,5) → [1,3,4,5,6,7]

 */
