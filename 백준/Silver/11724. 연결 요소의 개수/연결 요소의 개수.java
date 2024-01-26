import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int count = 0;

    static void bfs(int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        visited[k] = true;
        while(!q.isEmpty()) {
            k = q.poll();
            for(int i=0;i<list[k].size();i++) {
                if(!visited[list[k].get(i)]) {
                    visited[list[k].get(i)] = true;
                    q.add(list[k].get(i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
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
            if(!visited[i]) {
                bfs(i);
                count++;
            }
        }
        System.out.println(count);

    }
}