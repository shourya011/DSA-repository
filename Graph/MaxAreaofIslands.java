class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count = 0;
                if(grid[i][j]==1 && !vis[i][j]){
                    q.offer(new int[]{i,j});
                    vis[i][j] = true;
                    count++;
                    while(!q.isEmpty()){
                        int[] temp = q.poll();
                        int r = temp[0];
                        int c = temp[1];
                        for(int x=0;x<4;x++){
                            int nrow = r + drow[x];
                            int ncol = c + dcol[x];
                            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==false && grid[nrow][ncol]==1){
                                count++;
                                q.offer(new int[]{nrow,ncol});
                                vis[nrow][ncol] = true;
                            }
                        }
                    }
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }
}