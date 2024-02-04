import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int to;
        int cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int N;
    static List<Node>[] list;
    static boolean[] visited;
    static long ans = 0;
    static void prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int to = cur.to;
            int cost = cur.cost;
            if(visited[to]) continue;
            visited[to] = true;
            ans += cost;
            for(Node next : list[to]) {
                if(!visited[next.to]) pq.add(new Node(next.to, next.cost));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new List[N+1];
        visited = new boolean[N+1];
        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                int cost = Integer.parseInt(st.nextToken());
                if(cost == 0) continue;
                list[i].add(new Node(j, cost));
            }
        }

        prim(1);
        System.out.println(ans);
    }
}