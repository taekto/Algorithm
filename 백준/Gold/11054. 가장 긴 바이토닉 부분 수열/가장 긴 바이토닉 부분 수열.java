import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] num1;
    static int[] num2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        num1 = new int[N+1];
        num2 = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(num1, 1);
        Arrays.fill(num2,1);
        for(int i=1;i<=N-1;i++) {
            for(int j=i+1;j<=N;j++) {
                if(arr[i] < arr[j]) {
                    num1[j] = Math.max(num1[i]+1,num1[j]);
                }
            }
        }

        for(int i=N;i>1;i--) {
            for(int j=i-1;j>=0;j--) {
                if(arr[i] < arr[j]) {
                    num2[j] = Math.max(num2[i]+1, num2[j]);
                }
            }
        }
        
        int max = 0;
        for(int i=1;i<=N;i++) {
            max = Math.max(max, num1[i]+num2[i]-1);
        }
        System.out.println(max);

    }
}