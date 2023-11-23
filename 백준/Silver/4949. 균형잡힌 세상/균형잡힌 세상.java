import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s = br.readLine();

            Stack<String> stack = new Stack<>();

            Boolean flag = true;

            if(s.equals(".")) {
                break;
            }
            else {
                for(int i=0;i<s.length();i++) {
                    String a = String.valueOf(s.charAt(i));

                    if(a.equals(".")) {
                        break;
                    }

                    if(a.equals("[") || a.equals("(")) {
                        stack.add(a);
                    }
                    else if(a.equals("]")) {
                        if(stack.isEmpty()) {
                            flag = false;
                            break;
                        }
                        else {
                            String b = stack.peek();
                            if(b.equals("[")) {
                                stack.pop();
                            }
                            else {
                                flag = false;
                                break;
                            }
                        }
                    }
                    else if(a.equals(")")) {
                        if(stack.isEmpty()) {
                            flag = false;
                            break;
                        }
                        else {
                            String b = stack.peek();
                            if(b.equals("(")) {
                                stack.pop();
                            }
                            else {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                if(!stack.isEmpty()) {
                    flag = false;
                }

                if(flag) {
                    System.out.println("yes");
                }
                else {
                    System.out.println("no");
                }
            }
        }
    }
}