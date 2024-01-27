import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int num;
        int relation;

        public Node(int num, int relation) {
            this.num = num;
            this.relation = relation;
        }
    }
    static int n,m;
    static List<Integer>[] list;
    static boolean[] visited;
    static int count = 0;
    static void bfs(int k) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(k, 0));
        visited[k] = true;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int num = cur.num;
            int relation = cur.relation;
            if(relation <= 2) count++;

//            System.out.println("num = "+num+" relation = "+relation);
            for(int i=0;i<list[num].size();i++) {
                if(visited[list[num].get(i)]) continue;
                visited[list[num].get(i)] = true;
                q.add(new Node(list[num].get(i), relation+1));

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        list = new List[n+1];
        for(int i=1;i<=n;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1;i<=m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        bfs(1);
        System.out.println(count-1);
    }
}