import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int[][] arr;
	public static boolean[][] visited;
	public static List<List<Node>> resultlist = new ArrayList<>();
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	public static int result = Integer.MAX_VALUE;
	
	public static class Node {
		int y;
		int x;
		int island;
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
		public int getIsland() {
			return island;
		}
		public void setIsland(int island) {
			this.island = island;
		}
		public Node(int y, int x, int island) {
			super();
			this.y = y;
			this.x = x;
			this.island = island;
		}
	}
	
	public static void bfs(int y, int x, int islandnum) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(y,x, islandnum));
		visited[y][x] = true;
		List<Node> list = new ArrayList<>();
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			y = cur.y;
			x = cur.x;
			islandnum = cur.island;
			boolean flag = false;
			for(int i=0;i<4;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || nx < 0 || nx >= N || ny >= N) continue;
				if(arr[ny][nx] == 1 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					q.offer(new Node(ny,nx,islandnum));
				}
				if(arr[ny][nx] == 0) flag = true;
			}
			if(arr[y][x] == 1 && flag == true) {
				list.add(new Node(y,x,islandnum));
			}
		}
		resultlist.add(list);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int island = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					bfs(i,j,island);
					island += 1;
				}
			}
		}
		
		for(int i=0;i<resultlist.size()-1;i++) {
			for(int j=i+1;j<resultlist.size();j++) {
				for(int k=0;k<resultlist.get(i).size();k++) {
					for(int m=0;m<resultlist.get(j).size();m++) {
						int ay = resultlist.get(i).get(k).getY();
						int ax = resultlist.get(i).get(k).getX();
						int by = resultlist.get(j).get(m).getY();
						int bx = resultlist.get(j).get(m).getX();
						int distance = Math.abs(ay-by) + Math.abs(ax-bx);
						result = Math.min(result, distance);
					}
				}
			}
		}
		System.out.println(result-1);
		
	}
}