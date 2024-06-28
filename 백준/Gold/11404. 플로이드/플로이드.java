import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static final int INF = 0x3f3f3f3f;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        cost = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            Arrays.fill(cost[i], INF);
        }
        for(int i=1;i<=n;i++) {
            cost[i][i] = 0;
        }
        for(int i=0;i<m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            cost[a][b] = Math.min(value, cost[a][b]);
        }

        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    if(cost[i][k] + cost[k][j] < cost[i][j]) {
                        cost[i][j] = cost[i][k]+cost[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(cost[i][j] == INF) sb.append(0).append(" ");
                else sb.append(cost[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }
}