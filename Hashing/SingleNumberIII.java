class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
                continue;
            }
            set.add(nums[i]);
        }
        int[] array = new int[set.size()];
        int i=0;
        for(int n : set){
            array[i++] = n;
        }
        return array;
    }
}


//260. Single Number III