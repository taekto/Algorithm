import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int st;
        int ed;
        public Node(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }
        @Override
        public int compareTo(Node o) {
            if(this.ed < o.ed) return -1;
            else if(this.ed > o.ed) return 1;
            else {
                return this.st-o.st;
            }
        }
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new Node(a,b));
        }
        int ans = 0;
        int pre = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.st >= pre) {
                ans++;
                pre = cur.ed;
            }
        }
        System.out.println(ans);
    }
}