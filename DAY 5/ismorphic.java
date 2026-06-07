import java.util.*;
public class ismorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Character> map = new HashMap<>();
        HashMap<Character,Character> map1 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ts = s.charAt(i);
            char tt = t.charAt(i);
            if(map.containsKey(ts)){
                char ch = map.get(ts);
                if(tt!=ch){
                    return false;
                }
            }
            map.put(ts,tt);
        }
        for(int i=0;i<s.length();i++){
            char ts = s.charAt(i);
            char tt = t.charAt(i);
            if(map1.containsKey(tt)){
                char ch = map1.get(tt);
                if(ts!=ch){
                    return false;
                }
            }
            map1.put(tt,ts);
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Character> map = new HashMap<>();
        HashMap<Character,Character> map1 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ts = s.charAt(i);
            char tt = t.charAt(i);
            if(map.containsKey(ts)){
                char ch = map.get(ts);
                if(tt!=ch){
                    return false;
                }
            }
            if(map1.containsKey(tt)){
                char ch = map1.get(tt);
                if(ts!=ch){
                    return false;
                }
            }

            map.put(ts,tt);
            map1.put(tt,ts);
        }
        return true;
    }
}
