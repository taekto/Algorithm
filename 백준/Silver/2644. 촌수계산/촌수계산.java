import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        int point;
        int count;
        public Node(int point, int count) {
            this.point = point;
            this.count = count;
        }
    }

    static int n, m;
    static int a, b;
    static List<Integer>[] list;
    static boolean[] visited;
    static int ans = -1;

    static void func() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(a, 0));
        visited[a] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(b == cur.point) {
                ans = cur.count;
            }
            for(int nxt : list[cur.point]) {
                if(!visited[nxt]) {
                    q.add(new Node(nxt, cur.count+1));
                    visited[nxt] = true;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1;i<=n;i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        func();
        System.out.println(ans);

    }
}