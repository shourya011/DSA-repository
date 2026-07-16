class Solution {
    public String mergeAlternately(String word1, String word2) {
        String ans = "";
        int t1 = 0,t2 = 0;
        while(t1<word1.length() && t2<word2.length()){
            ans += word1.charAt(t1);
            ans += word2.charAt(t2);
            t1++;
            t2++;
        }
        while(t1<word1.length()){
            ans += word1.charAt(t1++);
        }
        while(t2<word2.length()){
            ans += word2.charAt(t2++);
        }
        return ans;
    }
}