class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        int i = 1;
        while(n/Math.pow(5,i)!=0){
            count += n/Math.pow(5,i);
            i++;
        }
        return count;
    }
}


//172. Factorial Trailing Zeroes