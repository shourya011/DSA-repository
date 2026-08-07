// class Solution {
//     public char findTheDifference(String s, String t) {
//         HashMap<Character,Integer> map = new HashMap<>();
//         for(int i=0;i<s.length();i++){
//             if(map.containsKey(s.charAt(i))){
//                 map.put(s.charAt(i),map.get(s.charAt(i))+1);
//             }
//             else
//                 map.put(s.charAt(i),1);
//         }
//         for(int i=0;i<t.length();i++){
//             if(!map.containsKey(t.charAt(i))){
//                 return t.charAt(i);
//             }
//             map.put(t.charAt(i),map.get(t.charAt(i))-1);
//             int n = map.get(t.charAt(i));
//             if(n==0){
//                 map.remove(t.charAt(i));
//             }
//         }
//         char ch = 'a';
//         return ch;
//     }
// }


class Solution {
    public char findTheDifference(String s, String t) {
        String ans = s + t;
        int xor = 0;
        for(int i=0;i<ans.length();i++){
            int x = ans.charAt(i);
            xor ^= x;
        }
        char ch = (char) xor;
        return ch;
    }
}


//389. Find the Difference