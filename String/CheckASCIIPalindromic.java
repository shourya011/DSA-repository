class Solution {
    public boolean isPalindromic(String s) {
        String ans = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            ans = ans + decitobi(ch);
        }
        int low = 0;
        int high = ans.length()-1;
        while(low<=high){
            if(ans.charAt(low)!=ans.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    public String decitobi(char ch){
        int n = (int)ch;
        String s = "";
        while(n!=0){
            int r = n % 2;
            s = r + s;
            n = n / 2;
        }
        while(s.length() < 8) {
            s = "0" + s;
        }
        return s;
    }
}


//4030. Check ASCII Palindromic