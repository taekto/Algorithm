import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0,0,-1,1};
    static int year = 0;
    static int count = 0;
    static int N, M;
    static boolean flag;

    static Queue<Pair> q;

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
    // 빙산 녹는 정도 체크
    public static void check() {

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(arr[i][j] != 0) {
                    int num = 0;
                    for(int k=0;k<4;k++) {
                        int ny = i+dy[k];
                        int nx = j+dx[k];
                        if(ny < 0 || nx < 0 || ny >= N || nx >= M) {
                            continue;
                        }
                        else if(arr[ny][nx] == 0){
                            num++;
                        }
                    }
                    dist[i][j] = num;
                }
            }
        }

    }

    public static void bfs(int y, int x) {
        visited[y][x] = true;
        q.offer(new Pair(y,x));
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            y = cur.getY();
            x = cur.getX();
            for(int i=0;i<4;i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }
                else if(visited[ny][nx] == false && arr[ny][nx] != 0 ) {
                    visited[ny][nx] = true;
                    q.offer(new Pair(ny, nx));
                }
            }
        }
    }

    public static void melt() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                arr[i][j] -= dist[i][j];
                if(arr[i][j] < 0) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];

        q = new LinkedList<>();

        boolean isAll = false;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                int a = Integer.parseInt(st.nextToken());
                arr[i][j] = a;

            }
        }

        while(true) {
            visited = new boolean[N][M];
            flag = false;
            count = 0;
            check();
            melt();
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(visited[i][j] == false && arr[i][j] != 0) {
                        bfs(i,j);
                        count++;
                    }
                    if(arr[i][j] != 0) {
                        flag = true;
                    }
                }
            }
//                System.out.println(count);
            year++;

//                for(int i=0;i<N;i++) {
//                    for(int j=0;j<M;j++) {
//                        System.out.print(arr[i][j]+" ");
//                    }
//                    System.out.println();
//                }

            if(count >= 2) {
                System.out.println(year);
                break;
            }

            if(flag == false) {
                System.out.println(0);
                break;
            }

        }

    }
}