class Solution {
    public String rearrangeString(String s, char x, char y) {
        char[] arr = new char[s.length()];
        for(int i=0;i<arr.length;i++){
            arr[i] = s.charAt(i);
        }
        if(!(s.contains(String.valueOf(x)))){
            return s;
        }
        if(!(s.contains(String.valueOf(y)))){
            return s;
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==y){
                ans.append(arr[i]);
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                ans.append(arr[i]);
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=x && arr[i]!=y){
                ans.append(arr[i]);
            }
        }
        return ans.toString();
    }
}