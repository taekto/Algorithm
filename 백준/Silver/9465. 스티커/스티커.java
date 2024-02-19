import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int[][] num;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {

            n = Integer.parseInt(br.readLine());
            arr = new int[2][n+1];
            num = new int[2][n+1];
            for(int i=0;i<2;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1;j<=n;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            num[0][1] = arr[0][1];
            num[1][1] = arr[1][1];

            for(int j=2;j<=n;j++) {
                for(int i=0;i<2;i++) {
                    if(i == 0) {
                        num[i][j] = Math.max(num[1][j-1]+arr[i][j], Math.max(num[0][j-2]+arr[i][j], num[1][j-2]+arr[i][j]));
                    }
                    else {
                        num[i][j] = Math.max(num[0][j-1]+arr[i][j], Math.max(num[0][j-2]+arr[i][j], num[1][j-2]+arr[i][j]));
                    }
                }
            }
            int max = Integer.MIN_VALUE;
            for(int i=0;i<2;i++) {
                max = Math.max(max, num[i][n]);
            }
            System.out.println(max);
        }
    }
}