import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] list;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int[] ans;
    static class Node {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    static boolean allVisited() {
        for(int i=1;i<=N;i++) {
            if(!visited[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new List[N+1];
        ans = new int[N+1];
        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(u == -1 && v == -1) break;
            list[u].add(v);
            list[v].add(u);
        }

        for(int i=1;i<=N;i++) {
            visited = new boolean[N+1];
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(i, 0));
            visited[i] = true;
            int count = 0;

            while(!q.isEmpty()) {
                Node cur = q.poll();
                int num = cur.num;
                count = cur.count;
                for(int j=0;j<list[num].size();j++) {
                    if(visited[list[num].get(j)]) continue;
                    visited[list[num].get(j)] = true;
                    q.add(new Node(list[num].get(j), count+1));
                }
            }

            if(allVisited());
            ans[i] = count;

        }

        for(int i=1;i<=N;i++) {
            if(ans[i] != 0) min = Math.min(min, ans[i]);
        }

        int score = min;
        int cnt = 0;
        for(int i=1;i<=N;i++) {
            if(ans[i] == min) cnt++;
        }
        System.out.println(score+" "+cnt);
        for(int i=1;i<=N;i++) {
            if(ans[i] == min) System.out.print(i+" ");
        }
    }
}