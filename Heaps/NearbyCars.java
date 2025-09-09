package Heaps;

import java.util.*;

public class NearbyCars {

    static class points implements Comparable<points> {

        int x;
        int y;
        int dist;
        int idx;

        public points(int x, int y, int dist, int idx) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.idx = idx;
        }

        public int compareTo(points p2) {
            return this.dist - p2.dist;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<points> pq = new PriorityQueue<>();
        int k = 2;
        int pts[][] = {{3, 0}, {4, 2}, {4, 2}, {1, 1}, {3, 1}};
        for (int i = 0; i < pts.length; i++) {
            int dist = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new points(pts[i][0], pts[i][1], dist, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("c" + pq.remove().idx);
        }
    }
}
