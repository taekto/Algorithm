import java.util.*;
import java.io.*;

class Solution {
    
    static int ans = 0;
    static boolean[] visited;
    static int[] arr;
    static int N;    
    static void func(int[][] dungeons, int depth, int k) {
        if(depth == N) {
            int count = 0;
            for(int tmp : arr) {
                int a = dungeons[tmp][0];
                int b= dungeons[tmp][1];
                if(k >= a) {
                    k -= b;
                    count++;
                }
                else break;
            }
            ans = Math.max(ans, count);
            
            return;
        }
        
        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                func(dungeons, depth+1, k);
                visited[i] = false;
            }   
        }
        
    }
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        visited = new boolean[N];
        arr = new int[N];
        func(dungeons, 0, k);
        return ans;
    }
}