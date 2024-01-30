import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int N, M;
    static int count = 0;
    static int max = Integer.MIN_VALUE;
    static void func(int depth, int sum) {
        if(depth == N*M) {
            max = Math.max(max, sum);
            return;
        }

        int y = depth/M;
        int x = depth%M;

        if(!visited[y][x]) {
            if(y+1 < N && x-1 >= 0 && !visited[y+1][x] && !visited[y][x-1]) {
                visited[y][x] = true;
                visited[y+1][x] = true;
                visited[y][x-1] = true;
                func(depth+1, map[y+1][x]+map[y][x-1]+map[y][x]*2+sum);
                visited[y][x] = false;
                visited[y+1][x] = false;
                visited[y][x-1] = false;
            }
            if(x-1 >= 0  && y-1 >= 0 && !visited[y-1][x] && !visited[y][x-1]) {
                visited[y][x] = true;
                visited[y-1][x] = true;
                visited[y][x-1] = true;
                func(depth+1, map[y-1][x]+map[y][x-1]+map[y][x]*2+sum);
                visited[y][x] = false;
                visited[y-1][x] = false;
                visited[y][x-1] = false;
            }
            if(x+1 < M  && y-1 >= 0 && !visited[y-1][x] && !visited[y][x+1]) {
                visited[y][x] = true;
                visited[y][x+1] = true;
                visited[y-1][x] = true;
                func(depth+1, map[y-1][x]+map[y][x+1]+map[y][x]*2+sum);
                visited[y][x] = false;
                visited[y][x+1] = false;
                visited[y-1][x] = false;
            }
            if(x+1 < M  && y+1 < N && !visited[y+1][x] && !visited[y][x+1]) {
                visited[y][x] = true;
                visited[y][x+1] = true;
                visited[y+1][x] = true;
                func(depth+1, map[y+1][x]+map[y][x+1]+map[y][x]*2+sum);
                visited[y][x] = false;
                visited[y][x+1] = false;
                visited[y+1][x] = false;
            }
        }
        func(depth+1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0,0);
        System.out.println(max);
    }
}