import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] arr;
    static int[][] num;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        num = new int[n+1][2];

        for(int i=1;i<=n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(n>1) {
            num[1][0] = arr[1];
            num[1][1] = arr[1];
            num[2][0] = arr[2];
            num[2][1] = arr[1]+arr[2];
        }

        for(int i=3;i<=n;i++) {

            num[i][0] =  arr[i]+num[i-2][1];
            num[i][1] = Math.max(arr[i]+num[i-1][0], arr[i]+num[i-2][1]);

        }
        if(n == 1) {
            System.out.println(arr[1]);
        }
        else {
            System.out.println(Math.max(num[n][0],num[n][1]));
        }
    }
}