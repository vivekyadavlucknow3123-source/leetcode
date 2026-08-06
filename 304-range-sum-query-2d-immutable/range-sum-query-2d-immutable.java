class NumMatrix {
    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // Allocate a matrix of size (m + 1) x (n + 1) to handle edge cases easily
        prefixSum = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixSum[i + 1][j + 1] = matrix[i][j] 
                                        + prefixSum[i][j + 1] 
                                        + prefixSum[i + 1][j] 
                                        - prefixSum[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1] 
             - prefixSum[row1][col2 + 1] 
             - prefixSum[row2 + 1][col1] 
             + prefixSum[row1][col1];
    }
}