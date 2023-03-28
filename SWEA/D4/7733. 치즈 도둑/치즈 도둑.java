import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Node(int y, int x) {
		super();
		this.x = x;
		this.y = y;
	}
}


public class Solution {
	public static int N;
	public static int[][] arr;
	public static int[][] temp;
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	public static int result = 1;
	
	
	// 치즈덩어리 1부터 100인거 지우는 과정
	public static void erase() {
		for(int i=1;i<=100;i++) {
			int num = 0;
			boolean[][] visited = new boolean[N][N];
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(arr[j][k] == i) {
						arr[j][k] = 0;
					}
					else {
						continue;
					}
				}				
			}
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(!visited[j][k] && arr[j][k] != 0) {
						bfs(j,k,visited);
						num++;
					}
					else {
						continue;
					}
				}				
			}
			result = Math.max(num, result);
		}
	}
	
	public static void bfs(int y, int x, boolean[][] visited) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(y, x));
		visited[y][x] = true;
		while(!q.isEmpty()) {
			Node node = q.poll();
			int py = node.getY();
			int px = node.getX();
			for(int i=0;i<4;i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(!visited[ny][nx] && arr[ny][nx] != 0) {
					q.offer(new Node(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 T
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			erase();
			
			System.out.println("#"+tc+" "+result);
			result = 1;
			
		}
		
	}
}
