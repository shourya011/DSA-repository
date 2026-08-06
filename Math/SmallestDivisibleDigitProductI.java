class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=100;i++){
            int prod = 1;
            int temp = n;
            while(temp!=0){
                int last = temp % 10;
                temp = temp/10;
                prod *= last;
            }
            if(prod%t==0){
                return i;
            }
            n = n + 1;
        }
        return -1;
    }
}

//3345. Smallest Divisible Digit Product I