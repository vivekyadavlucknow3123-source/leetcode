import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        if (k <= 0) {
            return 0;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;
        int totalSubarrays = 0;

        for (int right = 0; right < nums.length; right++) {
            
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            
            while (freqMap.size() > k) {
                int leftNum = nums[left];
                freqMap.put(leftNum, freqMap.get(leftNum) - 1);
                if (freqMap.get(leftNum) == 0) {
                    freqMap.remove(leftNum);
                }
                left++;
            }

            
            totalSubarrays += (right - left + 1);
        }

        return totalSubarrays;
    }
}