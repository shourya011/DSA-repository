class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<nums.size();i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=i;j<nums.size();j++){
                temp.add(nums.get(j));
                list.add(new ArrayList<>(temp));
            }
        }

        for(ArrayList<Integer> arr : list){
            HashSet<Integer> set = new HashSet<>();
            for(int t : arr){
                set.add(t);
            }
            ans += (set.size()*set.size());
        }
        return ans;
    }
}



//2913. Subarrays Distinct Element Sum of Squares I