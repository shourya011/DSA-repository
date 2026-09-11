class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        boolean check = true;
        for(int i=0;i<arr1.length;i++){
            check = true;
            for(int j=0;j<arr2.length;j++){
                int diff = Math.abs(arr1[i] - arr2[j]);
                if(diff<=d){
                    check = false;
                    break;
                }
                else{
                    check = true;
                }
            }
            if(check){
                count++;
            }
        }
        return count;
    }
}

//1385. Find the Distance Value Between Two Arrays