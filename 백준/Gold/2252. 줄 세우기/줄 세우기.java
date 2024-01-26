import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[N+1];
        int[] indegree = new int[N+1];
        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
            indegree[B]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=N;i++) {
            if(indegree[i] == 0) q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");
            for(int i=0;i<list[cur].size();i++) {
                indegree[list[cur].get(i)]--;
                if(indegree[list[cur].get(i)] == 0) q.add(list[cur].get(i));
            }
        }
        System.out.println(sb.toString());
    }
}