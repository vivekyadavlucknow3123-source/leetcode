class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int MOD = 1_000_000_007;
        
        // Quick prune: target out of reach
        if (target < n || target > n * k) {
            return 0;
        }

        // dp[j] stores ways to get target sum j
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case: 0 dice -> sum 0

        for (int dice = 1; dice <= n; dice++) {
            int[] nextDp = new int[target + 1];

            for (int sum = dice; sum <= Math.min(dice * k, target); sum++) {
                long ways = 0;
                for (int face = 1; face <= k && face <= sum; face++) {
                    ways = (ways + dp[sum - face]) % MOD;
                }
                nextDp[sum] = (int) ways;
            }

            dp = nextDp;
        }

        return dp[target];
    }
}