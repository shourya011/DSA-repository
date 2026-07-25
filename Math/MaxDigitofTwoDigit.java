class Solution {
    public int maxProduct(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int temp = n;
        while(temp!=0){
            list.add(temp%10);
            temp = temp/10;
        }
        ArrayList<Integer> p = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                int prod = list.get(i) * list.get(j);
                p.add(prod);
            }
        }
        return Collections.max(p);
    }
}




class Solution {
    public int maxProduct(int n) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b - a);
        int temp = n;
        while(temp!=0){
            q.offer(temp%10);
            temp = temp/10;
        }
        return q.poll() * q.poll();
    }
}

//3536