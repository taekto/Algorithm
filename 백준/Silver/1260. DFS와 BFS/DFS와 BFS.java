import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M,V;
    static List<Integer>[] list;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void bfs(int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        visited[k] = true;
        sb.append(k).append(" ");
        while(!q.isEmpty()) {
            k = q.poll();
            for(int i=0;i<list[k].size();i++) {
                if(visited[list[k].get(i)]) continue;
                visited[list[k].get(i)] = true;
                sb.append(list[k].get(i)).append(" ");
                q.add(list[k].get(i));
            }
        }
    }

    static void recursive(int k) {
        visited[k] = true;
        sb.append(k).append(" ");
        for(int i=0;i<list[k].size();i++) {
            if(visited[list[k].get(i)]) continue;
            recursive(list[k].get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        for(int i=1;i<=N;i++) {
            Collections.sort(list[i]);
        }

        visited = new boolean[N+1];
        recursive(V);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(V);

        System.out.println(sb.toString());

    }
}