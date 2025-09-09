package arrays;

public class Binary_search {

    public static int BinarySearch(int array[], int key) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2; // Move mid calculation inside the loop

            if (array[mid] == key) {
                return mid;
            }
            if (array[mid] < key) {
                start = mid + 1;
            }
            if (array[mid] > key) {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int array[] = {10, 20, 30, 40, 50, 60};
        int key = 40;
        int result = BinarySearch(array, key);

        if (result == -1) {
            System.out.println("number not found");
        } else { // Add else block
            System.out.println("the number is at index " + result);
        }
    }
}

// THE BINARY SEARCH IS ALSO USED FOR SEARCH OF MINIMUM ELEMENT IN A ROTATED ARRAY EXACTLY SAME CODE NO CHANGE
