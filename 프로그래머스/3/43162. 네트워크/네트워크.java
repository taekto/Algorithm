import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    static void bfs(int num, int[][] computers) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(num);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i=0;i<computers.length;i++) {
                if(!visited[i] && computers[cur][i] == 1) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                visited[i] = true;
                bfs(i, computers);
                count++;
            }
        }
        
        return count;
    }
}