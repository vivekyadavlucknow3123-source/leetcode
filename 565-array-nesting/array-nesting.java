class Solution {
    public int arrayNesting(int[] nums) {
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            // Only traverse unvisited elements
            if (nums[i] != -1) {
                int count = 0;
                int curr = i;

                // Traverse the cycle
                while (nums[curr] != -1) {
                    count++;
                    int next = nums[curr];
                    nums[curr] = -1; // Mark as visited in-place
                    curr = next;
                }

                maxLength = Math.max(maxLength, count);
            }
        }

        return maxLength;
    }
}