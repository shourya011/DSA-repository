class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        for(int i=0;i<=haystack.length()-n;i++){
            String temp = haystack.substring(i,i+n);
            if(needle.equals(temp)){
                return i;
            }
        }
        return -1;
    }
}

//28. Find the Index of the First Occurrence in a String