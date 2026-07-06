class TopKWords {
    class Pair{
        String s;
        int freq;

        public Pair(String s,int freq){
            this.s = s;
            this.freq = freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> {
                                    if (a.freq == b.freq) {
                                        return a.s.compareTo(b.s);
                                    }
                                return b.freq - a.freq;});
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }
            else
                map.put(words[i],1);
        }
        for(Map.Entry<String,Integer> e: map.entrySet()){
            q.offer(new Pair(e.getKey(),e.getValue()));
        }
        List<String> list = new ArrayList<>();
        int i=0;
        while(!q.isEmpty() && i<k){
            Pair p = q.poll();
            list.add(p.s);
            i++;

        }
        return list;
    }
}