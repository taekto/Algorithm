import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int gcd(int a, int b) {
        if(b == 0) return a;
        if(a>=b) return gcd(b,a%b);
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long result = 0;
            Arrays.sort(arr);
            for(int i=0;i<N-1;i++) {
                for(int j=i+1;j<N;j++) {
                    result += gcd(arr[j],arr[i]);
                }
            }
            System.out.println(result);
        }
    }
}