import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] num;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        num = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            num[i] = Math.max(arr[i], num[i-1]+arr[i]);
            max = Math.max(num[i], max);
        }
        System.out.println(max);
    }
}