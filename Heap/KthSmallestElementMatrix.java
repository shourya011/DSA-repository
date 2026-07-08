class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                q.offer(matrix[i][j]);
                if(q.size()>k){
                    q.poll();
                }
            }
        }
        return q.peek();
    }
}



class Solution {
    class Pair{
        int r;
        int c;
        int val;
        public Pair(int r,int c,int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)-> a.val - b.val);
        for(int i=0;i<matrix.length;i++) {
                int a = matrix[i][0];
                Pair p = new Pair(i,0,a);
                q.offer(p);
        }
        int count = 0;
        while(!q.isEmpty()) {
            Pair s = q.poll();
            count++;
            if(count==k) {
                return s.val;
            }
            else {
            if(s.c + 1 < matrix[0].length) {
            int v = matrix[s.r][s.c+1];
            Pair b = new Pair(s.r,s.c+1,v);
            q.offer(b);
                }
            }
        }
        return -1;  
    }
}