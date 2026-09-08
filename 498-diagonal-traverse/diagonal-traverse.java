class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }

        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];

        int row = 0;
        int col = 0;
        int dir = 1; // 1 = up-right, -1 = down-left

        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];

            if (dir == 1) { // Moving Up-Right
                if (col == n - 1) {
                    row++; // Hit right boundary -> move down
                    dir = -1;
                } else if (row == 0) {
                    col++; // Hit top boundary -> move right
                    dir = -1;
                } else {
                    row--;
                    col++;
                }
            } else { // Moving Down-Left
                if (row == m - 1) {
                    col++; // Hit bottom boundary -> move right
                    dir = -1 * dir;
                } else if (col == 0) {
                    row++; // Hit left boundary -> move down
                    dir = -1 * dir;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}