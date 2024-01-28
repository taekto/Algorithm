import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M;
    static List<Integer>[] list1;
    static List<Integer>[] list2;
    static int[] up;
    static int[] down;

    static int bfs(int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        boolean[] visited = new boolean[N+1];
        int count = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i=0;i<list1[cur].size();i++) {
                if(!visited[list1[cur].get(i)]) {
                    visited[list1[cur].get(i)] = true;
                    q.add(list1[cur].get(i));
                    count++;
                }
            }
        }
        return count;

    }

    static int bfs2(int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        int count = 0;
        boolean[] visited = new boolean[N+1];
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i=0;i<list2[cur].size();i++) {
                if(!visited[list2[cur].get(i)]) {
                    visited[list2[cur].get(i)] = true;
                    q.add(list2[cur].get(i));
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list1 = new List[N+1];
        list2 = new List[N+1];
        up = new int[N+1];
        down = new int[N+1];

        for(int i=1;i<=N;i++) {
            list1[i] = new ArrayList<>();
            list2[i]= new ArrayList<>();
        }

        // list1 에는 나보다 무거운 간선, list2에는 나보다 가벼운 간선
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list1[v].add(u);
            list2[u].add(v);
        }

        for(int i=1;i<=N;i++) {
            down[i] = bfs(i);
            up[i] = bfs2(i);
//            System.out.print("down = "+down[i]+" up = "+up[i] );
//            System.out.println();
        }

        int result = 0;
        int range = (N+1)/2;
        for(int i=1;i<=N;i++) {
            if(up[i]+1 <= range && N-down[i] >= range) result++;
        }
        System.out.println(N-result);

    }
}