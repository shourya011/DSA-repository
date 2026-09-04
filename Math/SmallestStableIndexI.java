class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            int max = Max(nums,0,i);
            int min = Min(nums,i,n);
            if((max - min) <= k ) return i ;
        }
        return -1;
    }
    public int Max(int[] nums,int start,int end){
        int max = Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return max;
    }
    public int Min(int[] nums,int start,int end){
        int min = Integer.MAX_VALUE;
        for(int i=start;i<end;i++){
            if(nums[i]<min){
                min = nums[i];
            }
        }
        return min;
    }
}


//3903. Smallest Stable Index I