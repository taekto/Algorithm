import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visited;
    static void dfs(int k) {
        if(k == N) {
            for(int i=0;i<N;i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[k] = i;
                dfs(k+1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visited = new boolean[N+1];
        dfs(0);
        System.out.println(sb.toString());
    }
}