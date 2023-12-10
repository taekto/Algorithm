import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[2200][2200];

    static int[] cnt = new int[3];

    static boolean check(int y, int x, int size) {
        for(int i=y;i<y+size;i++) {
            for(int j=x;j<x+size;j++) {
                if(arr[y][x] != arr[i][j]) return false;
            }
        }
        return true;
    }

    static void recursive(int y,int x, int size) {

        if(check(y,x,size)) {
            cnt[arr[y][x]+1] +=1;
            return;
        }

        int newsize = size/3;

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                recursive(y+i*newsize,x+j*newsize,newsize);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0,0,N);

        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
        System.out.println(cnt[2]);

    }
}