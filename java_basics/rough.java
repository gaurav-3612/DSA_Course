package java_basics;

import java.util.ArrayList;

public class rough {

    public static void main(String[] args) {
        int start[] = {10, 12, 20};
        int end[] = {20, 25, 30};
        int m = 0;
        int n = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (n < end.length && m < start.length) {
            if (end[n] <= start[m]) {
                ans.add(n);
                n++;
                m++;
            } else {
                m++;
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
