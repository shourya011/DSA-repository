class nextgreaterII{
    public int[] nextGreaterElements(int[] nums) {

        //O(n^2)

        // int[] nge = new int[nums.length];
        // Arrays.fill(nge,-1);
        // int n = nums.length;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<=i+n-1;j++){
        //         int index = j % n;
        //         if(nums[index]>nums[i]){
        //             nge[i] = nums[index];
        //             break;
        //         }
        //     }
        // }
        // return nge;


        //O(n)

        int[] arr = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        for(int i=2*n-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=nums[i%n]){
                s.pop();
            }
            if(i<n){
                if(s.isEmpty()){
                    arr[i] = -1;
                }
                else{
                    arr[i] = s.peek();
                }
            }
            s.push(nums[i%n]);
        }
        return arr;
    }
}