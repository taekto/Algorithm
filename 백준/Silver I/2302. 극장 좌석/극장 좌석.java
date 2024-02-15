import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[] arr;
    static boolean[] fix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[41];
        fix = new boolean[N+1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        for(int i=4;i<=40;i++) {
            arr[i] = arr[i-1]+arr[i-2];
        }

        for(int i=0;i<M;i++) {
            int a = Integer.parseInt(br.readLine());
            fix[a] = true;
        }

        int ans = 0;
        int count = 0;

        for(int i=1;i<=N;i++) {
            if(!fix[i]) count++;
            else {
                if(ans == 0) {
                    ans = arr[count];
                    count = 0;
                }
                else {
                    ans *= arr[count];
                    count = 0;
                }
            }
        }

        if(ans == 0) {
            System.out.println(arr[N]);
        } else {
            if(count != 0) ans*=arr[count];
            System.out.println(ans);
        }
    }
}