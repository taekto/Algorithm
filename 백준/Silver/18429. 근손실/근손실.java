import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,K;
    static int[] arr;
    static int count = 0;
    static boolean[] visited;

    static void func(int depth, int sum) {
        if(depth == N) {
            count++;
            return;
        }

        for(int i=0;i<N;i++) {
            if(!visited[i] && sum+arr[i]-K >= 500) {
                visited[i] = true;
                func(depth+1, sum+arr[i]-K);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        func(0,500);
        System.out.println(count);

    }
}