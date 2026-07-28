class Solution {
    public boolean checkIfPangram(String sentence) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=97;i<=122;i++){
            map.put((char)i,1);
        }
        for(int i=0;i<sentence.length();i++){
            map.put(sentence.charAt(i),map.get(sentence.charAt(i))+1);
        }
        for(Map.Entry<Character,Integer> e: map.entrySet()){
            if(e.getValue()==1){
                return false;
            }
        }
        return true;
    }
}

//1832. Check if the Sentence Is Pangram