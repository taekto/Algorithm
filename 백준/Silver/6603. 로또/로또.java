import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visited = new boolean[6];
    static int[] num = new int[6];
    static StringBuilder sb = new StringBuilder();
    static int k;
    static void func(int a, int b) {
        if(a == 6) {
            for(int i=0;i<6;i++) {
                sb.append(num[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=b;i<k;i++) {
            if(!visited[i]) {
                visited[i] = true;
                num[a] = arr[i];
                func(a+1,i+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) {
                System.out.println(sb.toString());
                break;
            }
            else {
                arr = new int[k];
                visited = new boolean[k];
                for(int i=0;i<k;i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                func(0,0);
                sb.append("\n");
            }
        }
    }
}