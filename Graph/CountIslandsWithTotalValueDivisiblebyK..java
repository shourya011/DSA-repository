class Solution {
    long sum = 0;
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] vis = new int[m][n];
        for(int i=0;i<m;i++){
            long x = 0;
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]!=0){
                    sum = 0;
                    x = dfs(grid,vis,i,j,m,n);
                    if(x%k==0) count++;
                }
            }
        }
        return count;
    }
    public long dfs(int[][] grid,int[][] vis,int nrow,int ncol,int m,int n){
        if(nrow<0 || nrow>=m || ncol<0 || ncol>=n || grid[nrow][ncol]==0 || vis[nrow][ncol]==1){
            return sum;
        }
        vis[nrow][ncol] = 1;
        sum += grid[nrow][ncol];
        dfs(grid,vis,nrow,ncol+1,m,n);
        dfs(grid,vis,nrow+1,ncol,m,n);
        dfs(grid,vis,nrow,ncol-1,m,n);
        dfs(grid,vis,nrow-1,ncol,m,n);
        return sum;
    }
}

//3619. Count Islands With Total Value Divisible by K