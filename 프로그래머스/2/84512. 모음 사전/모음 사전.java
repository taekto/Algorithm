import java.util.*;
import java.io.*;

class Solution {
    
    static List<String> list = new ArrayList<>();
    static char[] arr = {'A','E','I','O','U'};
    
    static void func(int depth, int k, String s) {
        if(depth == k) {
            list.add(s);
            return;
        }
        
        for(int i=0;i<5;i++) {
            func(depth, k+1, s+String.valueOf(arr[i]));
        }
        
    }
    
    public int solution(String word) {
        int answer = 0;

        
        for(int i=1;i<=5;i++) {
            func(i,0,"");
        }
        Collections.sort(list);
        answer = list.indexOf(word)+1;
        return answer;
    }
}