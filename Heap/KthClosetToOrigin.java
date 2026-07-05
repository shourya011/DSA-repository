class KthClosetToOrigin {
    class Pair{
        int x;
        int y;
        int dist;
        Pair(int x,int y,int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> b.dist - a.dist);  //max heap
        int[][] arr = new int[k][2];
        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];
            int distance = x * x + y*y;
            q.offer(new Pair(x,y,distance));
            if(q.size()>k){
                q.poll();
            }
        }
        for(int i=0;i<k;i++){
            Pair p = q.poll();
            arr[i][0] = p.x;
            arr[i][1] = p.y;
        }   
        return arr;
    }
}