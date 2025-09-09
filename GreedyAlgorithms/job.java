package GreedyAlgorithms;

import java.util.*;

public class job {

    static class Job { // made new data type as Job 

        int id;
        int profit;
        int deadline;

        public Job(int i, int d, int p) {  //constructors in Java cannot be declared static; you should remove the static modifier from the constructor
            this.id = i;
            this.profit = p;
            this.deadline = d;
        }

        // @Override
        // public String toString() {
        //     return "Job{id=" + id + ", deadline=" + deadline + ", profit=" + profit + "}";
        // }
    }

    public static void main(String[] args) {
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 10}};
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobsInfo.length; i++) {  // here only one for loop is suff because we already know one dimension as 2
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }
        // System.out.println(job.get(1));
        Collections.sort(jobs, (a, b) -> b.profit - a.profit); // descending order sort
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        int profit = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
                profit += curr.profit;
            }
        }
        System.out.println(profit);
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + "  ");
        }
    }
}
