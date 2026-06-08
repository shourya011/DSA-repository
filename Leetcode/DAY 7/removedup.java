class removedup.java{
    public int removeDuplicates(int[] nums) {
        int f = 0;
        int s = 1;
        int index = 0;
        while(s!=nums.length){
            if(nums[f]!=nums[s]){
                nums[index] = nums[f];
                index++;
            }
            f++;
            s++;
        }
        nums[index] = nums[f];
        return index+1;
    }
}