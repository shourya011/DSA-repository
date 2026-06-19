class topkfreq{
    public int max(HashMap<Integer,Integer> map){
        int max = Integer.MIN_VALUE;
        int ans = -1;
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            if(e.getValue()>max){
                max = e.getValue();
                ans = e.getKey();
            }
        }
        map.put(ans,0);
        return ans;
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }
            else
                map.put(nums[i],1);
        }
        int[] arr = new int[k];
        for(int i = 0; i < k; i++){
            arr[i] = max(map);
        }
        return arr;
    }
}