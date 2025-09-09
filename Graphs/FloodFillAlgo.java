package Graphs;

public class FloodFillAlgo {

    public static void helper(int[][] image, int sr, int sc, int color, boolean visit[][], int orgColor) { // O(m*n)
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visit[sr][sc] || image[sr][sc] != orgColor) {
            return;
        }
        visit[sr][sc] = true;
        image[sr][sc] = color;
        //left
        helper(image, sr, sc + 1, color, visit, orgColor);
        //right
        helper(image, sr, sc - 1, color, visit, orgColor);
        //top
        helper(image, sr - 1, sc, color, visit, orgColor);
        //bottom
        helper(image, sr + 1, sc, color, visit, orgColor);
    }

    public static int[][] color(int[][] image, int sr, int sc, int color) {
        boolean visit[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, visit, image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1},
        {1, 1, 0},
        {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;

        int[][] result = color(image, sr, sc, color);

        // Print result
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
