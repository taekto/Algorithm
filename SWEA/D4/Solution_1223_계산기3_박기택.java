package D4;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Solution_1223_계산기3_박기택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=1;i<=10;i++) {
			int N = sc.nextInt();
			String str = sc.next();
			
			Stack<Character> operator = new Stack<>();
			Stack<Character> stack = new Stack<>();
			int isp = 0;
			int icp = 0;
			for(int j=0;j<str.length();j++) {
				if(!operatortf(str.charAt(j))) {
					stack.push(str.charAt(j));
				}
				else if(str.charAt(j) == '(') {
					icp = icp(str.charAt(j));
					operator.push(str.charAt(j));
					isp = isp(str.charAt(j));
				}
				else if(str.charAt(j) == ')') {
					while(true) {
						System.out.println(operator);
						char c = operator.pop();
						if(c == '(') {
							break;
						}
						else {
							stack.push(c);
						}
					}
				}
				else if(operatortf(str.charAt(j))) {
                    icp = icp(str.charAt(j));
                    if(icp > isp) {
                        operator.push(str.charAt(j));
                        isp = isp(str.charAt(j));
                    }
                    else {
                    	char d = operator.pop();
                    	if(d == '(') {
                    		operator.add(d);
                    	}
                    	else {
                            stack.push(d);
                            operator.push(str.charAt(j));
                            isp = isp(str.charAt(j));
                    	}
                    }
				}
			}
			while(!operator.isEmpty()) {
				stack.push(operator.pop());
			}
			System.out.println(stack);
			
			// 숫자담기
			Stack<Integer> numstack = new Stack<>();
			int sum = 0;
			for(int j=0;j<stack.size();j++) {
				if(!(operatortf(stack.get(j)))) {
					numstack.push(Integer.parseInt(String.valueOf(stack.get(j))));
				}
				else if(stack.get(j) == '+') {
					int b = numstack.pop();
					int a = numstack.pop();
					sum = a + b;
					numstack.push(sum);
				}
				else if(stack.get(j) == '*') {
					int b = numstack.pop();
					int a = numstack.pop();
					sum = a * b;
					numstack.push(sum);
				}
				else if(stack.get(j) == '-') {
					int b = numstack.pop();
					int a = numstack.pop();
					sum = a - b;
					numstack.push(sum);
				}
				else if(stack.get(j) == '/') {
					int b = numstack.pop();
					int a = numstack.pop();
					sum = a / b;
					numstack.push(sum);
				}
			}
			System.out.println("#"+i+" "+sum);
			
			
		}
	}
	
	public static boolean operatortf(char a) {
		if(a == '+' || a == '-' || a == '/' || a == '*' || a ==')' || a == '(') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int isp(char a) {
		if(a == '+' | a == '-') {
			return 1;
		}
		else if(a == '/' | a == '*') {
			return 2;
		}
		else if(a == '(') {
			return 0;
		}
		else {
			return -100;
		}
	}
	
	public static int icp(char a) {
		if(a == '+' | a == '-') {
			return 1;
		}
		else if(a == '/' | a == '*') {
			return 2;
		}
		else if(a == '(') {
			return 3;
		}
		else {
			return -100;
		}
	}
	
	
	
	
}
