import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static boolean[] visited;
    static int[] ans;
    static int N;
    static List<Long> list = new ArrayList<>();

    static void func(int target, int depth, long sum) {
        if(target == depth) {
            list.add(sum);
            return;
        }

        for(int i=0;i<=9;i++) {
            if(!visited[i]) {
                if(depth == 0) {
                    visited[i] = true;
                    func(target, depth+1, i);
                    visited[i] = false;
                }
                else {
                    if(sum%10 > i) {
                        visited[i] = true;
                        func(target, depth+1, sum*10+i);
                        visited[i] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[10];

        for(int i=1;i<=10;i++) {
            func(i, 0, 0);
        }
        if(N-1 >= list.size()) {
            System.out.println(-1);
        }
        else {
            System.out.println(list.get(N-1));
        }
    }
}