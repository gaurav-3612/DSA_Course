package recursion;

public class last_occurance {

    public static int last(int arr[], int key, int i) {
        if (arr[i] == key) {
            return i;
        }
        if (i == 0) {
            return -1;
        }
        return last(arr, key, i - 1);
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 7, 8, 5, 1, 9, 5};
        System.out.println(last(arr, 5, arr.length - 1));
    }
}
