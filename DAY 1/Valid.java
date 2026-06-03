public class Valid {
    public static String Sort(String s){
        String temp = "";
        for(int i=97;i<=122;i++){
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)==i){
                    temp = temp+s.charAt(j);
                }
            }
        }
        return temp;
    }
    public boolean isAnagram(String s, String t) {
        s = Sort(s);
        t = Sort(t);
        if(s.equals(t)){
            return true;
        }
        return false;
    }
}
