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

    static int[] dy = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dx = {-1,1,-2,2,-2,2,-1,1};
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            int l = Integer.parseInt(br.readLine());
            arr = new int[l][l];
            visited = new boolean[l][l];

            int startY = 0;
            int startX = 0;
            int targetY = 0;
            int targetX = 0;

            Queue<Pair> q = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            startY = Integer.parseInt(st.nextToken());
            startX = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            targetY = Integer.parseInt(st.nextToken());
            targetX = Integer.parseInt(st.nextToken());

            q.offer(new Pair(startY, startX, 0));
            visited[startY][startX] = true;

            while(!q.isEmpty()) {
                Pair cur = q.poll();

                int y = cur.getY();
                int x = cur.getX();
                int count = cur.getCount();

                if(y == targetY && x == targetX) {
                    System.out.println(count);
                    break;
                }

                for(int i=0;i<8;i++) {
                    int ny = y+dy[i];
                    int nx = x+dx[i];
                    if(ny < 0 || nx < 0 || ny >= l || nx >= l) {
                        continue;
                    }
                    else if(visited[ny][nx] == false) {
                        visited[ny][nx] = true;
                        q.add(new Pair(ny,nx,count+1));
                    }
                }
            }
        }
    }
}