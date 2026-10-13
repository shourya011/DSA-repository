class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> nums = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>=max){
                max = arr[i];
                if(arr[i]==max){
                    nums.add(arr[i]);
                }
            }
        }
        Collections.reverse(nums);
        return nums;
    }
}



//https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1