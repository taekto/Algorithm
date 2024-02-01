import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();
    
    static boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;
        for(int i=2;i*i<=num;i++) {
            if(num%i == 0) return false;
        }
        return true;
    }

    static void func(int depth, int sum) {
        if(depth == N) {
            sb.append(sum).append("\n");
            return;
        }

        for(int i=0;i<=9;i++) {
            int a = sum*10+i;
            if(!isPrime(a)) continue;
            func(depth+1, a);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        func(0,0);
        System.out.println(sb.toString());
    }
}