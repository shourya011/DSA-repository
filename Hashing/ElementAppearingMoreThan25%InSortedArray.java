class Solution {
    public int findSpecialInteger(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]))
                map.put(arr[i],map.get(arr[i])+1);
            else
                map.put(arr[i],1);
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue()>arr.length/4){
                return e.getKey();
            }
        }
        return -1;
    }
}

//1287. Element Appearing More Than 25% In Sorted Array