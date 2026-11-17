class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k){
            ArrayList<String> arr = new ArrayList<>();
            for(int i=0;i<s.length();i += k){
                if(i+k>s.length()){
                    arr.add(s.substring(i,s.length()));
                    break;
                }
                arr.add(s.substring(i,i+k));
            }
            
            ArrayList<Integer> temp = new ArrayList<>();
            int sum = 0;
            for(String ans : arr){
                sum = 0;
                for(int i=0;i<ans.length();i++){
                    sum +=  ans.charAt(i) - '0';
                }
                temp.add(sum);
            }
            String x = "";
            for(int i=0;i<temp.size();i++){
                x += temp.get(i);
            }
            s = x;
        }
        return s;
    }
}



//2243. Calculate Digit Sum of a String