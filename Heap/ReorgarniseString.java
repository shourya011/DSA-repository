class ReorganizeString {
    class Pair{
        char ch;
        int freq;

        public Pair(char ch,int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            }
            else
                map.put(s.charAt(i),1);
        }
        for(Map.Entry<Character,Integer> e: map.entrySet()){
            q.offer(new Pair(e.getKey(), e.getValue()));
        }
        StringBuilder ans = new StringBuilder();
        Pair prev = null;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            ans.append(curr.ch);
            curr.freq--;
            if (prev != null && prev.freq > 0) {
                q.offer(prev);
            }
            prev = curr;
        }
        if (prev != null && prev.freq > 0) {
            return "";
        }
        return ans.toString();

    }
}