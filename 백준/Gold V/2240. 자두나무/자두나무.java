import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, W;
    static int[] arr;
    static int[][] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[T];
        num = new int[T][W+1];
        int count = 0;
        for(int i=0;i<T;i++) {
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
            if(a == 1) {
                count++;
                num[i][0] = count;
            }
        }

        if(arr[0] == 1) {
            num[0][0] = 1;
        } else {
            num[0][1] = 1;
        }

        // 짝수일때 1의 위치, 홀수일때 2의 위치에 있음
        for(int i=1;i<T;i++) {
            int a = arr[i];
            for(int j=1;j<=W;j++) {
                // 홀수
                if(j%2 == 1) {
                    if(a == 1) {
                        num[i][j] = Math.max(num[i-1][j], num[i-1][j-1]);
                    }
                    else {
                        num[i][j] = Math.max(num[i-1][j]+1, num[i-1][j-1]+1);
                    }
                }
                // 짝수
                else {
                    if(a == 1) {
                        num[i][j] = Math.max(num[i-1][j]+1, num[i-1][j-1]+1);
                    }
                    else {
                        num[i][j] = Math.max(num[i-1][j], num[i-1][j-1]);
                    }
                }
            }
        }

//        for(int i=0;i<=W;i++) {
//            for(int j=0;j<T;j++) {
//                System.out.print(num[j][i]+" ");
//            }
//            System.out.println();
//        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<=W;i++) {
            ans = Math.max(ans, num[T-1][i]);
        }

        System.out.println(ans);

    }
}