import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int vertex;
        int cost;
        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int N,E;
    static List<Node>[] list;
    static int[] dist;
    static final int INF = 200000000;
    static int V1, V2;

    static int func(int start, int end) {
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(dist[cur.vertex] != cur.cost) continue;
            for(Node nxt : list[cur.vertex]) {
                if(dist[nxt.vertex] <= dist[cur.vertex] + nxt.cost) continue;
                dist[nxt.vertex] = dist[cur.vertex] + nxt.cost;
                pq.add(new Node(nxt.vertex, dist[nxt.vertex]));
            }
        }

        return dist[end];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        dist = new int[N+1];
        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());

        long ans1 = func(1, V1) + func(V1, V2) + func(V2, N);
        long ans2 = func(1, V2) + func(V2, V1) + func(V1, N);
        long ans = Math.min(ans1, ans2);
        if(ans >= INF) System.out.println(-1);
        else System.out.println(ans);
    }
}