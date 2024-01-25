import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        int[] num = new int[N+1];
        for(int i=1;i<=N;i++) {
            num[i] = Integer.parseInt(st.nextToken());
                arr[i] = num[i] + arr[i-1];
        }


        int ed = 0;
        int total = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=N;i++) {
            for(int j=ed;j<=N;j++) {
//                System.out.println("i = "+i+" j = "+j);
                if(j == i) {
                    continue;
                }
                if(arr[j]-arr[i] >= M) {
                    min = Math.min(min, j-i);
                    ed = j;
                    break;
                }
            }
        }

        if(min == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else {
            System.out.println(min);
        }

    }
}