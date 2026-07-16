class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];
        for(int i=0;i<n;i++){
            if(!p[0][i]){
                dfs(heights,0,i,m,n,p,heights[0][i]);
            }
            if(!a[m-1][i]){
                dfs(heights,m-1,i,m,n,a,heights[m-1][i]);
            }
        }
        for(int j=0;j<m;j++){
            if(!p[j][0]){
                dfs(heights,j,0,m,n,p,heights[j][0]);
            }
            if(!a[j][n-1]){
                dfs(heights,j,n-1,m,n,a,heights[j][n-1]);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(p[i][j] && a[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }
        return result;
    }
    public void dfs(int[][] heights,int row,int col,int m,int n,boolean[][] check,int preval){
        if(row<0 || row>=m || col<0 || col>=n || check[row][col] || preval>heights[row][col]){
            return;
        }
        check[row][col]= true;
        dfs(heights,row-1,col,m,n,check,heights[row][col]);
        dfs(heights,row,col+1,m,n,check,heights[row][col]);
        dfs(heights,row+1,col,m,n,check,heights[row][col]);
        dfs(heights,row,col-1,m,n,check,heights[row][col]);

    }
}