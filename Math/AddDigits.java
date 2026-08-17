class Solution {
    public int addDigits(int num) {
        int n = num;
        while(n>=10){
            int sum = 0;
            while(n!=0){
                int last = n % 10;
                n = n /10;
                sum += last;
            }
            n = sum;
        }
        return n;
    }
}



//258. Add Digits