class Solution {
    public String reverseVowels(String s) {
        char[] arr = new char[s.length()];
        for(int i=0;i<arr.length;i++){
            arr[i] = s.charAt(i);
        }
        int l = 0;
        int h = s.length()-1;
        while(l<=h){
            if(!(s.charAt(l)=='a' || s.charAt(l)=='A' || s.charAt(l)=='e' || s.charAt(l)=='E' || s.charAt(l)=='i' || s.charAt(l)=='I' || s.charAt(l)=='o' || s.charAt(l)=='O' || s.charAt(l)=='u' || s.charAt(l)=='U')){
                l++;
            }
            else if(!(s.charAt(h)=='a' || s.charAt(h)=='A' || s.charAt(h)=='e' || s.charAt(h)=='E' || s.charAt(h)=='i' || s.charAt(h)=='I' || s.charAt(h)=='o' || s.charAt(h)=='O' || s.charAt(h)=='u' || s.charAt(h)=='U')){
                h--;
            }
            else{
                char ch = arr[l];
                arr[l] = arr[h];
                arr[h] = ch;
                l++;
                h--;
            }
        }
        String ans = "";
        for(int i=0;i<arr.length;i++){
            ans = ans + arr[i];
        }
        return ans;
    }
}

//345