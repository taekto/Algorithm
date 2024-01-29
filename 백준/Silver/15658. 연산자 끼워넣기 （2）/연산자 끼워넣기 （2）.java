import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] sign;
    static int[] arr;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static void recursive(int depth, int result) {
        if(depth == N) {
            min = Math.min(min, result);
            max = Math.max(max, result);
//            System.out.println("min = "+min+" max = "+max);
            return;
        }


        if(sign[0] > 0) {
            sign[0] -= 1;
            recursive(depth+1, result+arr[depth]);
            sign[0] += 1;
        }

        if(sign[1] > 0) {
            sign[1] -= 1;
            recursive(depth+1, result-arr[depth]);
            sign[1] += 1;
        }

        if(sign[2] > 0) {
            sign[2] -= 1;
            recursive(depth+1, result*arr[depth]);
            sign[2] += 1;
        }

        if(sign[3] > 0) {
            sign[3] -= 1;
            if(result < 0) {
                recursive(depth+1, -(Math.abs(result)/arr[depth]));
            }
            else {
                recursive(depth+1, result/arr[depth]);
            }
            sign[3] += 1;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        sign = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) {
            sign[i] = Integer.parseInt(st.nextToken());
        }

        recursive(1, arr[0]);
        System.out.println(max);
        System.out.println(min);

    }
}