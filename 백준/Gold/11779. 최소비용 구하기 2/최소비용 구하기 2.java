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
    static int n,m;
    static List<Node>[] list;
    static int[] dist;
    static int[] pre;
    static int INF = 0x3f3f3f3f;
    static int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n+1];
        pre = new int[n+1];
        list = new ArrayList[n+1];
        Arrays.fill(dist, INF);
        for(int i=1;i<=n;i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, value));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(dist[cur.vertex] != cur.cost) continue;

            for(Node nxt : list[cur.vertex]) {
                if(dist[nxt.vertex] <= dist[cur.vertex] + nxt.cost) continue;
                dist[nxt.vertex] = dist[cur.vertex] + nxt.cost;
                pre[nxt.vertex] = cur.vertex;
                pq.add(new Node(nxt.vertex, dist[nxt.vertex]));
            }
        }

        System.out.println(dist[end]);
        Stack<Integer> stack = new Stack<>();
        int ed = end;
        while(ed != start) {
            stack.add(ed);
            ed = pre[ed];
        }
        stack.add(start);
        System.out.println(stack.size());
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }
}