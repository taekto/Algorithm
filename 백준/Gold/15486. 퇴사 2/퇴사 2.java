import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr = new int[2000000];
    static int[] day = new int[2000000];
    static int[] num = new int[2000000];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i=1;i<=N+1;i++) {
            num[i] = Math.max(max, num[i]);
            num[i+day[i]] = Math.max(num[i+day[i]], num[i]+arr[i]);
            max = Math.max(max, num[i]);
        }
        System.out.println(num[N+1]);
    }
}