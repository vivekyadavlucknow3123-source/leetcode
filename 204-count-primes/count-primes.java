class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0; // No prime numbers strictly less than 2
        }
        
        boolean[] isPrime = new boolean[n];
        // Initialize all numbers from 2 to n-1 as potential primes
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        
        // Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // Mark multiples of i starting from i * i
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Count primes
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        
        return count;
    }
}