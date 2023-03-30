import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static int N;
	public static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int ans;
    
    
	public static class Node implements Comparable<Node> {
		int y, x, distance;

		public Node(int y, int x, int distance) {
			super();
			this.y = y;
			this.x = x;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}
	
	public static void dijkstra(int starty, int startx) {
		int[][] distance = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		
		distance[starty][startx] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(starty, startx, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int x = cur.x;
			int y = cur.y;
			
			if(visited[y][x]) continue;
			visited[y][x] = true;
			
			for(int i=0;i<4;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (visited[ny][nx]) continue;
				int dist = cur.distance + arr[ny][nx];
                if (distance[ny][nx] > dist) {
                    distance[ny][nx] = dist;
                    pq.offer(new Node(ny, nx, dist));
                }
			}
		}
		ans=distance[N-1][N-1];
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			// 지도의 크기 N
			N = sc.nextInt();
			arr = new int[N][N];
			for(int i=0;i<N;i++) {
				String str = sc.next();
				for(int j=0;j<N;j++) {
					arr[i][j] = str.charAt(j)-'0';
				}
			}
			
			dijkstra(0,0);
			System.out.println("#"+tc+" "+ans);
			
			
			
		}
	}
}
