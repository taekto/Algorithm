import java.util.Scanner;

public class Solution {
	
	public static int N, K;
	public static int[] arr;
	public static boolean[] visited;
	public static int count;
	
	public static void dfs(int idx) {
		
		if(idx == N) {
			int result = 0;
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					result+=arr[i];
				}
			}
			if(result == K) {
				count++;
			}
			return;
		}
		
		visited[idx] = true;
		dfs(idx+1);
		visited[idx] = false;
		dfs(idx+1);
		return;
		
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			visited = new boolean[N];
			
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			
			dfs(0);
			System.out.println("#"+tc+" "+ count);
			count = 0;
		}
	}
}
