class Solution {
    private final int[] original;
    private int[] array;
    private final Random rand;

    public Solution(int[] nums) {
        this.original = nums.clone(); // Store a copy for reset()
        this.array = nums;
        this.rand = new Random();
    }
    
    /** Resets the array to its original configuration and returns it. */
    public int[] reset() {
        this.array = original.clone();
        return this.array;
    }
    
    /** Returns a random shuffling of the array using Fisher-Yates Shuffle. */
    public int[] shuffle() {
        // Fisher-Yates Algorithm
        for (int i = 0; i < array.length; i++) {
            // Pick a random index j between i and array.length - 1
            int randomIndex = i + rand.nextInt(array.length - i);
            
            // Swap array[i] with array[randomIndex]
            swap(i, randomIndex);
        }
        return array;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}