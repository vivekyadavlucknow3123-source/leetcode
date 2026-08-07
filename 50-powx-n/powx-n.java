class Solution {
    public double myPow(double x, int n) {
        long N = n; // Use long to prevent integer overflow when n = Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1.0;
        double currentProduct = x;
        
        while (N > 0) {
            if (N % 2 == 1) { // If exponent is odd
                result *= currentProduct;
            }
            currentProduct *= currentProduct; // Square the base
            N /= 2; // Divide exponent by 2
        }
        
        return result;
    }
}