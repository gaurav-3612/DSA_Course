package backtracking;

public class Basics {

}
/*
 This is the classic backtracking template:

You make a choice (include element in one subset).

Recurse.

Then undo the choice (backtrack) and try the other branch.


 */


 /*
 📝 Backtracking vs. No Backtracking

When backtracking is needed

If you modify a mutable structure (like List, StringBuilder, board[][] in Sudoku, etc.), you must undo the change before exploring the next branch.

Example: adding/removing elements from a list during DFS.

When backtracking is NOT needed

If you only modify primitive values (int, boolean, double, etc.), no explicit undo is required.

Because in Java, primitives are passed by value, so each recursive call already works on a fresh copy.

Example: helper(arr, currSum + arr[i], target - arr[i], i+1).


📝 Global result variable

Using a static or global variable (result) makes recursion simpler but has drawbacks:

Once true, it stays true for future test cases unless reset.

Harder to reuse in multi-test scenarios.

Better alternatives:

Return a boolean from recursion (return true if found, else false).

Or use memoization/DP for efficiency.
 */
