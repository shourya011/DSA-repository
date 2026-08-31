class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            // map.put(nums[i],map.getOrDefault(nums[i],0) + 1);

            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(check(e.getValue())){
                return true;
            }
        }
        return false;
    }
    public boolean check(int num){
        if(num==1){
            return false;
        }
        for(int i=2;i<num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}


//3591. Check if Any Element Has Prime Frequency