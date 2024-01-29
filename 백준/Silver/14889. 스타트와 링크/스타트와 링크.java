import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[] visited;
    static int[] start;
    static int[] link;
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    static void func(int depth, int idx) {
        if(depth == N/2) {

            int cnt = 0;
            for(int i=1;i<=N;i++) {
                if(!visited[i]) link[cnt++] = i;
            }
            
            int startsum = 0;
            int linksum = 0;

            for(int i=0;i<N/2;i++) {
                for(int j=0;j<N/2;j++) {
                    if(i==j) continue;
                    startsum += map[start[i]][start[j]];
                    linksum += map[link[i]][link[j]];
                }
            }

            min = Math.min(Math.abs(startsum-linksum), min);

            return;
        }

        if(idx == N+1) return;

        start[depth] = idx;
        visited[idx] = true;
        func(depth+1, idx+1);
        start[depth] = 0;
        visited[idx] = false;
        func(depth, idx+1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        link = new int[N/2];
        start = new int[N/2];
        map = new int[N+1][N+1];

        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0,1);
        System.out.println(min);

    }
}