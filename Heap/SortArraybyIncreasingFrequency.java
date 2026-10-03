class Solution {
    class Pair{
        int val;
        int freq;

        Pair(int val,int freq){
            this.val = val;
            this.freq = freq;
        }
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> {
            if(a.freq == b.freq){
                return b.val - a.val;
            }
            else{
                return a.freq - b.freq;
            }
        });
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            int val = e.getKey();
            int freq = e.getValue();
            q.offer(new Pair(val,freq));
        }
        int index = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int val = p.val;
            int freq = p.freq;
            for(int i=0;i<freq;i++){
                nums[index++] = val;
            }
        }
        return nums;
    }
}


//1636. Sort Array by Increasing Frequency