class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            String temp = s.substring(1,s.length());
            char ans = s.charAt(0);
            String f = temp + ans;
            s = f;
            if(goal.equals(s)){
                return true;
            }
        }
        return false;
    }
}