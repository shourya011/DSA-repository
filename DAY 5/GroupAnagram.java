import java.util.*;
public class GroupAnagram {
    public static String Sort(String a){

        // char[] arr = a.toCharArray();
        // Arrays.sort(arr);
        // return new String(arr);

        String temp = "";
        for(int i=97;i<=122;i++){
            for(int j=0;j<a.length();j++){
                if(a.charAt(j)==i){
                    temp += a.charAt(j);
                }
            }
        }
        return temp;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String key = Sort(strs[i]);
            List<String> list = new ArrayList<>();
            if(map.containsKey(key)){
                list = map.get(key);
            }
            list.add(strs[i]);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());

    }
}
