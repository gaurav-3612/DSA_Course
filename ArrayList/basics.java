package ArrayList;

import java.util.*;

public class basics {

    public static void PrintArrayList(ArrayList<Integer> list) {
        // getting the length of an arraylist
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // defining array list
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        // add an element--O(1)
        list1.add(2);
        list1.add(4);
        list1.add(7);
        list1.add(1);
        list1.add(0);
        list1.add(5);
        list1.add(3);
        PrintArrayList(list1);

        // get an element--O(1)
        int a = list1.get(2);
        System.out.println(a);

        // remove element--O(n)
        list1.remove(3);
        PrintArrayList(list1);

        // set element at index--O(n)
        list1.set(2, 10);
        PrintArrayList(list1);

        // contains an element--O(n)
        System.out.println(list1.contains(5));

        // adding an element at a particular index-- O(n)
        list1.add(2, 69);
        PrintArrayList(list1);

        // sorting of an arraylist
        Collections.sort(list1); //ascending
        PrintArrayList(list1);
        Collections.sort(list1, Collections.reverseOrder()); // descending
        PrintArrayList(list1);
    }
}
