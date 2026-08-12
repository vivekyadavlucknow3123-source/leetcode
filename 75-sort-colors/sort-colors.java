class Solution {
    public void sortColors(int[] nums) {
        int low=0, mid=0, highe=nums.length-1;
        while(mid<=highe){
            if(nums[mid]==0){
                int temp=nums[low];
                nums[low++]=nums[mid];
                nums[mid++]=temp;
            }else if(nums[mid]==1){
                mid++;
            }else{
                int temp=nums[mid];
                nums[mid]=nums[highe];
                nums[highe--]=temp;
            }
        }
    }
}