package my_strings;

import java.util.Scanner;

public class palindrome {

    public static boolean ispalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                System.out.println("word is not a palindrome");
                return false;
            }
        }
        System.out.println("word is palindrome");
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        ispalindrome(word);
    }
}
