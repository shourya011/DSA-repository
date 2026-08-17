class Solution {
    class Pair{
        int i;
        int dis;
        Pair(int i,int dis){
            this.i = i;
            this.dis = dis;
        }
    }
    public int nearestDrone(int[][] drones, int[] target) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.dis - b.dis);
        for(int i=0;i<drones.length;i++){
            int xi = drones[i][0];
            int yi = drones[i][1];
            int range = drones[i][2];
            int md  = Math.abs(xi - target[0]) + Math.abs(yi-target[1]);
            if(md<=range)
                q.offer(new Pair(i,md));
        }
        if(q.size()<1){
            return -1;
        }
        Pair p = q.poll();
        return p.i;
    }
}


//4024. Nearest Available Drone