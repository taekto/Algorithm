import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static List<String> list = new ArrayList<>();

    static void func(String s,int sum) {
        if(sum == n) {
            list.add(s.substring(0,s.length()-1));
        }

        if(sum+1<=n) {
            sum+=1;
            s+="1+";
            func(s,sum);
            sum-=1;
            s = s.substring(0,s.length()-2);
        }
        if(sum+2<=n) {
            sum+=2;
            s+="2+";
            func(s,sum);
            sum-=2;
            s = s.substring(0,s.length()-2);
        }
        if(sum+3<=n) {
            sum+=3;
            s+="3+";
            func(s,sum);
            sum-=3;
            s = s.substring(0,s.length()-2);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        func("",0);
        if(list.size() < k) {
            System.out.println(-1);
        }
        else {
            System.out.println(list.get(k-1));
        }

    }
}