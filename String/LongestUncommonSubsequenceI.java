class Solution {
    public int findLUSlength(String a, String b) {
        if(a.length()!=b.length()){
            return Math.max(a.length(),b.length());
        }
        if(a.equals(b)){
            return -1;
        }
        return a.length();
    }
}


//521. Longest Uncommon Subsequence I