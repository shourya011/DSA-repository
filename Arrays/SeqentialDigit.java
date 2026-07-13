class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        String s = "123456789";
        int minLen = count(low);
        int maxLen = count(high);
        for(int len = minLen;len<=maxLen;len++){
            for(int start=0;start<=9-len;start++){
                String num = s.substring(start,start+len);
                int x = Integer.parseInt(num);
                if (x >= low && x <= high) {
                    list.add(x);
                }
            }
        }
        return list;
    }
    public int count(int num){
        int c = 0;
        while(num!=0){
            num=num/10;
            c++;
        }
        return c;

    }
}


//1291