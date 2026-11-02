class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                list.add(nums[i]);
            }
            set.add(nums[i]);
        }
        return list;
    }
}


//442. Find All Duplicates in an Array