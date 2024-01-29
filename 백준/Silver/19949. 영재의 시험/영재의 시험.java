import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] num;
    static int count = 0;
    static void func(int depth) {
        if(depth == 10) {
            int result = 0;
            for(int i=0;i<10;i++) {
                if(arr[i] == num[i]) result++;
            }
            if(result >= 5) count++;
            return;
        }

        for(int i=1;i<=5;i++) {
            if(depth < 2) {
                num[depth] = i;
                func(depth+1);
                num[depth] = 0;
            }
            else {
                if(num[depth-2] == num[depth-1] && num[depth-2] == i) continue;
                num[depth] = i;
                func(depth+1);
                num[depth] = 0;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[10];
        num = new int[10];

        for(int i=0;i<10;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0);
        System.out.println(count);

    }
}