public boolean isSubsequence(String s, String t) {
        boolean found = false;
        int index = 0;
        for(int i=0;i<s.length();i++){
            found = false;
            for(int j=index;j<t.length();j++){
                if(s.charAt(i)==t.charAt(j)){
                    index = j+1;
                    found = true;
                    break;
                }
            }
            if(!found){
                return false;
            }

        }
    return true;
    }