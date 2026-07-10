class Solution {
    public int mySqrt(int x) {
        int low = 0, high = x;
        int mid = 0;
        int ans = 0;
        while(low<=high){
            mid = low + (high-low)/2;
            long sq = (long) mid*mid;
            if(sq==x){
                return mid;
            }
            else if(sq<x){
                ans = mid;
                low = mid + 1;
            }
            else if(sq>x){
                high = mid - 1;
            }
        }
        return ans;
    }
}