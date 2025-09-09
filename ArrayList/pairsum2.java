package ArrayList;

import java.util.ArrayList;

public class pairsum2 {

    public static boolean check(ArrayList<Integer> list, int target) {
        int n = list.size();
        int pivot = 0;// necessarry for in case the array is not rotated
        // first we need to find the pivot
        for (int i = 0; i < (n - 1); i++) {
            if (list.get(i) > list.get(i + 1)) {
                pivot = i;
                break;
            }
        }
        int lp = (pivot + 1) % n;
        int rp = pivot;
        while (lp != rp) {
            int sum = list.get(lp) + list.get(rp);
            if (sum == target) {
                return true;
            }
            if (sum > target) {
                rp = (n + rp - 1) % n;
            }
            if (sum < target) {
                lp = (lp + 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(15);
        list.add(18);
        list.add(3);
        list.add(7);
        list.add(10);
        int target = 25;
        System.out.println(check(list, target));
    }
}
