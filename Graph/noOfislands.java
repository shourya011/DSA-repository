class Solution {
    public int numIslands(char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        int islands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    islands++;
                    q.offer(new int[]{i,j});
                    vis[i][j] = true;
                    while(!q.isEmpty()){
                        int[] arr = q.poll();
                        int row = arr[0];
                        int col = arr[1];
                        int n = grid.length;
                        int m = grid[0].length;
                        for(int x=0;x<4;x++){
                            int nrow = row + delRow[x]; 
                            int ncol = col + delCol[x];
                            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                                char temp = grid[nrow][ncol];
                                if(!vis[nrow][ncol] && temp=='1'){
                                    vis[nrow][ncol] = true;
                                    q.offer(new int[]{nrow,ncol});
                                }
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}




class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int row,int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col] != '1'){
            return;
        }
        grid[row][col] = '0';

        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
    }
}