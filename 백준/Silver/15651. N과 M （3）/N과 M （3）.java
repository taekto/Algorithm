import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int N, M;
	public static int[] arr;
	public static boolean[] visited;
	public static int[] temp;
	public static StringBuilder sb = new StringBuilder();

	
	public static void dfs(int count, int idx) {
		if(count == M) {
			for(int i=0;i<temp.length;i++) {
				sb.append(temp[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=idx;i<N;i++) {
			temp[count] = arr[i]; 
			dfs(count+1,idx);
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		temp = new int[M];
		for(int i=0;i<N;i++) {
			arr[i] = i+1;
		}
		
//		System.out.println(Arrays.toString(arr));
		dfs(0, 0);
		System.out.println(sb);
		
	}
}
