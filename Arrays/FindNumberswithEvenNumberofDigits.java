class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(check(nums[i])) count++;
        }
        return count;
    }
    public boolean check(int num){
        String s = num + "";
        if(s.length()%2==0){
            return true;
        }
        return false;
    }
}

//1295. Find Numbers with Even Number of Digits