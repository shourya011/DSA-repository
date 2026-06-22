class MaxNumberBalloons{
    public int maxNumberOfBalloons(String text) {
        String temp = "balloon";
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<temp.length();i++){
            map.put(temp.charAt(i),0);
        }
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
        }
        int b = map.get('b');
        int a = map.get('a');
        int l = map.get('l')/2;
        int o = map.get('o')/2;
        int n = map.get('n');
        int[] arr = {b,a,l,o,n};
        int min = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
}