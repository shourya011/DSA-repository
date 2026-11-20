class Solution {
    public int maximumCount(int[] nums) {
        int maxp = 0;
        int maxn = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=1){
                maxp++;
            }
            else if(nums[i]<=-1) maxn++;
        }
        return Math.max(maxp,maxn);
    }
}

//2529. Maximum Count of Positive Integer and Negative Integer