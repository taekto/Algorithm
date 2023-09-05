import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] arr;
	static boolean[][] visited;
	static int N, M;
	static int count = 0;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void dfs(int y, int x) {
		
		visited[y][x] = true;
		
		if(arr[y][x] == 'P') {
			count++;
		}
		
		for(int i=0;i<4;i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;
			if(ny >= 0 && ny < N && nx >= 0 && nx < M && arr[ny][nx] != 'X' && visited[ny][nx] == false) {
				dfs(ny, nx);
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
		int y = 0;
		int x = 0;
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j) == 'I') {
					y = i;
					x = j;
				}
				arr[i][j] = str.charAt(j);
			}
		}
		
		dfs(y, x);
		if(count == 0) {
			System.out.println("TT");
		}
		else {
			System.out.println(count);
		}
		
	}
}