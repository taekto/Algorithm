import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int R,C;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[][] map;
    static HashSet<Character> hashSet = new HashSet<>();
    static int ans = 0;
    static void func(int y, int x) {
        ans = Math.max(ans, hashSet.size());

        for(int i=0;i<4;i++) {
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
            if(!hashSet.contains(map[ny][nx])) {
                hashSet.add(map[ny][nx]);
                func(ny, nx);
                hashSet.remove(map[ny][nx]);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int i=0;i<R;i++) {
            String str = br.readLine();
            for(int j=0;j<C;j++) {
                map[i][j] = str.charAt(j);
            }
        }

        hashSet.add(map[0][0]);
        func(0,0);
        System.out.println(ans);
    }
}