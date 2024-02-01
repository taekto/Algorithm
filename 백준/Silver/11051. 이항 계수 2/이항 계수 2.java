import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[1001][1001];
        arr[0][0] = 1;
        arr[1][1] = 1;
        arr[1][0] = 1;
        for(int i=1;i<=1000;i++) {
            for(int j=0;j<=i;j++) {
                if(i==j || j==0) arr[i][j] = 1;
                else {
                    arr[i][j] = (arr[i-1][j]+arr[i-1][j-1])%10007;
                }
            }
        }
        System.out.println(arr[N][K]);

    }
}