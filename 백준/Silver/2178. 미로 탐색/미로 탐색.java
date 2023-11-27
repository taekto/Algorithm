import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Pair {
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
        public void setY() {
            this.y = y;
        }
        public void setX() {
            this.x = x;
        }

    }
    public static int[][] arr;
    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0, 0));
        visited[0][0] = true;

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
                else if(arr[ny][nx] != 0 && visited[ny][nx] == false) {
                    visited[ny][nx] = true;
                    q.offer(new Pair(ny,nx));
                    if(arr[ny][nx] == 1) {
                        arr[ny][nx] = arr[y][x] + 1;
                    }
                    else {
                        arr[ny][nx] = Math.min(arr[ny][nx], arr[y][x] + 1);
                    }
                }
            }
        }

        System.out.println(arr[N-1][M-1]);

    }
}