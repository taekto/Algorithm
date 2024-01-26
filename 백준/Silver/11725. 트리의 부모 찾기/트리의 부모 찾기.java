import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] list;
    static int N;
    static int[] parent;
    static void bfs(int k) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        while(!q.isEmpty()) {
            k = q.poll();
            for(int i=0;i<list[k].size();i++) {
                // 이 조건이 아주 중요! 부모는 뺴야됨
                if(parent[k] == list[k].get(i)) continue;
                q.add(list[k].get(i));
                parent[list[k].get(i)] = k;
            }
        }
    }

    public static void dfs(int k) {
        Stack<Integer> stack = new Stack<>();
        stack.add(k);

        while(!stack.isEmpty()) {
            k = stack.pop();
            for(int i=0;i<list[k].size();i++) {
                if(parent[k] == list[k].get(i)) continue;
                stack.add(list[k].get(i));
                parent[list[k].get(i)] = k;
            }
        }
    }

    public static void recursive(int k) {

        for(int i=0;i<list[k].size();i++) {
            if(parent[k] == list[k].get(i)) continue;
            parent[list[k].get(i)] = k;
            recursive(list[k].get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new List[N+1];
        parent = new int[N+1];
        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<N-1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

//        bfs(1);
//        recursive(1);
        dfs(1);

        for(int i=2;i<=N;i++) {
            System.out.println(parent[i]);
        }

    }
}