import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    stack.add(num);
                    continue;
                case "top":
                    if(!stack.isEmpty()) {
                        System.out.println(stack.peek());
                    } else {
                        System.out.println(-1);
                    }
                    continue;
                case "size":
                    System.out.println(stack.size());
                    continue;
                case "empty":
                    if (!stack.isEmpty()) {
                        System.out.println(0);
                    }
                    else {
                        System.out.println(1);
                    }
                    continue;
                case "pop":
                    if(!stack.isEmpty()) {
                        System.out.println(stack.pop());
                    }
                    else {
                        System.out.println(-1);
                    }
            }
        }
    }
}