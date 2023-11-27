import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] arr;
    static boolean[][] visited;

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

    public static void bfs1(int y, int x) {
        visited[y][x] = true;
        q.offer(new Pair(y,x));
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            y = cur.getY();
            x = cur.getX();
            for(int i=0;i<4;i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny < 0 || nx < 0 || ny >= N || nx >= N) {
                    continue;
                }
                else if (visited[ny][nx] == false && arr[ny][nx] == arr[y][x]) {
                    visited[ny][nx] = true;
                    q.offer(new Pair(ny, nx));
                }
            }
        }
    }

    public static void bfs2(int y, int x) {
        visited[y][x] = true;
        q.offer(new Pair(y,x));
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            y = cur.getY();
            x = cur.getX();
            for(int i=0;i<4;i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny < 0 || nx < 0 || ny >= N || nx >= N) {
                    continue;
                }
                else if (visited[ny][nx] == false) {
                    if(arr[y][x] == 'R') {
                        if(arr[ny][nx] == 'R' || arr[ny][nx] == 'G') {
                            visited[ny][nx] = true;
                            q.offer(new Pair(ny, nx));
                        }
                    }
                    else if(arr[y][x] == 'G') {
                        if(arr[ny][nx] == 'R' || arr[ny][nx] == 'G') {
                            visited[ny][nx] = true;
                            q.offer(new Pair(ny, nx));
                        }
                    }
                    else if(arr[y][x] == 'B') {
                        if(arr[ny][nx] == 'B') {
                            visited[ny][nx] = true;
                            q.offer(new Pair(ny, nx));
                        }
                    }
                }
            }
        }
    }

    static Queue<Pair> q = new LinkedList<>();

    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<N;j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int count1 = 0;
        int count2 = 0;

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(visited[i][j] == false) {
                    bfs1(i,j);
                    count1++;
                }
            }
        }

        visited = new boolean[N][N];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(visited[i][j] == false) {
                    bfs2(i,j);
                    count2++;
                }
            }
        }

        System.out.println(count1+" "+count2);

    }
}