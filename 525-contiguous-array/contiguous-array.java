class Solution {
    public int findMaxLength(int[] nums) {
        // Map stores (prefixSum -> first seen index)
        Map<Integer, Integer> map = new HashMap<>();
        
        // Base case: prefix sum 0 occurs before the array starts (at index -1)
        map.put(0, -1);
        
        int prefixSum = 0;
        int maxLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Convert 0 to -1, keep 1 as +1
            prefixSum += (nums[i] == 1) ? 1 : -1;
            
            if (map.containsKey(prefixSum)) {
                // Found a previous index with the same prefix sum
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            } else {
                // Store the first time we see this prefix sum
                map.put(prefixSum, i);
            }
        }
        
        return maxLength;
    }
}