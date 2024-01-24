import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];
        int[] num = new int[1001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Arrays.fill(num, 1);

        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=2;i<=N;i++) {
            for(int j=1;j<i;j++) {
                if(arr[i] > arr[j]) {
                    num[i] = Math.max(num[i], num[j]+1);
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