package Tries;

public class UniqueSubstring {

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

    public static int CountNodes(Node root) {
        Node curr = root;
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                count += CountNodes(curr.children[i]);
            }
        }
        return count + 1; // plus 1 beacause it the thing which count the nodes otherwise we get zero as not anywhere we do count++
    }

    public static void main(String args[]) {
        String word = "ababa";
        for (int i = 0; i < word.length(); i++) {
            String suffix = word.substring(i);
            insert(suffix);
        }
        System.out.println(CountNodes(root));
    }
}
// unique substring of a string i equal to the all unique prefix of all suffix
// first we have finded out the all suffix then use trie to count nodes because
// tries by default give the unique prefix of a string
