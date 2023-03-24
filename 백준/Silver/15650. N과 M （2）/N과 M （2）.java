import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int N, M;
	public static int[] arr;
	public static boolean[] visited;
	
	public static void combination(int count, int idx) {
		if(count == M) {
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		if(idx == N) {
			return;
		}
		
		visited[idx] = true;
		combination(count+1, idx+1);
		visited[idx] = false;
		combination(count, idx+1);
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			arr[i] = i+1;
		}
		
		combination(0,0);
		
		
	}
}
