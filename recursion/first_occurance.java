package recursion;

public class first_occurance {

    public static int first(int arr[], int key, int i) {
        if (arr[i] == key) {
            return i;
        }
        if (i == arr.length - 1) {
            return -1;
        }
        return first(arr, key, i + 1);
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 7, 8, 5, 1, 9, 5};
        System.out.println(first(arr, 5, 0));
    }
}
