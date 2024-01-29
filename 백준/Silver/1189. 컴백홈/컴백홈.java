import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R,C,K;
    static boolean[][] visited;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0,0,-1,1};
    static int result = 0;

    static void func(int r, int c, int cnt) {
        if(r == 0 && c == C-1 && cnt == K) {

//            for(int i=0;i<R;i++) {
//                for(int j=0;j<C;j++) {
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }

            result++;
            return;
        }

        for(int i=0;i<4;i++) {
            int nr = r+dy[i];
            int nc = c+dx[i];
            if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if(!visited[nr][nc]) {
                visited[nr][nc] = true;
                map[nr][nc] = cnt+1;
                func(nr,nc,cnt+1);
                visited[nr][nc] = false;
                map[nr][nc] = cnt-1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[R][C];

        for(int i=0;i<R;i++) {
            String s = br.readLine();
            for(int j=0;j<C;j++) {
                char a = s.charAt(j);
                if(a == 'T') visited[i][j] = true;
            }
        }

        map = new int[R][C];
        visited[R-1][0] = true;
        map[R-1][0] = 1;
        func(R-1, 0, 1);
        System.out.println(result);
    }
}