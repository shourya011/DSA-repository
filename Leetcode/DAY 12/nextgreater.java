class nextgreater{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] nge = new int[nums1.length];
        int[] temp = new int[nums2.length];
        Arrays.fill(nge,-1);
        Arrays.fill(temp,-1);
        int index = 0;
        for(int i=0;i<nums2.length;i++){
            for(int j=i+1;j<nums2.length;j++){
                if(nums2[j]>nums2[i]){
                    temp[i] = nums2[j];
                    break; 
                }
            }
        }
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    nge[i] = temp[j];
                    break;
                }
            }
        }
        return nge;



        //O(N)
        // Stack<Integer> s = new Stack<>();
        // HashMap<Integer,Integer> map = new HashMap<>();
        // int[] arr = new int[nums1.length];
        // for(int i=nums2.length-1;i>=0;i--){
        //     while(!(s.isEmpty()) && s.peek()<=nums2[i]){
        //         s.pop();
        //     }
        //     if(s.isEmpty()){
        //         s.push(nums2[i]);
        //         map.put(nums2[i],-1);
        //     }
        //     else{
        //         map.put(nums2[i],s.peek());
        //         s.push(nums2[i]);
        //     }
        // }
        // for(int i=0;i<nums1.length;i++){
        //     int val = map.get(nums1[i]);
        //     arr[i] = val;
        // }
        // return arr;
    }
}