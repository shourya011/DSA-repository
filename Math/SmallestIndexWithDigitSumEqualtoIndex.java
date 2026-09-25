class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==find(nums[i])){
                return i;
            }
        }
        return -1;
    }
    public int find(int nums){
        int temp = nums;
        int n = 0;
        if(nums<10){
            return temp;
        }
        while(nums!=0){
            int last = nums%10;
            nums = nums/10;
            n += last;
        }
        return n;
    }
}

//3550. Smallest Index With Digit Sum Equal to Index