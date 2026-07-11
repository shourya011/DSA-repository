class Solution {
    class Pair{
        int row;
        int col;
        int time;
        Pair(int row,int col,int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int cFresh = 0;
        for(int i=0;i<m;i++){       // all the rotten will go in queue
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }
                if(grid[i][j]==1) cFresh++;
            }

        }

        int tm = 0;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        int count = 0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int t = curr.time;
            tm = Math.max(tm,t);
            for(int i=0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.offer(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol] = 2;
                    count++;
                }
            }
        }

        if(cFresh!=count) return -1;
        return tm;
    }
}