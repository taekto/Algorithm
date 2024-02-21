import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        num = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Arrays.fill(num, 1);
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=2;i<=N;i++) {
            for(int j=1;j<=i-1;j++) {
                if(arr[i] > arr[j]) {
                    if(num[j]+1 > num[i]) {
                        num[i] = num[j]+1;
                    }
                }
            }
        }

        int result = 0;

        for(int i=1;i<=N;i++) {
            result = Math.max(result, num[i]);
        }

        System.out.println(result);

    }
}