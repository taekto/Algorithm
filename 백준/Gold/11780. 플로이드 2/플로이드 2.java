import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] cost;
    static int[][] nxt;
    static int INF = 0x3f3f3f3f;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        cost = new int[n+1][n+1];
        nxt = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            Arrays.fill(cost[i], INF);
        }

        for(int i=1;i<=m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            cost[a][b] = Math.min(cost[a][b], value);
            nxt[a][b] = b;
        }

        for(int i=1;i<=n;i++) {
            cost[i][i] = 0;
        }

        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    if(cost[i][k] + cost[k][j] < cost[i][j]) {
                        cost[i][j] = cost[i][k]+cost[k][j];
                        nxt[i][j] = nxt[i][k];
                    }
                }
            }
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(cost[i][j] == INF) {
                    sb.append(0).append(" ");
                }
                else {
                    sb.append(cost[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(cost[i][j] == INF || cost[i][j] == 0) {
                    sb.append(0).append("\n");
                    continue;
                }
                Queue<Integer> q = new ArrayDeque<>();
                int st = i;
                while(st != j) {
                    q.add(st);
                    st = nxt[st][j];
                }
                q.add(j);
                sb.append(q.size()).append(" ");
                while(!q.isEmpty()) {
                    sb.append(q.poll()).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}