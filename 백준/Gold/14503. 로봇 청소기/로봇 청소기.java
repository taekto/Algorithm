import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int y, x, direction;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] arr;

    static boolean OOB(int y, int x) {
        if(y < 0 || x < 0 || y >= N || x >= M) return false;
        return true;
    }
    static boolean isClean() {

        for(int i=0;i<4;i++) {
            int ny = y+dy[i];
            int nx = x+dx[i];
            if( ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            if(arr[ny][nx] == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        int count = 0;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if(arr[y][x] == 0) {
                arr[y][x] = 2;
                count++;
                continue;
            }
            if(isClean()) {
                int ny = y+dy[(direction+2)%4];
                int nx = x+dx[(direction+2)%4];
                if(OOB(ny,nx) && arr[ny][nx] != 1) {
                    y = ny;
                    x = nx;
                }
                else if(arr[ny][nx] == 1) break;
            }
            else {
                direction+=3;
                int ny = y+dy[direction%4];
                int nx = x+dx[direction%4];
                if(OOB(ny,nx) && arr[ny][nx] == 0) {
                    y = ny;
                    x = nx;
                }
            }
        }
        System.out.println(count);
    }
}