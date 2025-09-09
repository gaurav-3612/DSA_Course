package Stacks;

import java.util.*;

public class Histogram {

    public static void MaxArea(int hist[]) {
        int MaxArea = 0;
        // nsr
        Stack<Integer> s1 = new Stack<>();
        int nsr[] = new int[hist.length];
        for (int i = nsr.length - 1; i >= 0; i--) {
            while (!s1.isEmpty() && hist[s1.peek()] >= hist[i]) {
                s1.pop();
            }
            if (!s1.isEmpty()) {
                nsr[i] = s1.peek();
            } else {
                nsr[i] = nsr.length;
            }
            s1.push(i);
        }
        // nsl
        Stack<Integer> s2 = new Stack<>();
        int nsl[] = new int[hist.length];
        for (int i = 0; i < nsl.length; i++) {
            while (!s2.isEmpty() && hist[s2.peek()] >= hist[i]) {
                s2.pop();
            }
            if (!s2.isEmpty()) {
                nsl[i] = s2.peek();
            } else {
                nsl[i] = -1;
            }
            s2.push(i);
        }
        for (int i = 0; i < hist.length; i++) {
            int height = hist[i];
            int width = nsr[i] - nsl[i] - 1;
            int area = (height * width);
            MaxArea = Math.max(MaxArea, area);
        }
        System.out.println(MaxArea);
    }

    public static void main(String[] args) {
        int hist[] = {2, 1, 5, 6, 2, 3};
        MaxArea(hist);
    }
}
/*
 * error--
 * 1) properly copy paste nsr and nsl and also make required changes not entirely copy
 * 2) store indexes not athe actual values in the nsl,nsr,and stacks
 */
