class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<3){
            return false;
        }
        int f = 0;
        int s = 1;
        int t = 2;
        while(t<arr.length){
            if(arr[f]%2!=0 && arr[s]%2!=0 && arr[t]%2!=0){
                return true;
            }
            f++;
            s++;
            t++;
        }
        return false;
    }
}


//1550. Three Consecutive Odds