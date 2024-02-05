import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] cost;
    static int[] city;
    static int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cost = new int[N+1][N+1];

        for(int i=1;i<=N;i++) {
            Arrays.fill(cost[i], INF);
        }

        for(int i=1;i<=M;i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            cost[A][B] = Math.min(T, cost[A][B]);
        }

        for(int i=1;i<=N;i++) {
            cost[i][i] = 0;
        }

        for(int k=1;k<=N;k++) {
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    if(cost[i][j] > cost[i][k] + cost[k][j]) {
                        cost[i][j] = cost[i][k]+cost[k][j];
                    }
                }
            }
        }
        K = Integer.parseInt(br.readLine());
        city = new int[K+1];
        int[] time = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=K;i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=1;i<=N;i++) {
            int max = 0;
            for(int j=1;j<=K;j++) {
                int a = cost[i][city[j]];
                int b = cost[city[j]][i];
                if(a == INF || b == INF) break;
                max = Math.max(max, a+b);
            }
            time[i] = max;
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++) {
            if(time[i] != 0) {
                min = Math.min(min, time[i]);
            }
        }

        for(int i=1;i<=N;i++) {
            if(min == time[i]) {
                System.out.print(i+" ");
            }
        }
    }
}