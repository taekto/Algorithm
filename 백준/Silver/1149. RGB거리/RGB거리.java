import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int[][] num;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][3];
        num = new int[N+1][3];

        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        num[1][0] = arr[1][0];
        num[1][1] = arr[1][1];
        num[1][2] = arr[1][2];

        for(int i=2;i<=N;i++) {

            num[i][0] = Math.min(num[i-1][1],num[i-1][2])+arr[i][0];
            num[i][1] = Math.min(num[i-1][0],num[i-1][2])+arr[i][1];
            num[i][2] = Math.min(num[i-1][0],num[i-1][1])+arr[i][2];

        }

        System.out.println(Math.min(Math.min(num[N][0], num[N][1]), num[N][2]));

    }
}