import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int y;
        int x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1,1};
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int h, w;

    static void func(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        visited[y][x] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            for(int i=0;i<8;i++) {
                int ny = dy[i]+cur.y;
                int nx = dx[i]+cur.x;
                if(ny >= h || nx >= w || ny < 0 || nx < 0) continue;
                if(!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new Node(ny, nx));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(h == 0 && w == 0) break;
            visited = new boolean[h][w];
            for(int i=0;i<h;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++) {
                    int a = Integer.parseInt(st.nextToken());
                    if(a == 0) visited[i][j] = true;
                }
            }
            int count = 0;
            for(int i=0;i<h;i++) {
                for(int j=0;j<w;j++) {
                    if(visited[i][j]) continue;
                    func(i,j);
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}