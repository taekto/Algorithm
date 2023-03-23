import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class People {
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
	public People(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	
	public People() {
		
	}
	
}

public class Main {
	public static int N, M;
	public static int[][] arr;
	
	public static void bfs(int y, int x) {
		Queue<People> q = new LinkedList<>();
		// 상하 좌우
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};
		q.offer(new People(y, x));
		
		while(!q.isEmpty()) {
			People people = q.poll();
			x = people.getX();
			y = people.getY();
			
			for(int i=0;i<4;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny>=0 && nx>= 0 && ny<N && nx<M) {
					if(arr[ny][nx] == 1) {
						arr[ny][nx] = arr[y][x] + 1;
						q.offer(new People(ny, nx));
					}
				}
			}
		}
	}
	
	
	
	private static People People(int ny, int nx) {
		// TODO Auto-generated method stub
		return null;
	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			String str = sc.nextLine();
			for(int j=0;j<M;j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(0,0);
		
		System.out.println(arr[N-1][M-1]);
		
		
		
		
	}
}
