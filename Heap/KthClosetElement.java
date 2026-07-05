// class KthClosetElement{
//     class Pair{
//         int val;
//         int distance;
//         Pair(int val,int distance){
//             this.val = val;
//             this.distance = distance;
//         }
//     }
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         List<Pair> list = new ArrayList<>();
//         List<Integer> tem = new ArrayList<>();
//         for(int i=0;i<arr.length;i++){
//             int temp = Math.abs(arr[i] - x);
//             list.add(new Pair(arr[i],temp));
//         }
//         Collections.sort(list, (a, b) -> {
//         if (a.distance == b.distance)
//             return a.val - b.val;
//         return a.distance - b.distance;
//         });
//         for(int i=0;i<k;i++){
//             tem.add(list.get(i).val);
//         }
//         Collections.sort(tem);
//         return tem;
//     }
// }





class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int l = 0,r = arr.length-1;
        while(k<r-l+1){
            if(Math.abs(arr[l] - x)<Math.abs(arr[r] - x)){
                r--;
            }
            else if(Math.abs(arr[l] - x)>Math.abs(arr[r] - x)){
                l++;
            }
            else{
                if(arr[r]>arr[l]){
                    r--;
                }
                else{
                    l++;
                }
                
            }
        }
        for(int i=l;i<=r;i++){
            list.add(arr[i]);
        }
        return list;
    }
}