import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=N;i++) {
            q.offer(i);
        }

        if(N == 1) {
            System.out.println(1);
        }
        else {
            while (true) {
                q.poll();

                if(q.size() == 1) {
                    System.out.println(q.poll());
                    break;
                }

                q.offer(q.poll());

            }
        }

    }
}