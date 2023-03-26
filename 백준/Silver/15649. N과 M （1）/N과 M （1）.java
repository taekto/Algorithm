import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int N, M;
	public static boolean[] visited;
	public static int[] arr;
	
	public static void dfs(int count, int idx) {
		if(count == M) {
			for(int i=0;i<M;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[idx] = i+1;
				dfs(count+1, idx+1);
				visited[i] = false;
				arr[idx] = 0;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		visited = new boolean[N];
		dfs(0,0);
	}
}
