import java.util.*;
import java.io.*;

class Solution
{
    
    static Stack<Character> stack = new Stack<>();
    
    public int solution(String s)
    {
        int answer = -1;
        
        
        for(int i=0;i<s.length();i++) {
            char a = s.charAt(i);
            if(stack.isEmpty()) {
                stack.add(a);
            }
            else {
                if(a == stack.peek()) {
                    stack.pop();
                }
                else {
                    stack.add(a);
                }
            }
        }
        if(stack.size() > 0) {
            answer = 0;
        }
        else {
            answer = 1;
        }

        return answer;
    }
}