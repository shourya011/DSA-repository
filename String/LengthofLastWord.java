class Solution {
    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        String temp = arr[arr.length-1];
        return temp.length() ;
    }
}


//58. Length of Last Word