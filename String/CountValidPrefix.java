class Solution {
    public int countValidPrefixes(String s) {
        List<String> list = new ArrayList<>();
        for(int i=1;i<=s.length();i++){
            list.add(s.substring(0,i));
        }
        int ans = 0;
        for(int i=0;i<list.size();i++){
            int n = one(list.get(i));
            int m = zero(list.get(i));
            if(Math.abs(m-n)<=1){
                ans++;
            }
        }
        return ans;
    }
    public int one(String s){
        int c = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                c++;
            }
        }
        return c;
    }
    public int zero(String s){
        int c = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                c++;
            }
        }
        return c;
    }
}

//4006. Count Valid Prefixes