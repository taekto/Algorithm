import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static String[][] arr;
	public static String[][] temp;
	public static int N;
	public static boolean[][] visited;
	public static boolean wholetf;
	
	// 벽 3개 세우기
	public static void dfs(int count) {
		if(count == 3) {
			boolean tf = true;
			
//			for(int i=0;i<N;i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
//			System.out.println();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j].equals("T")) {
						if(!detect(i, j)) {
							tf = false;
						}
					}
				}
			}
			if(tf) {
				wholetf = true;
			}
			
			return;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j].equals("X") && !visited[i][j]) {
					visited[i][j] = true;
					arr[i][j] = "O";
					dfs(count+1);
					visited[i][j] = false;
					arr[i][j] = "X";
				}
			}
		}
		
	}
	
	public static boolean detect(int y, int x) {
		// 상
		int up = 0;
		while(true) {
			if(y+up < 0 || arr[y+up][x].equals("O")) break;
			if(arr[y+up][x].equals("S")) return false;
			up--;
			
		}
		
		int down = 0;
		while(true) {
			if(y+down >= N || arr[y+down][x].equals("O")) break;
			if(arr[y+down][x].equals("S")) return false;
			down++;
		}
		
		int left = 0;
		while(true) {
			if(x+left < 0 || arr[y][x+left].equals("O")) break;
			if(arr[y][x+left].equals("S")) return false;
			left--;
			
		}
		
		int right = 0;
		while(true) {
			if(x+right >= N || arr[y][x+right].equals("O")) break;
			if(arr[y][x+right].equals("S")) return false;
			right++;
		}
		
		
		return true;
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new String[N][N];
		temp = new String[N][N];
		visited = new boolean[N][N];
		sc.nextLine();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = sc.next();
			}
		}
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		dfs(0);
		if(wholetf) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
