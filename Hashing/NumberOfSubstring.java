class NumberOfSubstring{
    public int numOfStrings(String[] patterns, String word) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<word.length();i++){
            for(int j=i+1;j<=word.length();j++){
                map.put(word.substring(i,j),1);
            }
        }
        int c = 0;
        for(int i=0;i<patterns.length;i++){
            String t = patterns[i];
            if(map.containsKey(t)){
                c++;
            }
        }
        return c;
    }
}