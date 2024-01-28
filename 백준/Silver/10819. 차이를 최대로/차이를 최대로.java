import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] visited;
    static int[] num;
    static int max = Integer.MIN_VALUE;
    static void dfs(int depth) {
        if(depth == N) {
            int sum = 0;
            for(int i=0;i<N-1;i++) {
                sum+=Math.abs(num[i]-num[i+1]);
            }
            max = Math.max(max, sum);
            return;
        }

        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                num[depth] = arr[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        num = new int[N];
        visited = new boolean[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);

    }
}