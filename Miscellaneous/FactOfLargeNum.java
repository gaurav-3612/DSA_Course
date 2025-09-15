package Miscellaneous;
// gfg

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Stack;

class FactOfLargeNum {

    public static ArrayList<Integer> factorial(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        BigInteger num = fact(n);
        Stack<Integer> s = new Stack<>();

        // Extract digits using mod/divide
        BigInteger ten = BigInteger.TEN;
        while (num.compareTo(BigInteger.ZERO) > 0) {
            BigInteger rem = num.mod(ten); // remainder
            s.push(rem.intValue());       // store digit
            num = num.divide(ten);        // divide by 10
        }

        // Move digits from stack to result list
        while (!s.isEmpty()) {
            ans.add(s.pop());
        }

        return ans;
    }

    public static BigInteger fact(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;  // ✅ return BigInteger
        }
        return BigInteger.valueOf(n).multiply(fact(n - 1)); // ✅ correct multiply
    }
}
