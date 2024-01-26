import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int count = N;
        List<Integer>[] list = new ArrayList[N+1];
        int[] indegree = new int[N+1];
        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());
            if(people <= 1) continue;
            int a = Integer.parseInt(st.nextToken());
            for(int j=0;j<people-1;j++) {
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                indegree[b]++;
                a = b;
            }
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=N;i++) {
            if(indegree[i] == 0) {
                q.add(i);
                count--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append("\n");
            for(int i=0;i<list[cur].size();i++) {
                indegree[list[cur].get(i)]--;
                if(indegree[list[cur].get(i)] == 0) {
                    q.add(list[cur].get(i));
                    count--;
                }
            }
        }
        if(count == 0) {
            System.out.println(sb.toString());
        }
        else {
            System.out.println(0);
        }
    }
}