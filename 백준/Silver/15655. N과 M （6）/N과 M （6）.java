import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static int N, M;
	public static List<Integer> list = new ArrayList<>();
	public static int[] temp;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int count, int idx) {
		if(count == M) {
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					sb.append(list.get(i)+" ");
				}
			}
			sb.append("\n");
			return;
		}
		if(idx == N) {
			return;
		}
//		중복없이 두개 고르는 조합
		visited[idx] = true; 
		dfs(count+1, idx+1);
		visited[idx] = false;
		dfs(count, idx+1);
		
//		for(int i=0;i<N;i++) {
//			if(!visited[i]) {
//				visited[i] = true;
//				temp[count] = list.get(i);
//				dfs(count+1);
//				visited[i] = false;
//			}
//		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		temp = new int[M];
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			list.add(sc.nextInt());
		}
		list.sort(null);
		dfs(0, 0);
		System.out.println(sb);
	}
	
}
