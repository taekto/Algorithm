import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String s : participant) {
            if(hashMap.containsKey(s)) {
                hashMap.put(s, hashMap.get(s)+1);
            }
            else {
                hashMap.put(s, 1);
            }
        }
        
        for(String s : completion) {
            hashMap.put(s, hashMap.get(s)-1);
            if(hashMap.get(s) == 0) {
                hashMap.remove(s);
            }
        }
        for(String s : hashMap.keySet()) {
            return s;
        }
        
        return "";
    }
}