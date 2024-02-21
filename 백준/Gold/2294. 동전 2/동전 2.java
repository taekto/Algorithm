import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[] arr;
    static int[] num;
    static int INF = 20000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        num = new int[k+1];
        Arrays.fill(num , INF);
        for(int i=1;i<=n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        num[0] = 0;
        for(int i=1;i<=n;i++) {
            for(int j=arr[i];j<=k;j++) {
                num[j] = Math.min(num[j-arr[i]]+1, num[j]);
            }
        }

        if(num[k] == INF) {
            System.out.println(-1);
        }
        else {
            System.out.println(num[k]);
        }
    }
}