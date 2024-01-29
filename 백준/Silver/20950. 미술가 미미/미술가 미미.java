import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] R;
    static int[] G;
    static int[] B;
    static int[] arr;
    static int min = Integer.MAX_VALUE;


    static void func(int target,int depth, int idx,int r,int g,int b) {
        if(depth == target) {
            r = r/depth;
            g = g/depth;
            b = b/depth;
            min = Math.min(min,Math.abs(r-arr[0])+Math.abs(g-arr[1])+Math.abs(b-arr[2]));
            return;
        }

        for(int i=idx;i<N;i++) {
            func(target,depth+1,i+1,r+R[i],g+G[i],b+B[i]);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = new int[N];
        G = new int[N];
        B = new int[N];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            G[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());
        int stop = 0;
        if(N <= 7)  stop = N;
        else stop = 7;

        for(int i=2;i<=stop;i++) {
            func(i,0,0,0,0,0);
        }
        System.out.println(min);

    }
}