class Solution {
    class Pair{
        String s;
        int n;
        Pair(String s,int n){
            this.s = s;
            this.n = n;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<Pair> p = new PriorityQueue<>((a,b) -> b.n - a.n);
        for(int i=0;i<heights.length;i++){
            p.offer(new Pair(names[i],heights[i]));
        }
        int i=0;
        while(!p.isEmpty()){
            Pair temp = p.poll();
            String t1 = temp.s;
            names[i++] = t1;
        }
        return names;
    }
}



//2418. Sort the People