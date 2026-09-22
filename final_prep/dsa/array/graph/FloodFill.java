package final_prep.dsa.array.graph;

//https://leetcode.com/problems/flood-fill/
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (color == originalColor) {
            return image;
        }
        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        dfs(image, sr, sc, originalColor, color, directions);
        return image;
    }

    void dfs(int[][] image, int sr, int sc, int originalColor, int newColor, int[][] directions) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != originalColor) {
            return;
        }
        image[sr][sc] = newColor;
        for (int[] dir : directions) {
            dfs(image, sr + dir[0], sc + dir[1], originalColor, newColor, directions);
        }

    }
}
