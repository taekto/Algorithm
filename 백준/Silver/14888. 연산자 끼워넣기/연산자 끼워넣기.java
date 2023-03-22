import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static int[] arr;
	public static char[] temp;
	public static boolean[] visited;
	public static List<Character> operator = new ArrayList<Character>();
	public static boolean[] operatorvisited;
	public static char[] operatorarr;
	public static int N;
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	
	
	
	public static void arrdfs(int count) {
		if(count == N-1) {
			Stack<Integer> stack = new Stack<>();
			for(int i=arr.length-1;i>=0;i--) {
				stack.add(arr[i]);
			}
			int result = 0;
			
			for(int i=temp.length-1;i>=0;i--) {
				int a = stack.pop();
				int b = stack.pop();
				if(temp[i] == '+') {
					result = a+b;
					stack.add(result);
				}
				else if(temp[i] == '-') {
					result = a-b;
					stack.add(result);
				}
				else if(temp[i] == '/') {
					result = a/b;
					stack.add(result);
				}
				else if(temp[i] == '*') {
					result = a*b;
					stack.add(result);
				}
			}
			max = Math.max(stack.get(0), max);
			min = Math.min(stack.get(0), min);
			
			
			return;
		}
		
		for(int i=0;i<N-1;i++) {
			if(!operatorvisited[i]) {
				operatorvisited[i] = true;
				temp[count] = operator.get(i);
				arrdfs(count+1);
				operatorvisited[i] = false;
				temp[count] = ' ';
			}
		}
		return;
		
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 수의 개수 N
		N = sc.nextInt();
		
		arr = new int[N];
		temp = new char[N-1];
		visited = new boolean[N];
		operatorarr = new char[N-1];
		operatorvisited = new boolean[N-1];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		
		for(int i=0;i<A;i++) {
			operator.add('+');
		}
		for(int i=0;i<B;i++) {
			operator.add('-');
		}
		for(int i=0;i<C;i++) {
			operator.add('*');
		}
		for(int i=0;i<D;i++) {
			operator.add('/');
		}
		arrdfs(0);
		System.out.println(max);
		System.out.println(min);
		
	}
	
	
}
