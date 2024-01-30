import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[] visited;
    static boolean[] position;
    static int[] ans;
    static int max;
    static void func(int depth) {
        if(depth == 11) {
            int sum = 0;
            for(int i=0;i<11;i++) {
                sum += ans[i];
//                System.out.print(ans[i]+" ");
//                System.out.print(visited[i]+" ");
            }
            max = Math.max(max, sum);
            return;
        }

        for(int i=0;i<11;i++) {
            if(!visited[depth] && !position[i] && map[depth][i] != 0) {
                visited[depth] = true;
                position[i] = true;
                ans[depth] = map[depth][i];
                func(depth+1);
                visited[depth] = false;
                ans[depth] = 0;
                position[i] = false;
            }
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            map = new int[11][11];
            visited = new boolean[11];
            position = new boolean[11];
            ans = new int[11];
            max = Integer.MIN_VALUE;
            for(int r=0;r<11;r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int c=0;c<11;c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

//            for(int r=0;r<11;r++) {
//                for(int c=0;c<11;c++) {
//                    System.out.print(map[r][c]+" ");
//                }
//                System.out.println();
//            }

            func(0);
            System.out.println(max);
        }
    }
}