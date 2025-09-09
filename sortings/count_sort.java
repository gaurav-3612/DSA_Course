package sortings;

public class count_sort {

    public static void count_sort(int array[]) {
        int n = array.length;
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            largest = Math.max(largest, array[i]);
        }
        int count[] = new int[largest + 1];
        for (int i = 0; i < n; i++) {
            count[array[i]]++;
        }
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[j] = i;
                count[i]--;
                j++;
            }
        }
    }

    public static void main(String args[]) {
        int array[] = {5, 3, 4, 5, 2, 1, 3, 1, 2, 6};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
        count_sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
