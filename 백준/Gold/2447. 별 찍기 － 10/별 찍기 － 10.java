import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static boolean[][] visited;
    static char[][] arr;

    static void recursive(int num, int sy, int ey, int sx, int ex) {
        int a = num/3;
        for(int i=sy+a;i<=ey-a;i++) {
            for(int j=sx+a;j<=ex-a;j++) {
                visited[i][j] = true;
            }
        }
        if(num == 3) return;

        recursive(a, sy, ey-2*a, sx, ex-2*a);
        recursive(a, sy, ey-2*a, sx+a, ex-a);
        recursive(a, sy, ey-2*a, sx+a*2, ex);
        recursive(a, sy+a, ey-a, sx, ex-2*a);
        recursive(a, sy+a, ey-a, sx+a*2, ex);
        recursive(a, sy+2*a, ey, sx, ex-2*a);
        recursive(a, sy+2*a, ey, sx+a, ex-a);
        recursive(a, sy+2*a, ey, sx+a*2, ex);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1][N+1];
        arr = new char[N+1][N+1];
        recursive(N, 1, N, 1, N);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(visited[i][j]) {
                    sb.append(" ");
                }
                else {
                    sb.append("*");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}