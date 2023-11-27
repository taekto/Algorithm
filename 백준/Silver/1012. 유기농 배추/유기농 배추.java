import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Pair{
        int y;
        int x;
        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getX() {
            return x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getY() {
            return y;
        }
    }

    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static Queue<Pair> q = new LinkedList<>();
    static int N;
    static int M;
    public static void bfs(int y, int x) {
        q.offer(new Pair(y,x));
        visited[y][x] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            y = cur.getY();
            x = cur.getX();
            for(int i=0;i<4;i++) {
                int ny = y +dy[i];
                int nx = x +dx[i];
                if(ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }
                else if(visited[ny][nx] == false && arr[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    q.offer(new Pair(ny,nx));
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            visited = new boolean[N][M];
            int count = 0;

            for(int i=0;i<K;i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;

            }

            for(int j=0;j<N;j++) {
                for(int k=0;k<M;k++) {
                    if(visited[j][k] == false && arr[j][k] == 1) {
                        bfs(j,k);
                        count++;
                    }
                }
            }

            System.out.println(count);

        }
    }
}