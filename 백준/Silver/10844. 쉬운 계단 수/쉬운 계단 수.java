import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[101][10];
        long[][] num = new long[101][10];

        arr[1][0] = 0;
        arr[1][1] = 1;
        arr[1][2] = 1;
        arr[1][3] = 1;
        arr[1][4] = 1;
        arr[1][5] = 1;
        arr[1][6] = 1;
        arr[1][7] = 1;
        arr[1][8] = 1;
        arr[1][9] = 1;

        for(int i=2;i<=100;i++) {
            arr[i][0] = arr[i-1][1]%1000000000;
            arr[i][1] = arr[i-1][0]%1000000000+arr[i-1][2]%1000000000;
            arr[i][2] = arr[i-1][1]%1000000000+arr[i-1][3]%1000000000;
            arr[i][3] = arr[i-1][2]%1000000000+arr[i-1][4]%1000000000;
            arr[i][5] = arr[i-1][4]%1000000000+arr[i-1][6]%1000000000;
            arr[i][6] = arr[i-1][5]%1000000000+arr[i-1][7]%1000000000;
            arr[i][4] = arr[i-1][3]%1000000000+arr[i-1][5]%1000000000;
            arr[i][7] = arr[i-1][6]%1000000000+arr[i-1][8]%1000000000;
            arr[i][8] = arr[i-1][7]%1000000000+arr[i-1][9]%1000000000;
            arr[i][9] = arr[i-1][8]%1000000000;

        }

        long result = 0;
        for(int i=0;i<10;i++) {
            result +=arr[N][i];
            result %= 1000000000;
        }
        System.out.println(result);

    }
}