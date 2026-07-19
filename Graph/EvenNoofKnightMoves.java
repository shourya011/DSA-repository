class Solution {
    public boolean canReach(int[] start, int[] target) {
        if(start[0]==target[0] && start[1]==target[1]){
            return true;
        }
        int m = 8;
        int n = 8;
        int[][] chess = new int[8][8];
        return dfs(chess,start[0],start[1],target,0,m,n);
    }
    public boolean dfs(int[][] chess,int row,int col,int[] target,int step,int m,int n){
        if(row<0 || row>=m || col<0 || col>=n || chess[row][col]==1){
            return false;
        }
        if(row==target[0] && col==target[1]){
            return step%2==0;
        }
        chess[row][col] = 1;
        if(dfs(chess,row-2,col-1,target,step+1,m,n)) return true;
        if(dfs(chess,row-2,col+1,target,step+1,m,n)) return true;
        if(dfs(chess,row-1,col+2,target,step+1,m,n)) return true;
        if(dfs(chess,row+1,col+2,target,step+1,m,n)) return true;
        if(dfs(chess,row+2,col+1,target,step+1,m,n)) return true;
        if(dfs(chess,row+2,col-1,target,step+1,m,n)) return true;
        if(dfs(chess,row+1,col-2,target,step+1,m,n)) return true;
        if(dfs(chess,row-1,col-2,target,step+1,m,n)) return true;
        return false;
    }
}