import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr = new int[2000000];
    static int[] dir = new int[2000000];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr[1] = 0;
        arr[2] = 1;
        dir[2] = 1;
        for(int i=3;i<=N;i++) {
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;
            if(i%3 ==0) {
                a = arr[i/3]+1;
            }
            if(i%2 == 0) {
                b = arr[i/2]+1;
            }
            c = arr[i-1]+1;

            arr[i] = Math.min(a,Math.min(b,c));
            if(arr[i] == a) {
                dir[i] = i/3;
            }
            else if(arr[i] == b) {
                dir[i] = i/2;
            }
            else {
                dir[i] = i-1;
            }
        }

        System.out.println(arr[N]);
        System.out.print(N+" ");
        int direction = N;
        while(true) {
            if(direction == 1) {
                break;
            }
            System.out.print(dir[direction]+" ");
            direction = dir[direction];
        }
    }
}