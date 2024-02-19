import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int t=0;t<commands.length;t++) {
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];
            int[] arr = Arrays.copyOf(array, array.length);
            Arrays.sort(arr, i-1, j);
            answer[t] = arr[i-1+k-1];
        }
        
        return answer;
    }
}