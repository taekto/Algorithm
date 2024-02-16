import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int left = 0;
        int right = 0;
        for(int i=0;i<s.length()/2;i++) {
            left += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        for(int i=s.length()/2;i<s.length();i++) {
            right += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        if(left == right) {
            System.out.println("LUCKY");
        }
        else {
            System.out.println("READY");
        }

    }
}