class Solution {
    class Pair{
        int row;
        int col;
        int dis;
        Pair(int row,int col,int dis){
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }
        if(m==1 && n==1 && grid[0][0]==0){
            return 1;
        }
        boolean[][] vis = new boolean[m][n];
        int[] drow = {-1,-1,-1,0,1,1,1,0};
        int[] dcol = {-1,0,1,1,1,0,-1,-1};
        q.offer(new Pair(0,0,1));
        vis[0][0] = true;
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int r = temp.row;
            int c = temp.col;
            int d = temp.dis;
            for(int i=0;i<8;i++){
                int nrow = r + drow[i];
                int ncol=  c + dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==0 && !vis[nrow][ncol]){
                    if(nrow==n-1 && ncol==n-1){
                        return d+1;
                    }
                    q.offer(new Pair(nrow,ncol,d+1));
                    vis[nrow][ncol] = true;
                }
            }
        }
        return -1;
    }
}