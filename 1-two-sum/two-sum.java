public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a map to store the difference and its index
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement of the current number with respect to the target
            int complement = target - nums[i];
            
            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If it does, return the indices of the two numbers
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, put the current number and its index into the map
            map.put(nums[i], i);
        }
        
        // If no solution is found (which shouldn't happen according to problem constraints)
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        // Call the twoSum method and print the result
        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}

