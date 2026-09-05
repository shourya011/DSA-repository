class Solution {
    public int firstStableIndex(int[] nums, int k) {
        if(nums.length==0) return -1;
        int[] minA = new int[nums.length];
        ArrayList<Integer> maxA = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(max<nums[i]){
                max = nums[i];
            }
            maxA.add(max);
        }
        int index = nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<min){
                min = nums[i];
            }
            minA[index--] = min;
        }
        for(int i=0;i<nums.length;i++){
            int x = maxA.get(i) - minA[i];
            if(x<=k) return i;
        }
        return -1;

    }
}

//3904. Smallest Stable Index II