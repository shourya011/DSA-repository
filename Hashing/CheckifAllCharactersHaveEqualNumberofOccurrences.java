class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch) + 1);
            }
            else{
                map.put(ch,1);
            }
        }
        int i = map.get(s.charAt(0));
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            if(i != e.getValue()){
                return false;
            }
        }
        return true;
    }
}

//1941. Check if All Characters Have Equal Number of Occurrences