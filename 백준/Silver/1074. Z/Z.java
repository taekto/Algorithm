import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int recursive(double row, double col, double n) {
        if(n == 1) {
            if(row == 0 && col == 0) {
                return 0;
            }
            if(row == 0 && col == 1) {
                return 1;
            }
            if(row == 1 && col == 0) {
                return 2;
            }
            if(row == 1 && col == 1) {
                return 3;
            }
        }

        int num = (int) Math.pow(2,n-1);

        if(row < num && col < num) {
            return recursive(row,col,n-1);
        }
        if(row < num && col >= num) {
            return recursive(row,col-num,n-1)+num*num;
        }
        if(row >= num && col < num) {
            return recursive(row-num,col,n-1)+2*num*num;
        }
        if(row >= num && col >= num) {
            return recursive(row-num,col-num,n-1)+3*num*num;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(recursive(r,c,N));

    }
}