import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static boolean[] isPrime = new boolean[300001];

    static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for(int i=2;i*i<=300000;i++) {
            if(!isPrime[i]) continue;
            for(int j=i*i;j<=300000;j+=i) {
                if(!isPrime[j]) continue;
                isPrime[j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sieve();
        while (true) {
            int a = Integer.parseInt(br.readLine());
            if(a == 0) return;
            int count = 0;
            for(int i=a+1;i<=2*a;i++) {
                if(isPrime[i]) count++;
                else continue;
            }
            System.out.println(count);
        }
    }
}