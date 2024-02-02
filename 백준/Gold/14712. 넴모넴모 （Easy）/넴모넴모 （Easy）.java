import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int N, M;
    static int count = 0;

    static void func(int depth) {
        if(depth == N*M) {
            count++;
            return;
        }

        int y = depth/M+1;
        int x = depth%M+1;

        if(map[y-1][x] == 0 || map[y-1][x-1] == 0 || map[y][x-1] == 0) {
            map[y][x] = 1;
            func(depth+1);
            map[y][x] = 0;
        }

        func(depth+1);

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        func(0);
        System.out.println(count);
    }
}