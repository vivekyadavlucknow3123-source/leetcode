class Solution {
    public int arrayPairSum(int[] nums) {
        int[] count = new int[20001]; // Range: -10000 to 10000 (offset by 10000)
        
        for (int num : nums) {
            count[num + 10000]++;
        }
        
        int maxSum = 0;
        boolean addNext = true; // Tracks whether to add the current element (even-index equivalent)
        
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                if (addNext) {
                    maxSum += (i - 10000);
                }
                addNext = !addNext; // Toggle for the next element in pair
                count[i]--;
            }
        }
        
        return maxSum;
    }
}