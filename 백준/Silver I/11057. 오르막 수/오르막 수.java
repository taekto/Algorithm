import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] num;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[1001][10];

        for(int i=0;i<=9;i++) {
            num[1][i] = 1;
        }

        for(int i=2;i<=1000;i++) {

            int sum = 0;

            for(int j=0;j<=9;j++) {
                sum = (sum+num[i-1][j])%10007;
                num[i][j] = sum;
            }
        }

        int ans = 0;

        for(int i=0;i<=9;i++) {
            ans = (ans+num[N][i])%10007;
        }
        System.out.println(ans);

    }
}