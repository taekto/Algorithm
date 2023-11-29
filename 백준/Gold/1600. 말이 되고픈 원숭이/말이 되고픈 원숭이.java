import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int W, H, K;
    static int[][][] dist;
    static boolean[][][] visited;
    static int[] dy = {-2,-2,-1,-1,1,1,2,2,-1,1,0,0};
    static int[] dx = {-1,1,-2,2,-2,2,-1,1,0,0,-1,1};


    public static class Pair{
        int y;
        int x;
        int z;
        int count;
        public Pair(int z, int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
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

        public int getCount() {
            return count;
        }

        public int getZ() {
            return z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][W];
        dist = new int[K+1][H][W];
        visited = new boolean[K+1][H][W];

        for(int i=0;i<H;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<W;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,0,0));
        visited[0][0][0] = true;

        int result = 0;

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int z = cur.getZ();
            int y = cur.getY();
            int x = cur.getX();
            int count = cur.getCount();

            if(y == H-1 && x == W-1) {
                result = count;
                break;
            }

            for(int i=0;i<12;i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny < 0 || nx < 0 || ny >= H || nx >= W) {
                    continue;
                }
                if(z < K && !visited[z+1][ny][nx] && i <= 7 && arr[ny][nx] != 1) {
                    visited[z+1][ny][nx] = true;
                    q.offer(new Pair(z+1, ny, nx, count+1));
                }
                if(!visited[z][ny][nx] && arr[ny][nx] != 1 && i > 7) {
                    visited[z][ny][nx] = true;
                    q.offer(new Pair(z, ny, nx, count+1));
                }
            }
        }
        if(result == 0) {
            if(W == 1 && H == 1 && arr[0][0] == 0) {
                System.out.println(0);
            }
            else {
                System.out.println(-1);
            }
        }
        else {
            System.out.println(result);
        }
    }
}