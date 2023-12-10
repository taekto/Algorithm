import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr = new int[1000][1000];

    static StringBuilder sb = new StringBuilder();

    static boolean check(int y, int x, int size) {
        for(int i=y;i<y+size;i++) {
            for(int j=x;j<x+size;j++) {
                if(arr[y][x] != arr[i][j]) return false;
            }
        }
        return true;
    }

    static void recursive(int y, int x, int size) {
        if(check(y,x,size)) {
            sb.append(arr[y][x]);
            return;
        }

        sb.append("(");

        int newsize = size/2;

        for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++) {
                recursive(y+newsize*i,x+newsize*j,newsize);
            }
        }

        sb.append(")");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<N;j++) {
                int a = Integer.parseInt(String.valueOf(s.charAt(j)));
                arr[i][j] = a;
            }
        }
        recursive(0,0,N);

        System.out.println(sb.toString());

    }
}