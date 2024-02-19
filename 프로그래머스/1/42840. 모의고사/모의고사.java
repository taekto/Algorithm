import java.util.*;
import java.io.*;

class Solution {
    
    static int[] arr1 = {1,2,3,4,5};
    static int[] arr2 = {2,1,2,3,2,4,2,5};
    static int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        int[] answer;
        int a = 0;
        int b = 0;
        int c = 0;
        
        for(int i=0;i<answers.length;i++) {
            if(arr1[i%5] == answers[i]) a++;
            if(arr2[i%8] == answers[i]) b++;
            if(arr3[i%10] == answers[i]) c++;
        }
        int max = Math.max(a, Math.max(b,c));
        List<Integer> list = new ArrayList<>();
        int count = 0;
        if(max == a) list.add(1);
        if(max == b) list.add(2);
        if(max == c) list.add(3);
        answer = new int[list.size()];
        Collections.sort(list);
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}