import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static char[] dir;
    static int N, K, L;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static boolean OOB(int y, int x) {
        if(y > N || x > N || y <= 0 || x <= 0) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        K = Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 2;
        }

        dir = new char[10001];
        Arrays.fill(dir, 'X');
        L = Integer.parseInt(br.readLine());
        for(int i=0;i<L;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            dir[x] = c;
        }

        map[1][1] = 1;
        int direction = 0;
        int size = 1;
        int ans = 0;
        int y = 1;
        int x = 1;
        int tail = 0;
        List<Integer> listy = new ArrayList<>();
        List<Integer> listx = new ArrayList<>();
        listy.add(1);
        listx.add(1);

        while (true) {
            if(dir[ans] == 'L') direction += 3;
            else if(dir[ans] == 'D') direction += 1;
            int ny = y+dy[direction%4];
            int nx = x+dx[direction%4];
            if(OOB(ny, nx) || map[ny][nx] == 1) {
                ans++;
                break;
            }
            if(map[ny][nx] == 2) {
                size++;
                map[ny][nx] = 1;
            }
            if(map[ny][nx] == 0) {
                map[ny][nx] = 1;
                int taily = listy.get(tail);
                int tailx = listx.get(tail);
                map[taily][tailx] = 0;
                tail++;
            }
            listy.add(ny);
            listx.add(nx);
            y = ny;
            x = nx;
            ans++;
//            for(int i=1;i<=N;i++) {
//                for(int j=1;j<=N;j++) {
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
        System.out.println(ans);
    }
}