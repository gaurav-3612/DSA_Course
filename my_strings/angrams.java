package my_strings;

import java.util.Arrays;
import java.util.Scanner;

public class angrams {

    // An anagram is a word or phrase that is created by rearranging the letters of another word or phrase.
    // Each letter must be used exactly once, and the new word or phrase must make sense. For example, 
    // the word "listen" can be rearranged to form the word "silent."
    public static boolean anag(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println("not anagrams");
            return false;
        }
        // string to array
        char arr1[] = str1.toCharArray();
        char arr2[] = str2.toCharArray();
        // sort the array
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        // compare the arrays
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("they are anagrams");
            return true;
        } else {
            System.out.println("not anagrams");
            return false;
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        anag(str1, str2);
    }
}
