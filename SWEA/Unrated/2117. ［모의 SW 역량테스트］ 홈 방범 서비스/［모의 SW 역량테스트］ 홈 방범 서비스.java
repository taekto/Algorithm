import java.util.Scanner;

public class Solution {
	public static int N, M;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int result = 0;
	
	// K는 크기임
	public static int start(int y, int x, int K) {
		
		visited = new boolean[N][N];
		
		K -= 1;
		for(int i=y-K;i<=y+K;i++) {
			for(int j=x-K;j<=x+K;j++) {
				if(i < 0 || j < 0 || i >= N || j >= N) continue;
				int hap = Math.abs(y-i) + Math.abs(x - j);
				if(hap <= K) {
					visited[i][j] = true;
				}
			}
		}
		int result1 = 0;
		int count = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j] == true && arr[i][j] == 1) count++;
			}
		}
		
		if(K == 0) {
			result1 = M*count - 1;
		}
		else {
			result1 = M*count - K*K - (K+1)*(K+1);
		}
		
		
		if(result1 >= 0) {
			return count;
		}
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j] = sc.nextInt();
				} 
			}
			
			for(int k=1;k<=2*N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						result = Math.max(result, start(i,j,k));
					}
				}
			}
			
			System.out.println("#"+tc+" "+result);
			result = 0;
			
			
		}
	}
}