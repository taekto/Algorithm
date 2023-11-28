import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] arr;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0,0,-1,1};
    static int[][] fire;
    static int[][] escape;

    public static class Pair{
        int y;
        int x;
        int count;
        public Pair(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
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
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            arr = new char[h][w];
            visited = new boolean[h][w];
            fire = new int[h][w];
            escape = new int[h][w];


            int startY = 0;
            int startX = 0;
            Queue<Pair> q = new LinkedList<>();

            for(int i=0;i<h;i++) {
                String s = br.readLine();
                for(int j=0;j<w;j++) {
                    char a = s.charAt(j);
                    arr[i][j] = a;
                    if(a == '*') {
                        q.offer(new Pair(i,j,1));
                        visited[i][j] = true;
                        fire[i][j] = 1;
                    }
                    else if(a == '@') {
                        startY = i;
                        startX = j;
                    }
                }
            }

            while(!q.isEmpty()) {
                Pair cur = q.poll();
                int y = cur.getY();
                int x = cur.getX();
                int count = cur.getCount();
                for(int i=0;i<4;i++) {
                    int ny = y+dy[i];
                    int nx = x+dx[i];
                    if(ny < 0 || nx < 0 || ny >=h || nx >= w) {
                        continue;
                    }
                    else if(visited[ny][nx] == false && arr[ny][nx] != '#') {
                        visited[ny][nx] = true;
                        q.offer(new Pair(ny,nx,count+1));
                        fire[ny][nx] = count +1;
                    }
                }
            }

            visited = new boolean[h][w];

            q.offer(new Pair(startY, startX, 1));
            visited[startY][startX] = true;
            escape[startY][startX] = 1;

            int result = -1;

            while(!q.isEmpty()) {
                Pair cur = q.poll();
                int y = cur.getY();
                int x = cur.getX();
                int count = cur.getCount();

                if((y == 0 || x == 0 || y == h-1 || x == w-1) && escape[y][x] != 0) {
                    result = escape[y][x];
                    break;
                }

                for(int i=0;i<4;i++) {
                    int ny = y+dy[i];
                    int nx = x+dx[i];
                    if(ny < 0 || nx < 0 || ny >=h || nx >= w) {
                        continue;
                    }
                    else if(visited[ny][nx] == false && arr[ny][nx] != '#') {
                        if(count+1 < fire[ny][nx] || fire[ny][nx] == 0) {
                            visited[ny][nx] = true;
                            escape[ny][nx] = count+1;
                            q.offer(new Pair(ny,nx,count+1));
                        }
                    }
                }
            }

//            for(int i=0;i<h;i++) {
//                for(int j=0;j<w;j++) {
//                    System.out.print(escape[i][j]+" ");
//                }
//                System.out.println();
//            }

            if(result == -1) {
                System.out.println("IMPOSSIBLE");
            }
            else {
                System.out.println(result);
            }
        }
    }
}