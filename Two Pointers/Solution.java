import java.util.*;
public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String temp = "";
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>=97 && s.charAt(i)<=122) ||(s.charAt(i)>=48 && s.charAt(i)<=57)){
                temp += s.charAt(i);
            }
        }
        int left = 0,right = temp.length()-1;
        while(left<=right){
            if(temp.charAt(left)!=temp.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
} {
    
}
