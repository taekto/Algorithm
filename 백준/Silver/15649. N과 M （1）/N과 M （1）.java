import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr = new int[10];
    static boolean[] visited = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    static void recursive(int k) {
        if (k == M) {
            for(int i=0;i<M;i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        }

        for(int i=1;i<=N;i++) {
            if(!visited[i]) {
                arr[k] = i;
                visited[i] = true;
                recursive(k+1);
                visited[i] = false;
            }
        }

        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        recursive(0);
        System.out.println(sb.toString());

    }
}