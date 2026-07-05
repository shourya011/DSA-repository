class SortCharacterByFreq {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> q = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());  //maxheap by freq
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i)) +1);
            }
            else
                map.put(s.charAt(i),1);
        }
        for(Map.Entry<Character,Integer> e: map.entrySet()){
            q.offer(e);
        }
        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()) {
            Map.Entry<Character, Integer> e = q.poll();
            int n = e.getValue();

            for (int i = 0; i < n; i++) {
                ans.append(e.getKey());
            }
        }
        return ans.toString();
        
    }
}