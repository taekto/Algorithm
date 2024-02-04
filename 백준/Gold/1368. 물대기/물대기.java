import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int cost;
        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
    static int N;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        parent = new int[N+1];
        for(int i=0;i<=N;i++) {
            parent[i] = i;
        }
        for(int i=1;i<=N;i++) {
            int cost = Integer.parseInt(br.readLine());
            list.add(new Node(i,0,cost));
        }

        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                int cost = Integer.parseInt(st.nextToken());
                list.add(new Node(i,j, cost));
            }
        }

        Collections.sort(list);
        int ans = 0;
        for(int i=0;i<list.size();i++) {
            Node cur = list.get(i);
            int from = cur.from;
            int to = cur.to;
            int cost = cur.cost;
            if(find(from) == find(to)) continue;
            union(from, to);
            ans += cost;
        }
        System.out.println(ans);
    }
}