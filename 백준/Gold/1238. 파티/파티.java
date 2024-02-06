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
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int N, M, X;
    static int[] dist;
    static List<Node>[] list;
    static final int INF = 0x3f3f3f3f;
    static int[] rdist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        list = new ArrayList[N+1];
        Arrays.fill(dist, INF);
        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v,value));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));
        dist[X] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(dist[cur.vertex] != cur.cost) continue;

            for(Node nxt : list[cur.vertex]) {
                if(dist[nxt.vertex] <= dist[cur.vertex] + nxt.cost) continue;
                dist[nxt.vertex] = dist[cur.vertex] + nxt.cost;
                pq.add(new Node(nxt.vertex, dist[nxt.vertex]));
            }
        }

        for(int i=1;i<=N;i++) {
            if(i == X) continue;
            rdist = new int[N+1];
            Arrays.fill(rdist, INF);
            pq = new PriorityQueue<>();
            pq.add(new Node(i, 0));
            rdist[i] = 0;

            while(!pq.isEmpty()) {
                Node cur = pq.poll();
                if(rdist[cur.vertex] != cur.cost) continue;

                for(Node nxt : list[cur.vertex]) {
                    if(rdist[nxt.vertex] <= rdist[cur.vertex] + nxt.cost) continue;
                    rdist[nxt.vertex] = rdist[cur.vertex] + nxt.cost;
                    pq.add(new Node(nxt.vertex, rdist[nxt.vertex]));
                }
            }
            dist[i] += rdist[X];
        }
        int max = 0;
        for(int i=1;i<=N;i++) {
            max = Math.max(dist[i], max);
        }
        System.out.println(max);
    }
}