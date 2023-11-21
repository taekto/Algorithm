import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i=0;i<tc;i++) {
            String s = br.readLine();

            Stack<String> leftStack = new Stack<>();
            Stack<String> rightStack = new Stack<>();

            for(int j=0;j<s.length();j++) {
                String a = String.valueOf(s.charAt(j));
                if(a.equals("<")) {
                    if(!leftStack.isEmpty()) {
                        rightStack.add(leftStack.pop());
                    }
                }
                else if(a.equals(">")) {
                    if(!rightStack.isEmpty()) {
                        leftStack.add(rightStack.pop());
                    }
                }
                else if(a.equals("-")) {
                    if(!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                }
                else {
                    leftStack.add(a);
                }
            }

            while(!leftStack.isEmpty()) {
                rightStack.add(leftStack.pop());
            }
            StringBuilder sb = new StringBuilder();
            while(!rightStack.isEmpty()) {
                sb.append(rightStack.pop());
            }

            System.out.println(sb.toString());

        }
    }
}