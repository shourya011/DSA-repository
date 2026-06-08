import java.util.*;
class happynumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
            while(!(set.contains(1))){
                int sum = 0;
                while(n!=0){
                    int last = n % 10;
                    n = n/10;
                    sum = sum + last*last;
                }
                if(set.contains(sum)){
                    return false;
                }
                set.add(sum);
                n = sum; 
            }
        return true;
    }
}