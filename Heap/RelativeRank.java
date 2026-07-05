class RelativeRank {
    class Pair{
        int score;
        int index;

        Pair(int score, int index) {
        this.score = score;
        this.index = index;
    }
    }
    public String[] findRelativeRanks(int[] score) {
        String[] s = new String[score.length];
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> b.score - a.score); //maxheap
        int rank = 1;
        for(int i=0;i<score.length;i++){
            q.offer(new Pair(score[i],i));
        }
        while(!q.isEmpty()){
            Pair p = q.poll();
            String temp = "";
            if(rank==1){
                temp = "Gold Medal";
            }
            else if(rank==2){
                temp = "Silver Medal";
            }
            else if(rank==3){
                temp = "Bronze Medal";
            }
            else{
                temp = String.valueOf(rank);;
            }
            s[p.index] = temp;
            rank++;
        }
        return s;
    }

}