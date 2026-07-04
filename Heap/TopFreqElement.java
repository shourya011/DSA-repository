class TopFreqElement {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i]) + 1);
            else
                map.put(nums[i],1);
        }
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            q.offer(e);
        }
        for(int i=0;i<k;i++){
            arr[i] = q.poll().getKey();
        }
        return arr;
        
    }
}