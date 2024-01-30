import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R, X;
    static int[] arr;
    static int count = 0;
    static void func(int target,int depth, int start, int sum,int min, int max) {
        if(depth == target) {
            if(sum >= L && sum <= R && max-min>= X) {
//                System.out.println("sum = "+sum+" min = "+min+" max = "+max);
                count++;
            }
            return;
        }

        for(int i=start;i<N;i++) {
            func(target,depth+1,i+1,sum+arr[i],Math.min(min,arr[i]),Math.max(max,arr[i]));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=2;i<=N;i++) {
            func(i, 0,0,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        System.out.println(count);

    }
}
