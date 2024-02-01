import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int count = 0;
        boolean[] isPrime = new boolean[1001];
        Arrays.fill(isPrime, true);
        for(int i=2;i<=N;i++) {
            if(isPrime[i]) {
                isPrime[i] = false;
                count++;
                if(count == K) {
                    System.out.println(i);
                    return;
                }
            }
            for(int j=i;j<=N;j+=i) {
                if(!isPrime[j]) continue;
                else {
                    isPrime[j] = false;
                    count++;
                }
                if(count == K) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}