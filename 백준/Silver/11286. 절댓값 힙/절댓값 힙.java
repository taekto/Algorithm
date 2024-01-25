import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static class Node implements Comparable<Node> {
        int num;

        @Override
        public int compareTo(Node o) {

            if(Math.abs(this.num) < Math.abs(o.num)) {
                return -1;
            }
            else if(Math.abs(this.num) == Math.abs(o.num)) {
                if(this.num < o.num) {
                    return -1;
                }
                return 1;
            }
            else {
                return 1;
            }
        }

        public Node(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++) {
            int a = Integer.parseInt(br.readLine());
            if(a == 0) {
                if(pq.isEmpty()) {
                    System.out.println(0);
                }
                else {
                    System.out.println(pq.poll().num);

                }
            }
            else {
                pq.add(new Node(a));
            }
        }
    }
}