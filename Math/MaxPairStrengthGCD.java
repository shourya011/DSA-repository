class Solution {
    public long maxPairStrength(int[] nums) {
        List<Long> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                long temp = gcd(nums[i],nums[j]);
                if(temp==0){
                    continue;
                }
                long product = (long) nums[i] * nums[j];
                long n = product/(temp * temp);
                list.add(n);
            }
        }
        long max = 0;
        for(int i=0;i<list.size();i++){
            if(max<list.get(i)){
                max = list.get(i);
            }
        }
        return max;
    }

    long gcd(long a,long b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}

//4010. Maximize Pair Strength Using GCD