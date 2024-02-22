import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[] visited;
    static List<Integer>[] list;
    static boolean ans = false;

    static void func(int depth, int num) {
        if(depth == 5) {
            ans = true;
            return;
        }

        for(int nxt : list[num]) {
            if(!visited[nxt]) {
                visited[nxt] = true;
                func(depth+1, nxt);
                visited[nxt] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        list = new ArrayList[N+1];

        for(int i=0;i<=N;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }


        for(int i=0;i<N;i++) {
            if(ans) break;
            visited[i] = true;
            func(1, i);
            visited[i] = false;
        }

        if(ans) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}