import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];

        arr[1] = 1;
        arr[2] = 3;

        for(int i=3;i<=n;i++) {
            int a = arr[i-2]*2+arr[i-1];
            a = a%=10007;
            arr[i] = a;
        }
        System.out.println(arr[n]);

    }
}