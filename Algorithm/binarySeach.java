class binarySearch{
    public boolean binarySearch(int[] arr, int k) {
        // code here
        int f = 0,l = arr.length-1;
        int mid = 0;
        while(f<=l){
            mid =  f+(l-f)/2;
            if(arr[mid]>k){
                l = mid-1;
            }
            if(arr[mid]<k){
                f = mid + 1;
            }
            if(arr[mid]==k){
                return true;
            }
        }
        return false;
    }
}