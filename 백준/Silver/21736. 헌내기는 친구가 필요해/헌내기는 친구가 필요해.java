import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int y;
		int x;
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

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
		
	}
	
	static char[][] arr;
	static boolean[][] visited;
	
	static int N, M;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int count = 0;
  	
	static void bfs(int y, int x) {
		Queue<Node> q = new LinkedList<>();
		visited[y][x] = true;
		q.add(new Node(y, x));

		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			y = cur.getY();
			x = cur.getX();
			
			for(int i=0;i<4;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				else if(visited[ny][nx] == false && arr[ny][nx] == 'O') {
					visited[ny][nx] = true;
					q.add(new Node(ny,nx));
				}
				else if(visited[ny][nx] == false && arr[ny][nx] == 'P') {
					visited[ny][nx] = true;
					q.add(new Node(ny,nx));
					count++;
				}
			}
			
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		visited = new boolean[N][M];
		int starty = 0;
		int startx = 0;
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				char a = str.charAt(j);
				if(a == 'I') {
					starty = i;
					startx = j;
				}
				arr[i][j] = a;
			}
		}
		
		bfs(starty, startx);
		if(count == 0) {
			System.out.println("TT");
		} else {
			System.out.println(count);
		}
		
		
	}
}