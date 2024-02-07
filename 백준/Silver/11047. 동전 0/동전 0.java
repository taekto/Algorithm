import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] coin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coin = new int[N];
        for(int i=0;i<N;i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        for(int i=N-1;i>=0;i--) {
            if(K == 0) break;
            int money = coin[i];
            ans += K/money;
            K = K%money;
        }
        System.out.println(ans);
    }
}