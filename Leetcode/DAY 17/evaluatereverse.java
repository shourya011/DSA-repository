class evaluatereverse{
    public int evalRPN(String[] tokens) {
        Stack<Integer> ans = new Stack<>();
        int sum = 0;
        for(int i=0;i<tokens.length;i++){
            String token = tokens[i];
            if(token.equals("+")
            || token.equals("-")
            || token.equals("*")
            || token.equals("/")){
                int t2 = ans.pop();
                int t1 = ans.pop();
                if(token.equals("+")){
                    sum = t1 + t2;
                }
                else if(token.equals("-")){
                    sum = t1- t2;
                }
                else if(token.equals("*")){
                    sum = t1 * t2;
                }
                else if(token.equals("/")){
                    sum = t1 / t2;
                }
                ans.push(sum);
            }
            else{
                ans.push(Integer.parseInt(token));
            }
        }
        return ans.pop();
    }
}