class Solution {
    public int maximumDifference(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int temp = -1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    temp = nums[j] - nums[i];
                }
                max = Math.max(temp,max);
            }
        }
        if(max==Integer.MIN_VALUE) return -1;
        return max;
    }
}

//2016. Maximum Difference Between Increasing Elements