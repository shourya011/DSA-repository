class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a,b) -> b - a);
        PriorityQueue<Integer> d = new PriorityQueue<>((a,b) -> b - a);
        for(int i=0;i<prices.length;i++){
            p.offer(prices[i]);
        }
        for(int i=0;i<discounts.length;i++){
            d.offer(discounts[i]);
        }
        double sum = 0;
        while(!d.isEmpty() && !p.isEmpty()){
            double t1 = (double)p.poll();
            double t2 = (double)d.poll();
            sum += t1 * (100 - t2)/100;
        }
        while(!p.isEmpty()){
            sum += (double)p.poll();
        }
        return sum;
    }
}


//4014. Minimum Total Price After Applying Discounts