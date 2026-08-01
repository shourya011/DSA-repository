class Solution {
    public boolean isPalindrome(int x) {
        if(x==0) return true;
        if(x<0){
            return false;
        }
        String s = "";
        int temp = x;
        while(temp!=0){
            int last = temp%10;
            temp = temp/10;
            s = s + last;
        }
        String o = String.valueOf(x);
        return o.equals(s);
    }
}



class Solution {
    public boolean isPalindrome(int x) {
        if(x==0) return true;
        if(x<0) return false;
        int n = 0;
        int temp = x;
        while(temp!=0){
            int last = temp % 10;
            n = n*10 + last;
            temp = temp/10;
        }
        if(x==n){
            return true;
        }
        return false;
    }
}


//9. Palindrome Number