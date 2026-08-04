class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        Arrays.sort(nums);
        int f = nums[0];
        int h = nums[nums.length-1];
        for(int i=f;i<=h;i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}


//3731. Find Missing Elements