class Solution {
    public int countEven(int num) {
        int count = 0;
        for(int i=1;i<=num;i++){
            if(sum(i)%2==0){
                count++;
            }
        }
        return count;
    }
    public int sum(int num){
        int sum = 0;
        while(num>=10){
            int last = num % 10;
            num /= 10;
            sum += last;
        }
        sum += num;
        return sum;
    }
}


//2180. Count Integers With Even Digit Sum