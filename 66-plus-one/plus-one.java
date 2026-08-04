class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Traverse the array from the end (least significant digit)
        for (int i = n - 1; i >= 0; i--) {
            // If current digit is less than 9, increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // If current digit is 9, it becomes 0
            digits[i] = 0;
        }
        
        // If all digits were 9, we need an extra digit at the front (e.g., [9,9] -> [1,0,0])
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1; // Default values in Java int[] are 0, so rest are already 0
        
        return newDigits;
    }
}