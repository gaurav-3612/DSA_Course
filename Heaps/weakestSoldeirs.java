package Heaps;

import java.util.*;

public class weakestSoldeirs {

    static class Row implements Comparable<Row> {

        int soldier;
        int idx;

        public Row(int soldier, int idx) {
            this.soldier = soldier;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soldier == r2.soldier) {
                return this.idx - r2.idx;
            } else {
                return this.soldier - r2.soldier;
            }
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Row> pq = new PriorityQueue<>();
        int army[][] = {{1, 0, 0, 0},
        {1, 1, 1, 0},
        {1, 0, 0, 0},
        {1, 1, 1, 1}
        };
        int k = 2;
        for (int i = 0; i < army.length; i++) {
            int totalSoldiers = 0;
            for (int j = 0; j < army[0].length; j++) {
                totalSoldiers += army[i][j];
            }
            pq.add(new Row(totalSoldiers, i));
        }
        for (int i = 0; i < k; i++) {
            System.out.println("R" + pq.remove().idx);
        }
    }
}
