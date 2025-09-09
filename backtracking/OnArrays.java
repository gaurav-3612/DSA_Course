package backtracking;

public class OnArrays {

    public static void ChangeArray(int arr[], int i, int val) {
        // base case
        // i have not used arr.length-1 because the change arr goes untill i=5 but arr[i]=val not executed due to return
        if (i == arr.length) {
            PrintArray(arr);
            return;
        }
        // kaam
        arr[i] = val;
        ChangeArray(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }

    public static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        ChangeArray(arr, 0, 1);
        PrintArray(arr);
    }
}
