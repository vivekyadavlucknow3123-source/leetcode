import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;

        for (int r = 0; r < m; r++) {
            // Update histogram heights for current row
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == '1') {
                    heights[c]++;
                } else {
                    heights[c] = 0; // Reset height on '0'
                }
            }

            // Calculate max rectangle area for current histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    // LeetCode 84 Monotonic Stack Helper
    private int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}