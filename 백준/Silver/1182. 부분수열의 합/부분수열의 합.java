import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int N, S;
	public static int[] arr;
	public static boolean[] visited;
	public static int result = 0;
	
	public static void combination(int count) {
		if(count == N) {
//			System.out.println(Arrays.toString(visited));
			int sum = 0;
			for(int i=0;i<N;i++) {
				if(visited[i]) {
//					System.out.print(arr[i]+" ");
					sum+=arr[i];
				}
			}
//			System.out.println();
			if(sum == S) {
				result++;
			}
			return;
		}
		
//		for(int i=idx;i<N;i++) {
//			visited[count] = true;
//			combination(count+1, idx+1);
//			visited[count] = false;
//			combination()
//		}
		visited[count] = true;
		combination(count+1);
		visited[count] = false;
		combination(count+1);
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		combination(0);
        if (S == 0) System.out.println(result - 1); // S 0일때 처리 
        else  System.out.println(result);
		
	}
}
