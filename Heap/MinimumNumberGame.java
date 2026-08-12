class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            q.offer(nums[i]);
        }
        int i = 0;
        while(!q.isEmpty()){
            int m1 = q.poll();
            int m2 = q.poll();
            nums[i++] = m2;
            nums[i++] = m1;
        }
        return nums;
    }
}

//2974. Minimum Number Game