class Solution {
    class Pair{
        int row;
        int col;
        int dis;
        public Pair(int row,int col,int dis){
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }
    public int maxDistance(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        int landCount = 0;       //initialize
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    landCount++;        //checking if all are lands or not
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }
        int maxDis = 0;         //change
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int d = p.dis;
            maxDis = Math.max(maxDis,d);        //checking
            for(int i=0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==0 && vis[nrow][ncol]==0){
                    q.offer(new Pair(nrow,ncol,d+1));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        if(landCount==0 || landCount==m*n){
            return -1;
        }
        return maxDis;
    }
}