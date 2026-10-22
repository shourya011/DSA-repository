class Solution {
    int[] prev = new int[2];
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] temp = new int[m][n];
        prev = new int[]{0,0};
        return dfs(0,0,grid,temp,m,n);
    }
    public int[] dfs(int nrow,int ncol,char[][] grid,int[][] temp,int m,int n){
        if(nrow>=m || nrow<0 || ncol>=n || ncol<0 || temp[nrow][ncol]==1) return prev;
        prev = new int[]{nrow, ncol}; 
        temp[nrow][ncol] = 1;
        if(grid[nrow][ncol]=='R'){
            return dfs(nrow,ncol+1,grid,temp,m,n);
        }
        else if(grid[nrow][ncol]=='L'){
            return dfs(nrow,ncol-1,grid,temp,m,n);
        }
        else if(grid[nrow][ncol]=='U'){
            return dfs(nrow-1,ncol,grid,temp,m,n);
        }
        else if(grid[nrow][ncol]=='D'){
            return dfs(nrow+1,ncol,grid,temp,m,n);
        }
        return prev;
    }
}


//4084. Last Visited Cell in a Directional Grid