class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> b = new HashSet<>();
        int count = 0;
        int prevSeen = 0;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
                count++;
            }
            else{
                if(prevSeen!=nums[i] && !b.contains(nums[i])){
                    count--;
                    b.add(nums[i]);
                }
            }
            prevSeen = nums[i];
        }
        return count;
    }
}

//4038. Count Integers Appearing in a Single Block