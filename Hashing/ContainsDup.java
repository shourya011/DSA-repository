import java.util.*;

public class ContainsDup {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nums[] = {1,2,3,1};
        System.out.println(containNumber(nums));


    }
    public static boolean containNumber(int[] nums){
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]==nums[j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;


        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     if(map.containsKey(nums[i])){
        //         return true;
        //     }
        //     map.put(nums[i],i);
        // }
        // return false;



    //     HashSet<Integer> set = new HashSet<>();
    //    for(int i=0;i<nums.length;i++){
    //         set.add(nums[i]);
    //    }
    //    if(nums.length!=set.size()){
    //     return true;
    //    } 
    //    return false;


    




    }    
}
