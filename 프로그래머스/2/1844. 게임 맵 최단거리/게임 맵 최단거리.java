import java.util.*;
import java.io.*;

class Solution {
    
    static class Node{
        int y;
        int x;
        int count;
        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
    
    static int[] dy = {-1 ,1 , 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited;
    static int ans = -1;
    
    static void bfs(int[][] maps) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,1));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.y == maps.length-1 && cur.x == maps[0].length-1) {
                ans = cur.count;
                break;
            }
            for(int i=0;i<4;i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if(ny < 0 || nx < 0 || ny >= maps.length || nx >= maps[0].length) continue;
                if(!visited[ny][nx] && maps[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    q.add(new Node(ny,nx,cur.count+1));
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        bfs(maps);
        
        
        return ans;
    }
}