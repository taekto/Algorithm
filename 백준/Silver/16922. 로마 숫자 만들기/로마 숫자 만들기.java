import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    static int[] arr = {1, 5, 10, 50};
    static int N;
    static HashSet<Integer> hashSet = new HashSet<>();
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited = new boolean[4];
    static void dfs(int depth, int sum, int start) {
        if(depth == N) {
            if(!list.contains(sum)) list.add(sum);
            return;
        }

        for(int i=start;i<4;i++) {
            sum += arr[i];
            dfs(depth+1, sum, i);
            sum -= arr[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(0,0,0);
        System.out.println(list.size());

    }
}