import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static int N, B;
	public static int[] arr;
	public static boolean[] visited;
	public static int[] temp;
	public static int min = Integer.MAX_VALUE;
	
	public static void dfs(int count) {
		if(count == N) {
			
			int result = 0;
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					result += arr[i];
				}
			}
			if(result - B >= 0) {
				min = Math.min(result-B, min);
			}
			else {
				return;
			}
			
			return;
		}
		
//		for(int i=0;i<N;i++) {
//			if(!visited[i]) {
//				visited[i] = true;
//				dfs(count+1);
//				visited[i] = false;
//			}
//		}
		visited[count] = true;
		dfs(count+1);
		visited[count] = false;
		dfs(count+1);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테케 T
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			// 점원수 N
			N = sc.nextInt();
			// 높이가 B이상인 탑
			B = sc.nextInt();
			arr = new int[N];
			visited = new boolean[N];
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=1;i<=N;i++) {
				dfs(0);
			}
			
			System.out.println("#"+tc+" "+min);
			min = Integer.MAX_VALUE;

		}
	}
}
