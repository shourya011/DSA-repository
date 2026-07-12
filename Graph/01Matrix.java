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
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] vis = new int[m][n];
        int[][] ans = new int[m][n];
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0 && vis[i][j]==0){
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int d = p.dis;
            for(int i=0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && mat[nrow][ncol]==1 && vis[nrow][ncol]==0){
                    q.offer(new Pair(nrow,ncol,d+1));
                    vis[nrow][ncol] = 1;
                    ans[nrow][ncol] = d+1;
                }
            }
        }
        return ans;
    }
}