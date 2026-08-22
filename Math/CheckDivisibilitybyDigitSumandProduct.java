class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum = 0;
        int prod = 1;
        while(n!=0){
            int last = n % 10;
            n = n/10;
            sum += last;
            prod *= last;
        }
        return temp % (sum + prod) == 0;
    }
}


//3622. Check Divisibility by Digit Sum and Product