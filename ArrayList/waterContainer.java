package ArrayList;

import java.util.*;

public class waterContainer {

    public static void max_water(ArrayList<Integer> height) {
        int maxWater = Integer.MIN_VALUE;
        int lp = 0;
        int rp = height.size() - 1;
        while (lp < rp) {
            int ht = Math.min(height.get(lp), height.get(rp));
            int wt = rp - lp;
            int curr_water = (ht * wt);
            maxWater = Math.max(curr_water, maxWater);
            if (lp < rp) {
                lp++;
            } else {
                rp--;
            }
        }
        System.out.println(maxWater);
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(3);
        height.add(7);
        max_water(height);
    }
}
