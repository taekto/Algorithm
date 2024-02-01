import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[31][31];
            arr[0][0] = 1;
            arr[1][1] = 1;
            arr[1][0] = 1;
            for(int i=1;i<=30;i++) {
                for(int j=0;j<=i;j++) {
                    if(i==j || j==0) arr[i][j] = 1;
                    else {
                        arr[i][j] = (arr[i-1][j]+arr[i-1][j-1]);
                    }
                }
            }
            System.out.println(arr[M][N]);
        }

    }
}