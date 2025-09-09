package GreedyAlgorithms;

import java.util.*;

public class Chocolate {

    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costHor[] = {4, 1, 2}; //used primitive data type for use of Collections frame work
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());
        int cost = 0;
        int h = 0, v = 0;
        int hp = 1, vp = 1;
        /*
         hp = number of horizontal pieces currently

         vp = number of vertical pieces currently

         h = index for horizontal cuts

         v = index for vertical cuts
         */
        // we have to use all the cuts but the main thing is how we are doing it in what order
        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] > costHor[h]) {
                cost += (hp * costVer[v]);
                v++;
                vp++;
            } else {
                cost += (costHor[h] * vp);
                h++;
                hp++;
            }
        }
        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            h++;
            hp++;
        }
        while (v < costVer.length) {
            cost += (hp * costVer[v]);
            v++;
            vp++;
        }
        System.out.println(cost);
    }
}
/*
 Sorting costVer: O(m log m) where m = number of vertical cuts

Sorting costHor: O(n log n) where n = number of horizontal cuts

Merging Cuts (while loops):

Main while loop runs O(m + n) times (each iteration processes one cut)

Remaining while loops are also O(m + n)

Overall:

O(mlogm+nlogn+m+n)⇒O(mlogm+nlogn)

 */
