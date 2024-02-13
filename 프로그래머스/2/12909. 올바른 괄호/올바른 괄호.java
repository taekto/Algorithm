import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char a = s.charAt(i);
            if(a == '(') {
                stack.add(a);
            }
            else {
                if(stack.isEmpty()) {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }
        if(stack.size() > 0) return false;

        return true;
    }
}