import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int location;
        int second;
        public Node(int location, int second) {
            this.location = location;
            this.second = second;
        }

        public int getLocation() {
            return location;
        }

        public int getSecond() {
            return second;
        }

        public void setLocation(int location) {
            this.location = location;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[200001];
        boolean[] visited = new boolean[200001];

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));
        visited[N] = true;
        while(!q.isEmpty()) {

            Node cur = q.poll();
            int location = cur.getLocation();
            int second = cur.getSecond();
            if(location == K) {
                System.out.println(second);
                break;
            }
            if(location+1 <= 200000 && visited[location+1] == false) {
                visited[location+1] = true;
                q.offer(new Node(location+1,second+1));
            }
            if(location-1 >= 0 && visited[location-1] == false) {
                visited[location-1] = true;
                q.offer(new Node(location-1,second+1));
            }
            if(2*location <= 200000 && visited[2*location] == false) {
                visited[2*location] = true;
                q.offer(new Node(2*location,second+1));
            }
        }
    }
}