import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] num;
    static int[] pre;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        num = new int[N+1];
        pre = new int[N+1];
        for(int i=1;i<=N;i++) {
            pre[i] = i;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        Arrays.fill(num, 1);
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=2;i<=N;i++) {
            for(int j=1;j<=i-1;j++) {
                if(arr[i] > arr[j]) {
                    if(num[j]+1 > num[i]) {
                        num[i] = num[j]+1;
                        pre[i] = j;
                    }
                }
            }
        }

        int result = 0;

        for(int i=1;i<=N;i++) {
            result = Math.max(result, num[i]);
        }
        int ed = 0;
        for(int i=1;i<=N;i++) {
            if(result == num[i]) ed = i;
        }
        Stack<Integer> stack = new Stack<>();
        while (ed != pre[ed]) {
            stack.add(ed);
            ed = pre[ed];
        }

        stack.add(ed);

        System.out.println(result);
        while(!stack.isEmpty()) {
            System.out.print(arr[stack.pop()]+" ");
        }

    }
}