class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] nums = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            nums[i] = arr[i];
        }
        Arrays.sort(nums);
        int rank = 1;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]));
            }
            else{
                map.put(nums[i],rank++);
            }
        }
        int[] ans = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int temp = map.get(arr[i]);
            ans[i] = temp;
        }   
        return ans;
    }
}

//1331. Rank Transform of an Array