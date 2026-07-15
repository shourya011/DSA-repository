class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        for(int i=0;i<m;i++){
            if(grid[i][0]==0 && vis[i][0]==0){
                dfs(i,0,m,n,grid,vis);
            }
            if(grid[i][n-1]==0 && vis[i][n-1]==0){
                dfs(i,n-1,m,n,grid,vis);
            }
        }
        for(int j=0;j<n;j++){
            if(grid[0][j]==0 && vis[0][j]==0){
                dfs(0,j,m,n,grid,vis);
            }
            if(grid[m-1][j]==0 && vis[m-1][j]==0){
                dfs(m-1,j,m,n,grid,vis);
            }
        }
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 && vis[i][j]==0){
                    count++;
                    dfs(i,j,m,n,grid,vis);
                }
            }
        }
        return count;
    }
    public void dfs(int row,int col,int m,int n,int[][] grid,int[][] vis){
        if(row<0 || row>=m || col<0 || col>=n || grid[row][col]==1 || vis[row][col]==1){
            return;
        }
        vis[row][col] = 1;
        dfs(row-1,col,m,n,grid,vis);
        dfs(row,col+1,m,n,grid,vis);
        dfs(row+1,col,m,n,grid,vis);
        dfs(row,col-1,m,n,grid,vis);
    }
}