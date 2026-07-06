class Solution {
    class Pair{
        Character s;
        int freq;

        public Pair(Character s,int freq){
            this.s = s;
            this.freq = freq;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        for(int i=0;i<tasks.length;i++){
            if(map.containsKey(tasks[i])){
                map.put(tasks[i],map.get(tasks[i])+1);
            }
            else
                map.put(tasks[i],1);
        }
        for(Map.Entry<Character,Integer> e: map.entrySet()){
            q.offer(new Pair(e.getKey(),e.getValue()));
        }
        int cycle = n+1;
        ArrayList<Pair> temp = new ArrayList<>();
        int interval = 0;
        while (!q.isEmpty()) {
            int work = 0;
            temp.clear();
            for (int i = 0; i < cycle && !q.isEmpty(); i++) {
                Pair p = q.poll();
                interval++;
                work++;
                p.freq--;
                if (p.freq > 0) {
                    temp.add(p);
                }
            }
            for (Pair p : temp) {
                q.offer(p);
            }
            if (!q.isEmpty()) {
                interval += cycle - work;
            }
        }
        return interval;
    }
}