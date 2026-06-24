class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int added = 0;
        int i = 0;
        
        // Keep expanding our range until we can form all numbers up to n
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                // The current number helps us extend our range without gaps
                miss += nums[i];
                i++;
            } else {
                // There's a gap, so we greedily patch 'miss' itself
                miss += miss;
                added++;
            }
        }
        
        return added;
    }
}