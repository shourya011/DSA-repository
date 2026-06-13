class temperature{
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] arr = new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--){
            while(!(s.isEmpty()) && temperatures[i]>=temperatures[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                s.push(i);
                arr[i] = 0;
            }
            else{
                arr[i] = s.peek() - i;
                s.push(i);
            }
        }
        return arr;
    }
}