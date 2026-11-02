class Solution {
    public void rotateMatrix(int[][] mat) {
        // code here
        int n = mat.length;
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = mat[i].clone();
        }
        int colm = arr[0].length-1;
        for(int i=0;i<arr.length;i++){  
            int srow = 0;
            for(int j=0;j<arr[0].length;j++){
                mat[i][j] = arr[srow][colm];
                srow++;
            }
            colm--;
        }
        
    }
}


//https://www.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1