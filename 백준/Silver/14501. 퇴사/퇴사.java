import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[100];
        int[] cost = new int[100];
        int[] num = new int[100];

        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());

        }

        for(int i=1;i<=N;i++) {
            num[i+arr[i]] = Math.max(num[i+arr[i]], num[i]+cost[i]);
            for(int j=i+arr[i];j<=N;j++) {
                num[j] = Math.max(num[j], num[i+arr[i]]);
            }

        }



        int result = 0;
        for(int i=1;i<=N+1;i++) {
            result = Math.max(result, num[i]);
//            System.out.print(num[i]+" ");
        }
        System.out.println(result);
    }
}