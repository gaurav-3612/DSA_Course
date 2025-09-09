package Tries;

public class longest_word_with_all_pefixes {

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
    public static String ans = ""; // must be defined

    public static void LargetPrefix(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow) {
                char ch = (char) (i + 'a');
                temp.append(ch);

                // Update answer if this is the longest valid prefix so far
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                // Recursively explore deeper only if all prefixes so far are valid
                LargetPrefix(root.children[i], temp);

                // Backtrack
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String args[]) {
        String words[] = {"a", "banana", "appl", "app", "apply", "apple", "ap"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        LargetPrefix(root, new StringBuilder());
        System.out.println(ans);
    }
}
