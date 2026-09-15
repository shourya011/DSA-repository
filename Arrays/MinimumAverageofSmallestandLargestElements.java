class Solution {
    public double minimumAverage(int[] nums) {
        double ans = Double.MAX_VALUE;
        int min = 0;
        while(nums.length>0){
            int maxValue = max(nums);
            int minValue = min(nums);

            double avg = (maxValue + minValue) / 2.0;
            ans = Math.min(ans,avg);

            int[] temp = new int[nums.length - 2];
            int index = 0;

            boolean minRemoved = false;
            boolean maxRemoved = false;

            for (int num : nums) {
                if (!minRemoved && num == minValue) {
                    minRemoved = true;
                } else if (!maxRemoved && num == maxValue) {
                    maxRemoved = true;
                } else {
                    temp[index++] = num;
                }
            }
            nums = Arrays.copyOf(temp,temp.length);
        }
        return ans;
    }
    public int max(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i],max);
        }
        return max;
    }
    public int min(int[] nums){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            min = Math.min(nums[i],min);
        }
        return min;
    }
}

//3194. Minimum Average of Smallest and Largest Elements