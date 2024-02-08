import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isPrime = new boolean[10001];
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for(int i=2;i*i<=10000;i++) {
            if(!isPrime[i]) continue;
            for(int j=i*i;j<=10000;j+=i) {
                if(!isPrime[j]) continue;
                isPrime[j] = false;
            }
        }
    }

    static void func(int num) {
        int start = num/2;
        int a = start;
        int b = start;

        while (true) {
            if(isPrime[a] && isPrime[b]) {
                sb.append(a).append(" ").append(b).append("\n");
                break;
            }
            a -= 1;
            b += 1;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sieve();
        for(int tc=1;tc<=T;tc++) {
            int n = Integer.parseInt(br.readLine());
            func(n);
        }
        System.out.println(sb.toString());
    }
}