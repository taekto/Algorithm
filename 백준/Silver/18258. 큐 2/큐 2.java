import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int last = 0;

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            switch (s) {
                case "push":
                    int a = Integer.parseInt(st.nextToken());
                    last = a;
                    q.add(a);
                    break;
                case "pop":
                    if(q.isEmpty()) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(q.poll()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if(q.isEmpty()) {
                        sb.append(1).append("\n");
                    }
                    else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if(q.isEmpty()) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(q.peek()).append("\n");
                    }
                    break;
                case "back":
                    if(q.isEmpty()) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(last).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}