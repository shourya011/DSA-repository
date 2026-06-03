import java.util.*;

public class ContainsDup {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nums[] = {1,2,3,4};
        System.out.println(containNumber(nums));


    }
    public static boolean containNumber(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }    
}
