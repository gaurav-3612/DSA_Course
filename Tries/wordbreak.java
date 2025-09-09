package Tries;

public class wordbreak {

    static class Node {

        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();
    // each new node created will have children array of 26 letters not only the root node

    public static void insert(String word) {  // O(l)--> l is the length of word
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx]; // every time new node becomes curr and work as root
        }
        curr.eow = true;
    }

    public static boolean search(String key) {  // O(l)--> l is the length of word
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx]; // every time new node becomes curr and work as root
        }
        return curr.eow;
    }

    public static boolean WordBreak(String s) {
        if (s.length() == 0) {
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (search(s.substring(0, i)) && WordBreak(s.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        String words[] = {"a", "the", "there", "their", "any", "thee"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        System.out.println(WordBreak("theanythor"));
    }
}
