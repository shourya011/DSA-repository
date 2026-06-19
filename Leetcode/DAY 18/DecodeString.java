class DecodeString{
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        Stack<Integer> n = new Stack<>();
        String ans = "";
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                n.push(num);
                i--;
            }
            else if(s.charAt(i)!=']'){
                st.push(String.valueOf(s.charAt(i)));
            }
            else{
                String Substr = "";
                while(!st.isEmpty() && !st.peek().equals("[")){
                    Substr = st.pop() + Substr;
                }
                st.pop();
                int value = n.pop();
                StringBuilder temp = new StringBuilder();
                for(int j=0;j<value;j++){
                    temp.append(Substr);
                }
                st.push(temp.toString());
            }
        }
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        return ans;
    }
}