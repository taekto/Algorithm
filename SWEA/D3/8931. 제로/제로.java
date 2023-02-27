import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		// 테케 tc
		for(int tc=1;tc<=T;tc++) {
			
			int K = sc.nextInt();
			Stack<Integer> stack = new Stack<>();
			
			for(int j=0;j<K;j++) {
				int a = sc.nextInt();
				if(a == 0) {
					stack.pop();
				}
				else {
					stack.add(a);
				}
			}
			int sum = 0;
			
			for(int j=0;j<stack.size();j++) {
				sum += stack.get(j);
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}
}