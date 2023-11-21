import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=N;i++) {
            q.add(i);
        }
        Queue<Integer> result = new LinkedList<>();

        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            count++;
            if(count == K) {
                result.add(q.poll());
                count = 0;
                continue;
            }
            q.add(q.poll());
        }

        System.out.print("<");
        while(!result.isEmpty()) {
            if(result.size() == 1) {
                System.out.print(result.poll());
                continue;
            }
            System.out.print(result.poll()+", ");
        }
        System.out.print(">");

    }
}