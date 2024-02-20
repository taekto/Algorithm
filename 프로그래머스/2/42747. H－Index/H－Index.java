import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for(int i=citations.length;i>0;i--) {
            int count = 0;
            for(int j=citations.length-1;j>=0;j--) {
                if(i <= citations[j]) count++;
            }
            if(count >= i) {
                answer = i;
                break;
            }
        }
        
        
        return answer;
    }
}