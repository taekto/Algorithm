import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static List<List<Integer>> list = new ArrayList<>();
	public static int N, M, V;
	public static boolean[] visited;
	
	public static void dfs(int start) {
		
		visited[start] = true;
		System.out.print(start+" ");
		for(int i=0;i<list.get(start).size();i++) {
			if(!visited[list.get(start).get(i)]) {
				visited[list.get(start).get(i)] = true;
				dfs(list.get(start).get(i));
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node+" ");
			if(!list.get(node).isEmpty()) {
				for(int i=0;i<list.get(node).size();i++) {
					int num = list.get(node).get(i);
					if(!visited[num]) {
						visited[num] = true;
						q.add(num);
					}
				}
			}
		}
		System.out.println();
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		visited = new boolean[N+1];
		for(int i=0;i<=N;i++) {
			List<Integer> temp = new ArrayList<>();
			list.add(temp);
		}
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}
		for(int i=0;i<=N;i++) {
			list.get(i).sort(null);
		}
		
		
		dfs(V);
		visited = new boolean[N+1];
		System.out.println();
		bfs(V);
	}
}
