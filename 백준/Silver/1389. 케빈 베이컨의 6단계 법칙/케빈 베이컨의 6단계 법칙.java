import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        int vertex;
        int count;
        public Node(int vertex, int count) {
            this.vertex = vertex;
            this.count = count;
        }
    }
    static int N, M;
    static List<Integer>[] list;
    static boolean[] visited;
    static int min = 0x3f3f3f3f;
    static int ans = 0;
    static int bfs(int vertex) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(vertex, 0));
        visited[vertex] = true;
        int num = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            vertex = cur.vertex;
            int count = cur.count;
            num += count;
            for(int nxt : list[vertex]) {
                if(!visited[nxt]) {
                    visited[nxt] = true;
                    q.add(new Node(nxt, count+1));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=1;i<=M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        for(int i=N;i>=1;i--) {
            visited = new boolean[N+1];
            int a = bfs(i);
            if(min >= a) {
                min = a;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}