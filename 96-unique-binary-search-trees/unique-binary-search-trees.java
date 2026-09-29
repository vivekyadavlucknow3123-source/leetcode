class Solution {
    public int numTrees(int n) {
        // G[i] stores the number of unique BSTs that can be formed using 'i' nodes
        int[] G = new int[n + 1];

        // Base cases
        G[0] = 1; // Empty tree is 1 valid structure
        G[1] = 1; // Single node tree is 1 valid structure

        // Fill DP array from 2 to n
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // j is the root node
                // Left subtree has (j - 1) nodes
                // Right subtree has (i - j) nodes
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }
}