import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int N, M;
	public static int[] arr;
	public static boolean[] visited;
	
	
	
	public static void dfs(int start) {
		if(start == M) {
			for(int val : arr) {
				System.out.print(val+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[start] = i;
				dfs(start+1);
				visited[i] = false;
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		visited = new boolean[N+1];
		dfs(0);
	}
	

	
}
