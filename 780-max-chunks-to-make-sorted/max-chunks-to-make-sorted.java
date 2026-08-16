class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxSoFar = 0;
        int chunks = 0;

        for (int i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);
            
            // If maximum value seen matches current index, we can make a cut
            if (maxSoFar == i) {
                chunks++;
            }
        }

        return chunks;
    }
}