class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        for(int i=0;i<n;i++){
            if(grid[0][i]==1 && vis[0][i]!=1){
                dfs(0,i,grid,vis);
            }
            if(grid[m-1][i]==1 && vis[m-1][i]!=1){
                dfs(m-1,i,grid,vis);
            }
        }
        for(int i=0;i<m;i++){
            if(grid[i][0]==1 && vis[i][0]!=1){
                dfs(i,0,grid,vis);
            }
            if(grid[i][n-1]==1 && vis[i][n-1]!=1){
                dfs(i,n-1,grid,vis);
            }
        }
        int c= 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    c++;
                }
            }
        }
        return c;

    }
    public void dfs(int row,int col,int[][] grid,int[][] vis){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==0 || vis[row][col]==1){
            return;
        }
        vis[row][col] = 1;
        dfs(row-1,col,grid,vis);
        dfs(row,col+1,grid,vis);
        dfs(row+1,col,grid,vis);
        dfs(row,col-1,grid,vis);
    }
}