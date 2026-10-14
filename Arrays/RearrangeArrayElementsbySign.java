class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> min = new ArrayList<>();
        ArrayList<Integer> max = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                max.add(nums[i]);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                min.add(nums[i]);
            }
        }
        int[] ans = new int[nums.length];
        int maxi = 0;
        int mini = 0;
        int temp = 0;
        for(int i=0;i<ans.length;i++){
            if(i%2==0){
                temp = max.get(maxi);
                maxi++;
            }
            else{
                temp = min.get(mini);
                mini++;
            }
            ans[i] = temp;
        }
        return ans;
    }
}


//2149. Rearrange Array Elements by Sign
