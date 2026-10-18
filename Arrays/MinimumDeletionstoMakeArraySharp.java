class Solution {
    public int minDeletions(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        int prev = 0;
        for(int i=0;i<nums.length;i++){
            if(prev != nums[i]){
                temp.add(nums[i]);
                prev = nums[i];
            }
        }
        return nums.length - temp.size();
    }
}


//4083. Minimum Deletions to Make Array Sharp