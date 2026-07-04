class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            q.offer(stones[i]);
        }
        while(q.size()>1){
            int t1 = q.poll();
            int t2 = q.poll();

            if(t1 != t2){
                q.offer(t1 - t2);
            }
        }
        if(q.isEmpty()){
            return 0;
        }
        return q.poll();
    }
}