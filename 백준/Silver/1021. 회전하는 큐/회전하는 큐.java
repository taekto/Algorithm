import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=1;i<=N;i++) {
            deque.add(i);
        }

        int[] arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for(int i=0;i<M;i++) {

            int s = arr[i];

            while (true) {

                int a = deque.peekFirst();
                if(a == s) {
                    deque.pollFirst();
                    break;
                }

                int left = 0;
                int right = 0;

                int location = deque.indexOf(s);
                right = location;
                left = deque.size() - right;
//                System.out.println("i번째"+i);
//                System.out.println("right"+right);
//                System.out.println("left"+left);
//                System.out.println("size"+deque.size());

                if(left > right) {
                    deque.offerLast(deque.pollFirst());
                    count++;

                }
                else {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}