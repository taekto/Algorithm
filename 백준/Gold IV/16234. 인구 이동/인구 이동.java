import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int y;
        int x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static boolean transfer;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int count = 1;

    static void bfs(int y, int x) {
        Queue<Node> q = new ArrayDeque<>();
        List<Node> list = new ArrayList<>();
        int sum = 0;
        q.add(new Node(y, x));
        visited[y][x] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            y = cur.y;
            x = cur.x;
            list.add(new Node(y,x));
            sum += map[y][x];
            for(int i=0;i<4;i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if(!visited[ny][nx] && Math.abs(map[ny][nx]-map[y][x]) >= L && Math.abs(map[ny][nx]-map[y][x]) <= R) {
                    q.add(new Node(ny,nx));
                    visited[ny][nx] = true;
                }
            }
        }

        if(list.size() != 1) {
            count++;
        }

        for(int i=0;i<list.size();i++) {
            Node cur = list.get(i);
            y = cur.y;
            x = cur.x;
            map[y][x] = sum/list.size();
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        while (count != 0) {
            count = 0;
            visited = new boolean[N][N];
            ans++;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(!visited[i][j]) {
                        bfs(i,j);
                    }
                }
            }
        }
        System.out.println(ans-1);
    }
}