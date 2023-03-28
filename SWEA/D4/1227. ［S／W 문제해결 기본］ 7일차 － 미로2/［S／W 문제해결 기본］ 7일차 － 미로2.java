import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Node {
	private int y;
	private int x;
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

public class Solution {
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	
	public static void dfs(int y, int x) {
		Stack<Node> stack = new Stack<>();
		stack.push(new Node(y, x));
		visited[y][x] = true;
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			int py = node.getY();
			int px = node.getX();
			for(int i=0;i<4;i++) {
				int ny = py + dy[i];
				int nx = px + dx[i];
				if(nx<0 && ny < 0 && nx >= 16 && ny >= 16) continue;
				if(arr[ny][nx] == 0 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					stack.push(new Node(ny,nx));
				}
			}
		}
	}
	
	public static void bfs(int y, int x) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(y, x));
		visited[y][x] = true;
		while(!q.isEmpty()) {
			Node node = q.poll();
			int py = node.getY();
			int px = node.getX();
			for(int i=0;i<4;i++) {
				int ny = py + dy[i];
				int nx = px + dx[i];
				if(nx<0 && ny < 0 && nx >= 16 && ny >= 16) continue;
				if(arr[ny][nx] == 0 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					q.offer(new Node(ny,nx));
				}
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			int a = sc.nextInt();
			int startx = 0;
			int starty = 0;
			int endx = 0;
			int endy = 0;
			arr = new int[100][100];
			visited = new boolean[100][100];
			
			for(int i=0;i<100;i++) {
				String str = sc.next();
				for(int j=0;j<100;j++) {
					arr[i][j] = str.charAt(j) - '0';
					if(arr[i][j] == 2) {
						startx = j;
						starty = i;
					}
					if(arr[i][j] == 3) {
						endx = j;
						endy = i;
						arr[i][j] = 0;
					}
				}
			}
//			System.out.println(startx);
//			System.out.println(starty);
//			System.out.println(endx);
//			System.out.println(endy);
			bfs(starty, startx);
//			for(int i=0;i<16;i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
			if(visited[endy][endx]) {
				System.out.println("#"+tc+" "+1);
			}
			else {
				System.out.println("#"+tc+" "+0);
			}
			
			
		}
	}
}
