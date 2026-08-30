class Solution {
    public int minimumDeletions(int[] nums) {
        int mini = 0;
        int maxi = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
                maxi = i;
            }
            if(nums[i]<min){
                min = nums[i];
                mini = i;
            }
        }
        mini++;
        maxi++;
        int fi = 0;
        int bi = nums.length;
        int fromFront = Math.max(mini, maxi);
        int fromBack = bi - Math.min(mini, maxi) + 1;
        int bothSide = Math.min(mini, maxi) + (bi - Math.max(mini, maxi) + 1);
        return Math.min(fromFront, Math.min(fromBack, bothSide));
    }
}


//2091. Removing Minimum and Maximum From Array