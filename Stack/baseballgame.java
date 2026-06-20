class baseballgame{
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<operations.length;i++){
            String str = operations[i];
            if(!s.isEmpty() && str.equals("+")){
                int t2 = s.pop();
                if(s.isEmpty()){continue;}
                int t1 = s.peek();
                s.push(t2);
                s.push(t1 + t2);
            }
            else if(!s.isEmpty() && str.equals("D")){
                s.push(2 * s.peek());
            }
            else if(!s.isEmpty() && str.equals("C")){
                s.pop();
            }
            else{
                s.push(Integer.parseInt(str));
            }
        }
        int sum = 0;
        while(!s.isEmpty()){
            sum += s.pop();
        }
        return sum;
    }
}