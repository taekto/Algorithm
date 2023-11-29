import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int K = 0;
    static StringBuilder sb = new StringBuilder();
    public static void recursive(int a, int b, int n) {
        if(n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            K++;
            return;
        }
        if(n < 1) return;
        recursive(a,6-a-b,n-1);
        recursive(a,b,1);
        recursive(6-a-b,b,n-1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        recursive(1,3,N);
        System.out.println(K);
        System.out.print(sb.toString());
    }
}