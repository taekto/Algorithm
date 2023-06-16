import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 2차원 배열의 크기 N, 구간합 질의갯수M
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 일반숫자 
		int[][] arr = new int[N+1][N+1];
		// 더하기한 숫자
		int[][] sumarr = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sumarr[i][j] += arr[i][j]+sumarr[i-1][j]+sumarr[i][j-1]-sumarr[i-1][j-1];
			}
		}
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			System.out.println(sumarr[x2][y2]-sumarr[x2][y1-1]-sumarr[x1-1][y2]+sumarr[x1-1][y1-1]);
		}
		
		
		
	}
}