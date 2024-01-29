import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] count = new int[100];
    static int N;
    static int result = 0;
    static char[] arr;

    static void func(int length) {
        if(length == N) {

            result++;
            return;
        }

        for(int i=49;i<=74;i++) {
            if(length == 0 && count[i] > 0) {
                arr[length] = (char) (i+'0');
                count[i] -= 1;
                func(length+1);
                count[i] += 1;
                arr[length] = 0;
            }
            if(length == 0) continue;
            if( (arr[length-1] != (char) (i+'0')) && count[i] > 0) {
                arr[length] = (char) (i+'0');
                count[i] -= 1;
                func(length+1);
                count[i] += 1;
                arr[length] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        N = s.length();
        arr = new char[N];
        for(int i=0;i<s.length();i++) {
            count[s.charAt(i)-'0']++;
        }
        func(0);
        System.out.println(result);
    }
}