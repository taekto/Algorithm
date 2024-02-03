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
        int num;
        public Node(int y, int x, int num) {
            this.y = y;
            this.x = x;
            this.num = num;
        }
    }

    static int n, m;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int[][] arr;
    static void bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y,x,0));
        visited[y][x] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            y = cur.y;
            x = cur.x;
            int num = cur.num;
            arr[y][x] = num;
            for(int i=0;i<4;i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny >= n || nx >= m || ny < 0 || nx < 0) continue;
                if(!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new Node(ny, nx, num+1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        arr = new int[n][m];
        int y = 0;
        int x = 0;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    y = i;
                    x = j;
                }
                if(map[i][j] == 0) visited[i][j] = true;
            }
        }

        bfs(y,x);
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!visited[i][j]) arr[i][j] = -1;
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}