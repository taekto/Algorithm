import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static int[] arr = new int[100];
    static boolean[] visited = new boolean[100];
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    public static void recursive(int cur, int tot) {
        if(cur == N) {
            if(tot == S) cnt++;
            return;
        }

        recursive(cur+1, tot);
        recursive(cur+1, tot+arr[cur]);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recursive(0, 0);
        if(S == 0) cnt--;
        System.out.println(cnt);

    }
}