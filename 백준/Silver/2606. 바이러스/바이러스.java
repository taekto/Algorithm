import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static boolean[] visited;
	public static List<Integer> result = new ArrayList<>();
	public static List<List<Integer>> list;
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visited[x] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int i=0;i<list.get(node).size();i++) {
				if(!visited[list.get(node).get(i)]) {
					visited[list.get(node).get(i)] = true;
					result.add(list.get(node).get(i));
					q.offer(list.get(node).get(i));
				}
			}
		}
		
	}
		
		
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 컴퓨터 수
		int N = sc.nextInt();
		// 연결된 쌍의 수
		int M = sc.nextInt();
		visited = new boolean[N+1];
		list = new ArrayList<>();
//		리스트 초기화 하기
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
//		System.out.println(list);
		bfs(1);
		System.out.println(result.size());
		
	}
}
