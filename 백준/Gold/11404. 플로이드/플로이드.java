import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] cost;
    static int INF = 0x3f3f3f3f;

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
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            cost[u][v] = Math.min(cost[u][v], value);
        }

        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    if(cost[i][j] > cost[i][k]+cost[k][j]) {
                        cost[i][j] = cost[i][k]+cost[k][j];
                    }
                }
            }
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(cost[i][j] == INF) System.out.print(0+" ");
                else System.out.print(cost[i][j]+" ");
            }
            System.out.println();
        }
    }
}