import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M,K;
    static boolean[][] visited;
    static int[][] map;
    static int max = Integer.MIN_VALUE;

    static void func(int k, int sum,int start) {
        if(k == K) {
            max = Math.max(sum, max);
//            System.out.println(sum);
//            for(int i=0;i<N;i++) {
//                for(int j=0;j<M;j++) {
//                    System.out.print(visited[i][j]+" ");
//                }
//                System.out.println();
//            }


            return;
        }

        for(int i=start;i<N*M;i++) {
            int y = i/M;
            int x = i%M;
            if(!visited[y][x]) {
                boolean isOk = true;
                if(y-1>=0 && visited[y-1][x]) isOk = false;
                if(y+1<N && visited[y+1][x]) isOk = false;
                if(x-1>=0 && visited[y][x-1]) isOk = false;
                if(x+1<M && visited[y][x+1]) isOk = false;
                if(isOk) {
                    visited[y][x] = true;
                    func(k+1,sum+map[y][x],i+1);
                    visited[y][x] = false;
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0,0,0);
        System.out.println(max);

    }
}