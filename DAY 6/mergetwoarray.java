class mergetwoarray{


    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     int j=0;
    //     for(int i=m;i<m+n;i++){
    //         nums1[i] = nums2[j];
    //         j++;
    //     }
    //     for(int i=0;i<nums1.length;i++){
    //         for(int k=i+1;k<nums1.length;k++){
    //             if(nums1[i]>nums1[k]){
    //                 int temp = nums1[i];
    //                 nums1[i] = nums1[k];
    //                 nums1[k] = temp;
    //             }
    //         }
    //     }
    
    class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int index = m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[index--] = nums1[i];
                i--; 
            }
            else {
                nums1[index--] = nums2[j];
                j--;
            }
        }
        while(j>=0){
            nums1[index--] = nums2[j];
            j--;
        }
    }




}