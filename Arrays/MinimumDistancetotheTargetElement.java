class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        ArrayList<Integer> arr = new ArrayList<>();
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                arr.add(i);
            }
        }
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<arr.size();i++){
            int temp = Math.abs(arr.get(i) - start);
            diff = Math.min(diff,temp);
        }
        return diff;
    }
}


//1848. Minimum Distance to the Target Element