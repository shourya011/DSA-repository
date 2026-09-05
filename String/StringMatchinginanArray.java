class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            String s = words[i];
            for(int j=0;j<words.length;j++){
                String ss = words[j];
                if(s.contains(ss) && s.length()>ss.length() && !ans.contains(ss)){
                    ans.add(ss);
                }
            }
        }
        return ans;
    }
}



//1408. String Matching in an Array
