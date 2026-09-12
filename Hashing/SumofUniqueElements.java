class Solution {
    public int sumOfUnique(int[] nums) {
        // int sum = 0;
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     if(map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
        //     else map.put(nums[i],1);
        // }
        // for(Map.Entry<Integer,Integer> e : map.entrySet()){
        //     if(e.getValue()==1){
        //         sum += e.getKey();
        //     }
        // }
        // return sum;


        // HashSet<Integer> set = new HashSet<>();
        // int sum = 0;
        // int prev = 0;
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++){
        //     if(set.contains(nums[i])){
        //         if(nums[i]!=prev)
        //             sum -= nums[i];
        //         prev = nums[i];
        //     }
        //     else sum += nums[i];
        //     set.add(nums[i]);
        // }
        // return sum;


        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(set1.contains(nums[i])){
                set2.remove(nums[i]);
                continue;
            }
            set1.add(nums[i]);
            set2.add(nums[i]);
        }
        for(int n : set2){
            sum += n;
        }
        return sum;
    }
}


//1748. Sum of Unique Elements