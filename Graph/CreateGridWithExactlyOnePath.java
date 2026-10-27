class Solution {
    public String[] createGrid(int m, int n) {
        char[][] temp = new char[m][n];
        int[][] vis = new int[m][n];
        dfs(temp,vis,m,n,0,0);
        String[] arr = new String[m];
        int index = 0;
        for(int i=0;i<temp.length;i++){
            String ans = "";
            for(int j=0;j<temp[0].length;j++){
                if(vis[i][j]==0){
                    ans += '#';
                }
                else{
                    ans += temp[i][j];
                }
            }
            arr[index++] = ans;
        }
        return arr;
    }
    public void dfs(char[][] ch,int[][] vis,int m,int n,int nrow,int ncol){
        if(nrow<0 || nrow>=m || ncol<0 || ncol>=n || vis[nrow][ncol]==1 || vis[m-1][n-1] == 1) return;
        vis[nrow][ncol] = 1;
        ch[nrow][ncol] = '.';
        dfs(ch,vis,m,n,nrow,ncol+1);
        dfs(ch,vis,m,n,nrow+1,ncol);
    }
}


//3963. Create Grid With Exactly One Path