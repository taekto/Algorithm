import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static int[] nums = new int[10];

    static void func(int k) {
        if(k == M) {
            for(int i=0;i<M;i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int tmp = 0;
        for(int i=0;i<N;i++) {
            int cur = arr[i];
            if(!visited[i] && tmp != arr[i]) {
                visited[i] = true;
                nums[k] = arr[i];
                tmp = arr[i];
                func(k+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        func(0);
        System.out.println(sb.toString());


    }
}