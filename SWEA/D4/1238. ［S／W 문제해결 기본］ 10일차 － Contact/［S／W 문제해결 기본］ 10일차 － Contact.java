import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static boolean[] visited;
	public static List<List<Integer>> location;
	public static List<Node> resultlist;
	
	public static class Node implements Comparable<Node> {
		int num;
		int time;
		public Node(int num, int time) {
			super();
			this.num = num;
			this.time = time;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.time < o.time) return -1;
			if(this.time == o.time) {
				if(this.num < o.num) return -1;
				if(this.num == o.num) return 0;
				if(this.num > o.num) return 1;
			}
			return 1;
		}
	}
	
	
	
	public static void bfs(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int now = 1;
		pq.offer(new Node(start, now));
		resultlist.add(new Node(start, now));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int num = cur.num;
			int time = cur.time;
			visited[num] = true;
			for(int i=0;i<location.get(num).size();i++) {
				int a = location.get(num).get(i);
				if(!visited[a]) {
					pq.offer(new Node(a, time+1));
					resultlist.add(new Node(a, time+1));
				}
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			location = new ArrayList<>();
			resultlist = new ArrayList<>();
			visited = new boolean[101];
			// 데이터의 길이 N
			int N = sc.nextInt();
			// 시작점 start
			int start = sc.nextInt();
			for(int i=0;i<=100;i++) {
				List<Integer> temp = new ArrayList<>();
				location.add(temp);
			}
			for(int i=0;i<N/2;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				location.get(a).add(b);
			}
			bfs(start);
			resultlist.sort(null);
			System.out.println("#"+tc+" "+resultlist.get(resultlist.size()-1).num);
		}
	}
}
