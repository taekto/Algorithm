import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        HashMap<String, String> hm = new HashMap<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            hm.put(a,b);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
            String str = br.readLine();
            sb.append(hm.get(str)).append("\n");
        }
        System.out.println(sb.toString());
    }
}