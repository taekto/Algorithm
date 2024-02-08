import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int y;
        int x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static int ans = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    static void bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        visited[y][x] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            for(int i=0;i<4;i++) {
                int ny = cur.y+dy[i];
                int nx = cur.x+dx[i];
                if(ny >= N || nx >= N || nx < 0 || ny < 0) continue;
                if(!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new Node(ny,nx));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0;k<=100;k++) {
            visited = new boolean[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(map[i][j] > k) continue;
                    visited[i][j] = true;
                }
            }
            int count = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(visited[i][j]) continue;
                    bfs(i,j);
                    count++;
                }
            }
            ans = Math.max(count, ans);
        }
        if(ans == Integer.MIN_VALUE) {
            System.out.println(1);
        } else {
            System.out.println(ans);
        }
    }
}