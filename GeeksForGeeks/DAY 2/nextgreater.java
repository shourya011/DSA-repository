class nextgreater{
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int[] nums = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!(s.isEmpty()) && s.peek()<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                s.push(arr[i]);
                nums[i] = -1;
                continue;
            }
            else{
                nums[i] = s.peek();
                s.push(arr[i]);
            }
        }
        for(int i=0;i<nums.length;i++){
            ans.add(nums[i]);
        }
        return ans;
    }
}