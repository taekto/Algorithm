import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int K, W, H;
	public static int[][] arr;
	public static boolean[][][] visited;
	public static int[] dy = {-1,-2,-2,-1,1,2,2,1,-1,1,0,0};
	public static int[] dx = {-2,-1,1,2,-2,-1,1,2,0,0,-1,1};
	public static int result = Integer.MAX_VALUE;
	
	
	public static class Node {
		private int y;
		private int x;
		private int jumpcnt;
		private int cnt;
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getJumpcnt() {
			return jumpcnt;
		}
		public void setJumpcnt(int jumpcnt) {
			this.jumpcnt = jumpcnt;
		}
		
		public int getCnt() {
			return cnt;
		}
		public void setCnt(int cnt) {
			this.cnt = cnt;
		}
		public Node(int y, int x, int jumpcnt, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.jumpcnt = jumpcnt;
			this.cnt = cnt;
		}
		
		
		
	}

	public static void bfs(int y, int x) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(y,x,0,0));
		visited[y][x][0] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			y = cur.getY();
			x = cur.getX();
			int cnt = cur.getCnt();
			int jumpcnt = cur.jumpcnt;
			
			for(int i=0;i<12;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				int distance = Math.abs(y-ny) + Math.abs(x-nx);
				
				if(ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
				if(arr[ny][nx] == 0 && distance <= 2 && !visited[ny][nx][jumpcnt]) {
					visited[ny][nx][jumpcnt] = true;
					q.offer(new Node(ny,nx,jumpcnt,cnt+1));
				}
				else if(arr[ny][nx] == 0 && distance >= 2 && jumpcnt < K && !visited[ny][nx][jumpcnt+1]) {
					visited[ny][nx][jumpcnt+1] = true;
					q.offer(new Node(ny, nx, jumpcnt+1, cnt+1));
				}
			}
			if(y == H-1 && x == W-1) {
				result = Math.min(result, cnt);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		arr = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		bfs(0,0);
		
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
		
	}
}