import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        for(int i=0;i<N;i++) {
            String s = br.readLine();
            map.put(s, i+1);
            map2.put(i+1, s);
        }
        for(int i=0;i<M;i++) {
            String s = br.readLine();
            if(Character.isDigit(s.charAt(0))) {
                System.out.println(map2.get(Integer.parseInt(s)));
            }
            else {
                System.out.println(map.get(s));
            }
        }
    }
}