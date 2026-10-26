class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int n = arr.length;
        // countBuckets[f] stores how many unique numbers have frequency f
        int[] countBuckets = new int[n + 1];
        for (int count : map.values()) {
            countBuckets[count]++;
        }

        int remainingUnique = map.size();

        // Greedily eliminate unique numbers starting from lowest frequency (1..n)
        for (int freq = 1; freq <= n; freq++) {
            if (countBuckets[freq] == 0) continue;

            // Number of elements with frequency 'freq' we can fully eliminate
            int numElementsToEliminate = Math.min(countBuckets[freq], k / freq);

            k -= numElementsToEliminate * freq;
            remainingUnique -= numElementsToEliminate;

            // If k is insufficient to fully eliminate the next element of frequency 'freq'
            if (k < freq) {
                break;
            }
        }

        return remainingUnique;
    }
}