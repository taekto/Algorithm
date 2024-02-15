import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] arr = new long[100];

    static long fibo(int n) {
        if(n <= 1) return n;
        else if(arr[n] != 0) return arr[n];
        else return arr[n] = fibo(n-1)+fibo(n-2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(fibo(N));
    }
}