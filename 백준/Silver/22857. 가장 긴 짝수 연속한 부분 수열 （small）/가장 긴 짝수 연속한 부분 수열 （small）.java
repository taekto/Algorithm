import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] S;
    static int[] arr;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = new int[K+1][N+1];
        st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for(int i=1;i<=N;i++) {
            if(arr[i]%2 == 0 ) {
                S[0][i] = ++count;
            }
            else {
                count = 0;
            }
        }

        for(int i=1;i<=K;i++) {
            count = 0;
            for(int j=1;j<=N;j++) {
                if((arr[j]%2) == 0) {
                    S[i][j] = Math.max(S[i-1][j-1]+1, S[i][j-1]+1);
                }
                else {
                    S[i][j] = S[i-1][j-1];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++) {
            max = Math.max(max, S[K][i]);
        }
        System.out.println(max);
    }
}