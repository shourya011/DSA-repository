class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int i = 0;
        int max = 0;
        while(right!=s.length()){
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max = Math.max(max,set.size());
            right++;
        }
        return max;
    }
}




//3. Longest Substring Without Repeating Characters