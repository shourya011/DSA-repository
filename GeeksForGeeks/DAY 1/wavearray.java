class wavearray{
    public void sortInWave(int arr[]) {
        // code here
        int f = 0;
        int s = 1;
        while(s<arr.length && f<arr.length){
            int temp = arr[f];
            arr[f] = arr[s];
            arr[s] = temp;
            if(s<arr.length && f<arr.length){
                s = s+2;
                f = f+2;
            }
        }
    }
}