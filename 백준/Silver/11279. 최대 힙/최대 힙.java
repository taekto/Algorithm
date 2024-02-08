import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            int command = Integer.parseInt(br.readLine());
            if(command == 0) {
                if(!heap.isEmpty()) {
                    System.out.println(heap.poll());
                }
                else {
                    System.out.println(0);
                }
            }
            else {
                heap.add(command);
            }
        }
    }
}