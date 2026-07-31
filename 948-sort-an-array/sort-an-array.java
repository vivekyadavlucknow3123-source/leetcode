class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        
        // Auxiliary array to avoid frequent memory allocations during merges
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        // Recursively sort left and right halves
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);

        // Merge the two sorted halves
        merge(nums, left, mid, right, temp);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;      // Pointer for left sub-array
        int j = mid + 1;   // Pointer for right sub-array
        int k = left;      // Pointer for temp array

        // Compare and copy smaller elements into temp
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // Copy remaining elements from left half
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // Copy remaining elements from right half
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // Copy merged elements back into original array
        for (int p = left; p <= right; p++) {
            nums[p] = temp[p];
        }
    }
}