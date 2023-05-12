import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Node {
		int y;
		int x;
		
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
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		
		
	}
	
	static boolean[][] visited;
	static int M;
	static int N;
	static int[][] arr;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static void bfs(int y, int x) {
		Queue<Node> q = new LinkedList();
		
		q.add(new Node(y,x));
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			y = cur.getY();
			x = cur.getX();
			for(int i=0;i<4;i++) {
				int ny = dy[i]+y;
				int nx = dx[i]+x;
				if(ny<0 || nx <0 || ny>=N || nx >= M) continue;
				if(!visited[ny][nx] && arr[ny][nx] == 1) {
					visited[ny][nx] = true;
					q.add(new Node(ny,nx));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			//가로 M 세로 N
			M = sc.nextInt();
			N = sc.nextInt();
			int K = sc.nextInt();
			
			arr = new int[N][M];
			visited = new boolean[N][M];
			for(int j=0;j<K;j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[y][x] = 1;
			}
			
			int count = 0;
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(!visited[j][k] && arr[j][k] == 1) {
						bfs(j,k);
						count++;
					}
				}
			}
			System.out.println(count);
			
			
		}
	}
}