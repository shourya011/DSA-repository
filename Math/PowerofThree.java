class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==1 || n==3) return true;
        long num = 3;
        for(int i=0;i<n/3;i++){
            num *= (long)3;
            if(num==n){
                return true;
            }
            if(num>n) return false;
        }
        return false;
    }
}


//326. Power of Three