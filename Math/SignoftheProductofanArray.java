class Solution {
    public int arraySign(int[] nums) {
        int prod = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                prod = 0;
            }
            else if(nums[i]<1 && prod==1){
                prod = -1;
            }
            else if(nums[i]>1 && prod==-1){
                prod = -1;
            }
            else if(nums[i]>1 && prod==1){
                prod = 1;
            }
            else if(nums[i]<1 && prod==-1){
                prod = 1;
            }
        }
        return prod;
    }
}


//1822. Sign of the Product of an Array