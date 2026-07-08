class Solution {
    public int searchInsert(int[] nums, int target) {
        int f = 0,l = nums.length-1;
        int mid = 0;
        while(f<=l){
            mid = f + (l-f)/2;
            if(nums[mid]>target){
                l = mid - 1;
            }
            else if(nums[mid]<target){
                f = mid + 1;
            }
            else{
                return mid;
            }
        }
        return f;  // main condition
    }
}