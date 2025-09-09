package GreedyAlgorithms;

import java.util.*;

public class coins {

    public static void main(String[] args) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000}; // use of primitive data type to use .reverseOrder
        int amount = 590;
        int amtOfCoins = 0;
        ArrayList<Integer> collect = new ArrayList<>();
        Arrays.sort(coins, Comparator.reverseOrder());
        for (int i = 0; i < coins.length; i++) {
            while (coins[i] <= amount) {
                amtOfCoins++;
                amount -= coins[i];
                collect.add(coins[i]);
            }
        }
        System.out.println(amtOfCoins);
        for (int i = 0; i < collect.size(); i++) {
            System.out.print(collect.get(i) + " ");
        }
    }
}
