import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++) {
            leftStack.add(String.valueOf(s.charAt(i)));
        }

        int m = Integer.parseInt(br.readLine());

        for(int i=0;i<m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if(a.equals("P")) {
                leftStack.add(st.nextToken());
            }
            else if(a.equals("L")) {
                if(!leftStack.isEmpty()) {
                    rightStack.add(leftStack.pop());
                }
            }
            else if(a.equals("B")) {
                if(!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            }
            else if(a.equals("D")) {
                if(!rightStack.isEmpty()) {
                    leftStack.add(rightStack.pop());
                }
            }
        }

        int size = leftStack.size();

        while(!leftStack.isEmpty()) {
            rightStack.add(leftStack.pop());
        }

        int resultsize = rightStack.size();
        for(int i=0;i<resultsize;i++) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb.toString());
    }
}