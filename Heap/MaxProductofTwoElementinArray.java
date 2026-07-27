class Solution {
    public int maxProduct(int[] nums) {
        // Arrays.sort(nums);
        // return (nums[nums.length-1]-1) * (nums[nums.length-2]-1);

        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b - a);
        for(int i=0;i<nums.length;i++){
            q.offer(nums[i]);
        }
        return (q.poll()-1) * (q.poll()-1);
    }
}

//1464. Maximum Product of Two Elements in an Array