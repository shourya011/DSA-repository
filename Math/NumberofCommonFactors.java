class Solution {
    public int commonFactors(int a, int b) {
        int count = 0;
        int temp = 0;
        if(a>b){
            temp = a;
        }
        else{
            temp = b;
        }
        for(int i=1;i<=temp;i++){
            if(a%i==0 && b%i==0){
                count++;
            }
        }
        return count;
    }
}


//2427. Number of Common Factors