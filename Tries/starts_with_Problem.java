package Tries;

public class starts_with_Problem {

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

    public static boolean starts(String key) {
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String args[]) {
        String words[] = {"a", "the", "there", "their", "any", "thee"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        String k1 = "an";
        String k2 = "thor";
        System.out.println(starts(k1));
        System.out.println(starts(k2));
    }
}
