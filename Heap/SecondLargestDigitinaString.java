class Solution {
    public int secondHighest(String s) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch) && !q.contains(ch - '0')){
                q.offer(ch - '0');
            }
            if(q.size()>2){
                q.poll();
            }
        }
        if(q.size()<2) return -1;
        return q.poll();
    }
}

//1796. Second Largest Digit in a String