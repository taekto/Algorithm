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
        public int getY() {
            return y;
        }
        public int getX() {
            return x;
        }
        public void setY(int y) {
            this.y = y;
        }
        public void setX(int x) {
            this.x = x;
        }
    }
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[][] dist;
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(arr[i][j] == 1) {
                    visited[i][j] = true;
                    q.offer(new Pair(i,j));
                    dist[i][j] = 1;
                }
            }
        }

        boolean isAll = true;

        outer : for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(arr[i][j] == 0) {
                    isAll = false;
                    break outer;
                }
            }
        }

        if(isAll) {
            System.out.println(0);
        }
        else {
            while(!q.isEmpty()) {
                Pair cur = q.poll();
                int y = cur.getY();
                int x = cur.getX();
                for(int i=0;i<4;i++) {
                    int ny = y+dy[i];
                    int nx = x+dx[i];
                    if(ny < 0 || nx < 0 || ny >= N || nx >= M) {
                        continue;
                    }
                    else if(arr[ny][nx] == 0 && visited[ny][nx] == false) {
                        q.add(new Pair(ny,nx));
                        visited[ny][nx] = true;
                        arr[ny][nx] = 1;
                        if(dist[ny][nx] <= 1) {
                            dist[ny][nx] = dist[y][x] +1;
                        }
                        else {
                            dist[ny][nx] = Math.min(dist[y][x]+1, dist[ny][nx]);
                        }
                    }
                }
            }

            boolean flag = false;
            int result = 0;

            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(arr[i][j] == 0) {
                        flag = true;
                    }
                    result = Math.max(dist[i][j], result);
                }
            }
            if(flag) {
                System.out.println(-1);
            }
            else {
                System.out.println(result-1);
            }


        }
    }
}