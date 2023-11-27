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

    public static char[][] arr;
    public static boolean[][] visited;
    public static int[][] fire;
    public static int[][] escape;
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];

        int fireY = 0;
        int fireX = 0;
        int escapeY = 0;
        int escapeX = 0;
        Queue<Pair> q = new LinkedList<>();
        visited = new boolean[R][C];
        fire = new int[R][C];

        for(int i=0;i<R;i++) {
            String s = br.readLine();
            for(int j=0;j<C;j++) {
                arr[i][j] = s.charAt(j);
                if(s.charAt(j) == 'J') {
                    escapeY = i;
                    escapeX = j;
                }
                else if(s.charAt(j) == 'F') {
                    q.offer(new Pair(i,j));
                    fire[i][j] = 1;
                    visited[i][j] = true;
                }
            }
        }

        escape = new int[R][C];

        escape[escapeY][escapeX] = 1;

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int y = cur.getY();
            int x = cur.getX();
            for(int i=0;i<4;i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    continue;
                }
                else if(arr[ny][nx] == '.' && visited[ny][nx] == false) {
                    visited[ny][nx] = true;
                    q.offer(new Pair(ny, nx));
                    fire[ny][nx] = fire[y][x] +1;
                }
            }
        }

        visited = new boolean[R][C];
        visited[escapeY][escapeX] = true;
        q.offer(new Pair(escapeY, escapeX));

//        for(int i=0;i<R;i++) {
//            for(int j=0;j<C;j++) {
//                System.out.print(escape[i][j]+" ");
//            }
//            System.out.println();
//        }

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int y = cur.getY();
            int x = cur.getX();
            for(int i=0;i<4;i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    continue;
                }
                else if(arr[ny][nx] == '.' && visited[ny][nx] == false) {
                    visited[ny][nx] = true;
                    int a = escape[y][x] +1;
                    if(fire[ny][nx] == 0) {
                        escape[ny][nx] = a;
                        q.offer(new Pair(ny,nx));
                        continue;
                    }
                    if(a < fire[ny][nx]) {
                        escape[ny][nx] = a;
                        q.offer(new Pair(ny, nx));
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {

                if(i == 0 || i == R-1 || j == 0 || j == C-1) {
                    if(escape[i][j] != 0) {
                        result = Math.min(result, escape[i][j]);
                    }
                }
                else {
                    continue;
                }
            }
        }

//        for(int i=0;i<R;i++) {
//            for(int j=0;j<C;j++) {
//                System.out.print(fire[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("여기부터 escape");
//
//        for(int i=0;i<R;i++) {
//            for(int j=0;j<C;j++) {
//                System.out.print(escape[i][j]+" ");
//            }
//            System.out.println();
//        }
        if(result == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        }
        else {
            System.out.println(result);
        }

    }
}