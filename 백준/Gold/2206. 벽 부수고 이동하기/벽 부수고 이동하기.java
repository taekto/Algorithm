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
        int z;
        boolean flag;
        public Pair(int z,int y, int x) {
            this.y = y;
            this.x = x;
            this.z = z;
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

        public int getZ() {
            return z;
        }
    }

    static int[][] arr;
    static int[][][] dist;
    static boolean[][][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dist = new int[2][N][M];
        visited = new boolean[2][N][M];


        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,0));
        visited[0][0][0] = true;
        dist[0][0][0] = 1;

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int y = cur.getY();
            int x = cur.getX();
            int z = cur.getZ();
            for(int i=0;i<4;i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }
                if(z == 0 && visited[0][ny][nx] == false && arr[ny][nx] == 0) {
                    visited[0][ny][nx] = true;
                    dist[0][ny][nx] = dist[0][y][x] +1;
                    q.offer(new Pair(0, ny, nx));
                }
                if(z == 0 && visited[1][ny][nx] == false && arr[ny][nx] == 1) {
                    visited[1][ny][nx] = true;
                    dist[1][ny][nx] = dist[0][y][x] +1;
                    q.offer(new Pair(1, ny, nx));
                }
                if(z == 1 && visited[1][ny][nx] == false && arr[ny][nx] == 0) {
                    visited[1][ny][nx] = true;
                    dist[1][ny][nx] = dist[1][y][x] +1;
                    q.offer(new Pair(1, ny, nx));
                }
            }
        }
        boolean flag = false;
        if(dist[1][N-1][M-1] == 0 && dist[0][N-1][M-1] == 0) {
            flag = true;
        }

        if(flag) {
            System.out.println(-1);
        }
        else {
            if(dist[1][N-1][M-1] != 0 && dist[0][N-1][M-1] != 0) {
                System.out.println(Math.min(dist[1][N-1][M-1], dist[0][N-1][M-1]));
            }
            if(dist[0][N-1][M-1] == 0 && dist[1][N-1][M-1] != 0) {
                System.out.println(dist[1][N-1][M-1]);
            }
            if(dist[1][N-1][M-1] == 0 && dist[0][N-1][M-1] != 0) {
                System.out.println(dist[0][N-1][M-1]);
            }
        }
    }
}