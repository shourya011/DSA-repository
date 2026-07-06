class ThirdMaxNumber {
    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int num : set){
            q.offer(num);
            if(q.size()>3){
                q.poll();
            }
        }
        if (set.size() < 3){
           int max = Integer.MIN_VALUE;
            for (int num : set) {
                max = Math.max(max, num);
            }
            return max;
        }
        return q.peek();
    }
}