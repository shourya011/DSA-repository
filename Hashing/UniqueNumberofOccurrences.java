class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }
            else{
                map.put(arr[i],1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            list.add(e.getValue());
        }
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).equals(list.get(j))){
                    return false;
                }
            }
        }
        return true;
    }
}


//1207. Unique Number of Occurrences
