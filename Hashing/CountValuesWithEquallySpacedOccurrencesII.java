class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                ArrayList<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i],list);
            }
            else{
                map.put(nums[i],new ArrayList<>(Arrays.asList(i)));
            }
        }
        int count = 0;
        for(Map.Entry<Integer,ArrayList<Integer>> e : map.entrySet()){
            ArrayList<Integer> arr = e.getValue();
            if(arr.size()>=3){
                int gap = arr.get(1) - arr.get(0);
                boolean valid = true;
                for (int i = 2; i < arr.size(); i++) {
                    if (arr.get(i) - arr.get(i - 1) != gap) {
                        valid = false;
                        break;
                    }
                }
            if (valid) count++;
            }
        }
        return count;
    }
}


//4049. Count Values With Equally Spaced Occurrences II