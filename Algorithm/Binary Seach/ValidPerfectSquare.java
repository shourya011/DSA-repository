class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1){
            return true;
        }
        int low = 1,high = num;
        int mid = 0;
        while(low<=high){
            mid = low + (high-low)/2;
            long square = (long) mid*mid;
            if(num>square){
                low = mid + 1;
            }
            else if(num<square){
                high = mid - 1;
            }
            else if(num==square){
                return true;
            }
        }
        return false;
    }
}