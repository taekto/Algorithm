import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int ans = 0;
    static int[][] tech1 = {{1,1,1,1}};
    static int[][] tech2 = {{1,1},{1,1}};
    static int[][] tech3 = {{1, 0}, {1, 0}, {1, 1}};
    static int[][] tech4 = {{1, 0}, {1, 1}, {0, 1}};
    static int[][] tech5 = {{1, 1, 1}, {0, 1, 0}};

    static int[][] curve(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] copyarr = new int[n][m];
        for(int i=0;i<n;i++) {
            copyarr[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        arr = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                arr[i][j] = copyarr[n-1-j][i];
            }
        }
        return arr;
    }

    static int[][] mirror(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] copyarr = new int[n][m];
        for(int i=0;i<n;i++) {
            copyarr[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                arr[i][j] = copyarr[i][m-1-j];
            }
        }
        return arr;
    }

    static boolean check(int[][] arr, int y, int x) {
        int n = arr.length;
        int m =arr[0].length;
        if(y+n > N || m+x > M) return false;
        return true;
    }

    static void func(int[][] arr, int y, int x) {
        int n = arr.length;
        int m = arr[0].length;
        int count = 0;
        for(int i=y;i<y+n;i++) {
            for(int j=x;j<x+m;j++) {
                if(arr[i-y][j-x] == 1) {
                    count+=map[i][j];
                }
            }
        }
        ans = Math.max(ans, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0;k<8;k++) {
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(check(tech1,i,j)) {
                        func(tech1,i,j);
                    }
                    if(check(tech2,i,j)) {
                        func(tech2,i,j);
                    }
                    if(check(tech3,i,j)) {
                        func(tech3,i,j);
                    }
                    if(check(tech4,i,j)) {
                        func(tech4,i,j);
                    }
                    if(check(tech5,i,j)) {
                        func(tech5,i,j);
                    }
                }
            }
            tech1 = curve(tech1);
            tech2 = curve(tech2);
            tech3 = curve(tech3);
            tech4 = curve(tech4);
            tech5 = curve(tech5);
            if(k == 3) {
                tech1 = mirror(tech1);
                tech2 = mirror(tech2);
                tech3 = mirror(tech3);
                tech4 = mirror(tech4);
                tech5 = mirror(tech5);
            }
        }

        System.out.println(ans);
    }
}