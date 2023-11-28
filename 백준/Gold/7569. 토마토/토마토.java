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
        public Pair(int z, int y, int x) {
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
        public int getZ() { return z;
        }
    }

    static int[][][] arr;
    static boolean[][][] visited;
    static int M, N, H;
    static int[] dy = {-1, 1 ,0 , 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0,0,0,0,-1,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        visited = new boolean[H][N][M];
        boolean isAll = true;

        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<H;i++) {
            for(int j=0;j<N;j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<M;k++) {
                    int a = Integer.parseInt(st.nextToken());
                    arr[i][j][k] = a;
                    if(a == 0) {
                        isAll = false;
                    }
                    else if(a == 1) {
                        q.add(new Pair(i,j,k));
                    }
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
                int z = cur.getZ();

                for(int i=0;i<6;i++) {
                    int ny = y+dy[i];
                    int nx = x+dx[i];
                    int nz = z+dz[i];
                    if(ny < 0 || nx < 0 || nz < 0 || ny >= N || nx >= M || nz >= H) {
                        continue;
                    }
                    else if(visited[nz][ny][nx] == false) {
                        if(arr[nz][ny][nx] == 0) {
                            visited[nz][ny][nx] = true;
                            arr[nz][ny][nx] = arr[z][y][x]+1;
                            q.offer(new Pair(nz,ny,nx));
                        }
                    }
                }
            }

            boolean flag = false;
            int size = 0;

            for(int i=0;i<H;i++) {
                for(int j=0;j<N;j++) {
                    for(int k=0;k<M;k++) {
                        if(arr[i][j][k] != -1) {
                            size = Math.max(size, arr[i][j][k]);
                        }
                        if(arr[i][j][k] == 0) {
                            flag = true;
                        }
                    }
                }
            }

//            System.out.println(flag);

            if(flag) {
                System.out.println(-1);
            }
            else {
                System.out.println(size-1);
            }
        }
    }
}