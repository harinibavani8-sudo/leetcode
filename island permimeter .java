class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;

                    // Check down
                    if (i + 1 < rows && grid[i + 1][j] == 1) {
                        perimeter -= 2;
                    }

                    // Check right
                    if (j + 1 < cols && grid[i][j + 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }
}
