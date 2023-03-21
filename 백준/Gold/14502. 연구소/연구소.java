import java.util.Scanner;

public class Main {
	public static int N, M;
	public static int result = 0;
	public static int[][] arr = new int[8][8];
	public static int[][] temp = new int[8][8];

	// 바이러스 퍼지는거 구현
	public static void virus(int y, int x) {
		// 상하 좌우
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};
		
		if(temp[y][x] == 1 ) {
			return;
		}
		
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(nx>=0 && nx<M && ny>=0 && ny<N) {
				if(temp[ny][nx] == 0) {
					temp[ny][nx] = 2;
					virus(ny, nx);
				}
			}
		}
	}
	
	// 안전구역 구하기
	public static int safezone() {
		int result = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(temp[i][j] == 0) {
					result +=1;
				}
			}
		}
		return result;
	}
	
	public static void dfs(int count) {
		if(count == 3) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					temp[i][j] = arr[i][j];
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(temp[i][j] == 2) {
						virus(i, j);
					}
				}
			}
			result = Math.max(result, safezone());
			return;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					count += 1;
					dfs(count);
					arr[i][j] = 0;
					count -= 1;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dfs(0);
		System.out.println(result);
	}
}
