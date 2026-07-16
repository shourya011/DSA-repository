class Solution {
    public long gcdSum(int[] nums) {
        int[] prefixGcd = new int[nums.length];
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i],max);
            prefixGcd[i] = gcd(nums[i],max);
        }
        Arrays.sort(prefixGcd);
        int l = 0;
        int h = prefixGcd.length-1;
        long sum = 0;
        while(l<h){
            sum += gcd(prefixGcd[l],prefixGcd[h]);
            l++;
            h--;
        }
        return sum;
    }
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}