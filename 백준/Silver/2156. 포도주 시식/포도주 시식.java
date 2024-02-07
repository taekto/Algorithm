import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static int[][] num;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        num = new int[n+1][3];
        for(int i=1;i<=n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1) {
            System.out.println(arr[1]);
            return;
        }
        else {
            num[1][1] = arr[1];
            num[1][2] = 0;
            num[2][1] = arr[2];
            num[2][2] = arr[1]+arr[2];
        }
        for(int i=2;i<=n;i++) {
            num[i][0] = Math.max(num[i-1][1], Math.max(num[i-1][2], num[i-1][0]));
            num[i][1] = Math.max(num[i-2][1]+arr[i], Math.max(num[i-2][2]+arr[i], num[i-1][0]+arr[i]));
            num[i][2] = num[i-1][1]+arr[i];
        }

        System.out.println(Math.max(Math.max(num[n][1], num[n][2]), num[n][0]));

    }
}