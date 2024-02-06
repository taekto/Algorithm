import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to;
        int cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int V,E,K;
    static List<Node>[] list;
    static int[] dist;
    static int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        dist = new int[V+1];
        list = new ArrayList[V+1];
        Arrays.fill(dist, INF);
        for(int i=1;i<=V;i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[K] = 0;
        pq.add(new Node(K,0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(dist[cur.to] != cur.cost) continue;

            for(Node nxt : list[cur.to]) {
                if(dist[nxt.to] <= dist[cur.to]+nxt.cost) continue;
                // cur를 거쳐가는 것이 더 작은 값을 가질 경우
                // dist[nxt.to]을 갱신하고 우선순위 큐에 추가
                dist[nxt.to] =  dist[cur.to] + nxt.cost;
                pq.add(new Node(nxt.to, dist[nxt.to]));
            }
        }

        for(int i=1;i<=V;i++) {
            if(dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }

    }
}