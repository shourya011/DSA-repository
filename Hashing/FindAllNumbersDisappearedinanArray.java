class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>();
        int index = 1;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(index)){
                list.add(index);
            }
            index++;
        }
        return list;
    }
}

//448. Find All Numbers Disappeared in an Array