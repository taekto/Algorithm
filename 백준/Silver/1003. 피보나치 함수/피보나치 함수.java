import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] arr = new int[41][2];
        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;

        for(int i=2;i<=40;i++) {
            arr[i][0] = arr[i-2][0]+arr[i-1][0];
            arr[i][1] = arr[i-2][1]+arr[i-1][1];
        }

        for(int i=0;i<T;i++) {
            int a = Integer.parseInt(br.readLine());
            System.out.print(arr[a][0]+" "+arr[a][1]);
            System.out.println();
        }

    }
}