import java.util.Scanner;

public class Solution {
	// 재료의 수 N
	public static int N;
	// 제한 칼로리 L
	public static int L;
	public static int[] score;
	public static int[] kcal;
	public static boolean[] visited;
	public static int result = 0;
	
	public static void dfs(int count) {
		if(count == N) {
			int scoreresult = 0;
			int kcalresult = 0;
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					scoreresult+=score[i];
					kcalresult+= kcal[i];
				}
			}
			
			if(kcalresult <= L) {
				result = Math.max(scoreresult, result);
			}
			return;
		}
		
		visited[count] = true;
		dfs(count+1);
		visited[count] = false;
		dfs(count+1);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			score = new int[N];
			kcal = new int[N];
			visited = new boolean[N];
			for(int i=0;i<N;i++) {
				score[i] = sc.nextInt();
				kcal[i] = sc.nextInt();
			}
			
			dfs(0);
			System.out.println("#"+tc+" "+result);
			result = 0;
			
			
			
		}
	}
	
	
	
	
}
