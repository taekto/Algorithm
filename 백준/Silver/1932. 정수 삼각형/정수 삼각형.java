import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[501][501];
        int[][] num = new int[501][501];

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<i+1;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        num[0][0] = arr[0][0];
        if(n>1) {
            num[1][0] = arr[0][0]+arr[1][0];
            num[1][1] = arr[0][0]+arr[1][1];
        }

        for(int i=2;i<n;i++) {
            for(int j=0;j<i+1;j++) {
                if(j == 0) {
                    num[i][j] = num[i-1][j]+arr[i][j];
                }
                else if(j == i) {
                    num[i][j] = num[i-1][j-1]+arr[i][j];
                }
                else {
                    num[i][j] = Math.max(num[i-1][j-1],num[i-1][j])+arr[i][j];
                }
            }
        }

        for(int i=0;i<n;i++) {
            result = Math.max(result, num[n-1][i]);
        }

        System.out.println(result);

    }
}