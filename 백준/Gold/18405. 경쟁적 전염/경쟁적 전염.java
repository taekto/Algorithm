import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static int[][] arr;
	public static int N, K;
	public static int S, X, Y;
	public static List<List<Integer>> location = new ArrayList<>();
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,-1,1};
	
	
	public static void dfs(int second, List<List<Integer>> locationlist) {
		if(second == S) return;
		List<List<Integer>> newlocation = new ArrayList<>();
		if(!locationlist.isEmpty()) {
			for(int j=0;j<locationlist.size();j++) {
				int y = locationlist.get(j).get(0);
				int x = locationlist.get(j).get(1);
				for(int k=0;k<4;k++) {
					List<Integer> list = new ArrayList<>();
					int ny = y+dy[k];
					int nx = x+dx[k];
					if(ny>=0 && nx>=0 && ny<N && nx<N) {
						if(arr[ny][nx] == 0) {
							arr[ny][nx] = arr[y][x];
							list.add(ny);
							list.add(nx);
						}
					}
					if(!list.isEmpty()) {
						newlocation.add(list);			
					}
				}
			}
		} else {
			return;
		}

		second += 1;
		dfs(second, newlocation);
	}
	
	public static void firstlocation() {
		for(int a=1;a<=K;a++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j] == a) {
						List<Integer> list = new ArrayList<>();
						list.add(i);
						list.add(j);
						location.add(list);
					}
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		S = sc.nextInt();
		X = sc.nextInt();
		Y = sc.nextInt();
		
		firstlocation();
		dfs(0, location);
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(arr[X-1][Y-1]);
		
	}
}
