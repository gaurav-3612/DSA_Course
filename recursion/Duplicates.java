package recursion;

public class Duplicates {

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        // base case
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        //b-a=1,c-a=2,etc to get index for map[]
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            removeDuplicates(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx + 1, newStr.append(currChar), map);
        }
    }

    public static void main(String[] args) {
        String str = "rrroohhhhhhiiiittttttt";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
