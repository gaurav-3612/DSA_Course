package ArrayList;

import java.util.*;

public class multiDimensional {

    public static void PrintArrayList(ArrayList<ArrayList<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> currList = list.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.err.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            list1.add(i * 1);
            list2.add(i * 2);
            list3.add(i * 3);
        }
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        //IMPORTANT
        mainList.add(new ArrayList<>(Arrays.asList(1, 2)));
        mainList.add(new ArrayList<>());
        System.out.println(mainList);
        PrintArrayList(mainList);
    }
}
