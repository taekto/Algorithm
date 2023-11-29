import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long POW(long a, long b, long m) {
        if (b == 1) return a % m;
        long val = POW(a, b / 2, m);
        val = val * val % m;
        if (b % 2 == 0) return val;
        return val * a % m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        System.out.println(POW(a,b,c));
    }
}