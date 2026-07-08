class SumandMultiply {
    public long sumAndMultiply(int n) {
        if(n==0){
            return 0;
        }
        long sum = 0;
        String x = "";
        while(n!=0){
            int last = n % 10;
            sum = sum + last;
            n = n/10;
            if(last!=0)
                x = last + x;
        }
        long temp = Integer.parseInt(x);
        long ans =  temp * sum;
        return ans; 
    }
}