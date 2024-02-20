import java.util.*;
import java.io.*;

class Solution {
    
    static int[] parent;
    
    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        parent = new int[n+1];
        for(int i=1;i<=n;i++) {
            parent[i] = i;
        }
        
        for(int i=0;i<wires.length;i++) {
            for(int j=1;j<=n;j++) {
                parent[j] = j;
            }   
            for(int j=0;j<wires.length;j++) {
                if(j == i) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                if(find(a) != find(b)) union(a,b);
            }
            List<Integer> list = new ArrayList<>();
            for(int j=1;j<=n;j++) {
                if(!list.contains(find(j))) {
                    list.add(find(j));
                }
                if(list.size() == 2) break;
            }
            int count1 = 0;
            int count2 = 0;
            int a = list.get(0);
            for(int j=1;j<=n;j++) {
                if(a == find(j)) count1++;
                else count2++;
            }
            answer = Math.min(Math.abs(count1-count2), answer);
        }
        
        return answer;
    }
}