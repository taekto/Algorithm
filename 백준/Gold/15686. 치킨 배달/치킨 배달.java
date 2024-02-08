import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        int y;
        int x;
        int distance;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
        public Node(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
    static int N, M;
    static List<Node> home = new ArrayList<>();
    static List<Node> chicken = new ArrayList<>();
    static int[][] map;
    static boolean[][] visited;
    static int[] arr;
    static int ans = Integer.MAX_VALUE;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void func(int depth, int idx) {
        if(depth == M) {
            bfs();
            return;
        }

        if(idx == chicken.size()) return;

        arr[depth] = idx;
        func(depth+1, idx+1);
        arr[depth] = 0;
        func(depth, idx+1);

    }

    static void bfs() {
        visited = new boolean[N][N];
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<arr.length;i++) {
            Node cur = chicken.get(arr[i]);
            visited[cur.y][cur.x] = true;
            q.add(cur);
        }
        int sum = 0;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            for(int i=0;i<4;i++) {
                int ny = cur.y+dy[i];
                int nx = cur.x+dx[i];
                if(ny >= N || nx >= N || ny < 0 || nx < 0) continue;
                if(!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new Node(ny, nx, cur.distance+1));
                    if(map[ny][nx] == 1) sum += cur.distance+1;
                }
            }
        }
        ans = Math.min(ans, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if(a == 0) continue;
                if(a == 2) chicken.add(new Node(i,j));
                if(a == 1) home.add(new Node(i, j));
            }
        }
        arr = new int[M];
        func(0,0);
        System.out.println(ans);
    }
}