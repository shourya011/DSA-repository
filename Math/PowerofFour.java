class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1 || n==4) return true;
        long num = 4;
        for(int i=0;i<n/4;i++){
            num *= 4;
            if(num == (long)n){
                return true;
            }
            if(num>n) return false;
        }
        return false;
    }
}



//342. Power of Four