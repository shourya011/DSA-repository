class Solution {
    public int largestInteger(int n, int s) {
        int[] arr = new int[n];
        if(s>9*n){
            return -1;
        }
        if(s==0){
            return 0;
        }
        for(int i=0;i<arr.length;i++){
            if(s>=9){
                arr[i] = 9;
                s = Math.abs(9 - s);
            }
            else{
                arr[i] = s;
                s = Math.abs(s - s);
            }
        }
        
        String ans = "";
        for(int i=0;i<arr.length;i++){
            ans = ans + arr[i];
        }
        int nx = Integer.parseInt(ans);
        return nx;
    }
}