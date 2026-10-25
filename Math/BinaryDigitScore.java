class Solution {
    public int calculateScore(int a, int b) {
        String s1  = binary(a);
        String s2 = binary(b);
        int s1c = 0,s2c = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) == '1'){
                s1c ++;
            }
        }
        for(int i=0;i<s2.length();i++){
            if(s2.charAt(i) == '1'){
                s2c ++;
            }
        }
        if(s1c>=s2c) return s1c * s2c;
        if(s1c==0) return 0;
        return s2c/s1c;
        
    }
    public String binary(int n){
        String ans = "";
        if(n==0) return "0";
        while(n>0){
            if(n%2==0){
                ans = ans + '0';
            }
            else{
                ans = ans + '1';
            }
            n = n/2;
        }
        ans = ans + n + "";
        return ans;
    }
}



//4092. Binary Digit Score