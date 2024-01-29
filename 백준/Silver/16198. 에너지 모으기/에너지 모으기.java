import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static int N;
    static List<Integer> list;
    static int max = Integer.MIN_VALUE;

    static void func(int sum) {
        if(list.size() == 3) {
            sum += list.get(0)*list.get(2);
            max = Math.max(sum, max);
            return;
        }

        for(int i=1;i<list.size()-1;i++) {
            sum+=list.get(i-1)*list.get(i+1);
            int a = list.remove(i);
            func(sum);
            list.add(i,a);
            sum -= list.get(i-1)*list.get(i+1);

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        func(0);
        System.out.println(max);
    }
}