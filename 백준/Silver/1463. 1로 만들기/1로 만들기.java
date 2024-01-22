import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] arr = new int[10000000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr[1] = 0;
        for(int i=2;i<=N;i++) {
            arr[i] = arr[i-1]+1;
            if(i%2 == 0) {
                int b = arr[i/2]+1;
                arr[i] = Math.min(b,arr[i]);
            }
            if(i%3 == 0) {
                int a = arr[i/3]+1;
                arr[i] = Math.min(a,arr[i]);
            }
        }
        System.out.println(arr[N]);

    }
}