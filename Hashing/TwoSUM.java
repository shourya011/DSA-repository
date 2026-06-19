import java.util.*;
import java.util.Scanner;
class TwoSUM{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int nums[] = {3,2,3};
        int target = 6;
        System.out.println(Arrays.toString(sum(nums, target)));
        sc.close();
    }
    public static int[] sum(int[] nums,int target){


        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j]==target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[]{};



        // for(int i=0;i<nums.length;i++){
        //     int dif = target - nums[i];
        //     for(int j=i+1;j<nums.length;j++){   
        //         if(dif==nums[j]){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[]{};


        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int num = target - nums[i];
            if(map.containsKey(num)){
                int j = map.get(num);
                if(i==j){
                    continue;
                }
                return new int[]{i,j};
            }

        }
        return new int[]{};





    }
}