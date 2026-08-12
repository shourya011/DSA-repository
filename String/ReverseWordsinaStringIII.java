class Solution {
    public String reverseWords(String s) {
        ArrayList<String> list = new ArrayList<>();
        String temp = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                list.add(temp);
                temp = "";
            }
            else
                temp = s.charAt(i)+ temp ;
        }
        list.add(temp);
        String ans = "";
        for(int i=0;i<list.size();i++){
            ans = ans + list.get(i);
            if(i<list.size()-1)
                ans += " ";
        }
        return ans;
    }
}



//557. Reverse Words in a String III
