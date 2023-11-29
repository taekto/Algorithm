import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{
        int now;
        int count;
        public int getCount() {
            return count;
        }

        public int getNow() {
            return now;
        }

        @Override
        public int compareTo(Node o) {
            if(this.count == o.count) {
                return this.now-o.now;
            }
            else {
                return this.count-o.count;
            }
        }

        public Node(int now, int count) {
            this.now = now;
            this.count = count;
        }

    }

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] dist = new int[200001];
    static boolean[] visited = new boolean[200001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        pq.offer(new Node(N,0));
        visited[N] = true;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.getNow();
            int count = cur.getCount();
            if(now == K) {
                System.out.println(count);
                break;
            }

//            System.out.println("now : "+now+" count : "+count);

            if(now*2 <= 200000 && visited[now*2] == false) {
                visited[now*2] = true;
                pq.offer(new Node(now*2, count));
            }

            if(now-1 >= 0 && visited[now-1] == false) {
                visited[now-1] = true;
                pq.offer(new Node(now-1, count+1));
            }
            if(now+1 <= 200000 && visited[now+1] == false) {
                visited[now+1] = true;
                pq.offer(new Node(now+1, count+1));
            }
        }
    }
}