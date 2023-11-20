import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[10];

        for(int i=0;i<s.length();i++) {
            int a = s.charAt(i) - '0';
            arr[a]++;
        }

        if((arr[6]+arr[9])%2 == 1) {
            arr[6] = (arr[6]+arr[9])/2 + 1;
            arr[9] = 0;
        }
        else {
            arr[6] = (arr[6]+arr[9])/2 ;
            arr[9] = 0;
        }

        int max = -1;

        for(int i=0;i<10;i++) {
            max = Math.max(arr[i], max);
        }

        System.out.println(max);

    }
}
