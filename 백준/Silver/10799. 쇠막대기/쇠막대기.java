import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int result = 0;

        Stack<Character> stack = new Stack<>();

        boolean isRazor = true;

        for(int i=0;i<s.length();i++) {

            char a = s.charAt(i);

            if(a == '(') {
                stack.add(a);
                isRazor = true;
            }
            else if(a == ')') {
                if(isRazor) {
                    isRazor = false;
                    stack.pop();
                    result += stack.size();
                }
                else {
                    stack.pop();
                    result += 1;
                }
            }
        }
        System.out.println(result);

    }
}