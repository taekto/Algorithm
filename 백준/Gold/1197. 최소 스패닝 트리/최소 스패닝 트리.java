import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 크루스칼 알고리즘
public class Main {

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int value;

        public Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if(this.value < o.value) return -1;
            return 1;
        }

    }

    static int V,E;
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
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        // 부모 선언후 초기화는 자기 자신
        parent = new int[V+1];
        for(int i=1;i<=V;i++) {
            parent[i] = i;
        }
        List<Node> list = new ArrayList<>();
        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list.add(new Node(u,v,value));
        }
        Collections.sort(list);
        
        for(int i=0;i<E;i++) {
            Node cur = list.get(i);
            int from = cur.from;
            int to = cur.to;
            int value = cur.value;
            if(find(from) == find(to)) continue;
            union(from, to);
            result += value;
        }

        System.out.println(result);

    }
}