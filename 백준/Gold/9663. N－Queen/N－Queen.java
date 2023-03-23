import java.util.Scanner;

public class Main {
	public static int N;
	public static int[] arr;
	public static boolean[] visited1 = new boolean[40];
	public static boolean[] visited2 = new boolean[40];
	public static boolean[] visited3 = new boolean[40];
	public static int result = 0;
	
	// 이거는 왜 안됨?
//	public static void dfs(int count) {
//		if(count == N) {
//			result++;
//			return;
//		}
//		
//		for(int i=0;i<N;i++) {
//			if(visited1[count] || visited2[i+count] || visited3[i-count+N-1]) {
//				continue;
//			}
//			visited1[count] = true;
//			visited2[i+count] = true;
//			visited3[i-count+N-1] = true;
//			dfs(count+1);
//			visited1[count] = false;
//			visited2[i+count] = false;
//			visited3[i-count+N-1] = false;
//		}
//	}
	
	 // 이거는 왜 되고
	public static void dfs(int count) {
		if(count == N) {
			result++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visited1[i] || visited2[i+count] || visited3[count-i+N-1]) {
				continue;
			}
			visited1[i] = true;
			visited2[i+count] = true;
			visited3[count-i+N-1] = true;
			dfs(count+1);
			visited1[i] = false;
			visited2[i+count] = false;
			visited3[count-i+N-1] = false;
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		dfs(0);
		System.out.println(result);
		
		
		
	}
}
