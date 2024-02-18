import java.util.*;
import java.io.*;

class Solution {
    
    static int ans1 = 0;
    static int ans2 = 0;
    
    static String trans(String s) {
        char[] arr = s.toCharArray();
        s = "";
        int count = 0;
        ans1++;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == '1') {
                count++;
            }
            else {
                ans2++;
            }
        }
        
        while(count != 0) {
            s = s+String.valueOf(count%2);
            count/=2;
        }
        
        if(s.equals("1")) return s;
        else return trans(s);
    }
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        trans(s);
        answer[0] = ans1;
        answer[1] = ans2;
        return answer;
    }
}