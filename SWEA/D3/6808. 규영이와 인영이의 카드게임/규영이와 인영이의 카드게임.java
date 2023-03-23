import java.util.Arrays;
import java.util.Scanner;



public class Solution {
	
	// 규영이
	public static int[] arr1;
	// 인영이
	public static int[] arr2;
	
	public static int resultcount1 = 0;
	public static int resultcount2 = 0;
	public static boolean[] visited;
	
	public static void dfs(int count, int idx) {
		if(count == 9) {
			int result1 = 0;
			int result2 = 0;
			
			for(int i=0;i<9;i++) {
				if(arr1[i] > arr2[i]) {
					result1 += arr1[i] + arr2[i];
				}
				else if(arr1[i] < arr2[i]) {
					result2 += arr1[i] + arr2[i];
				}
			}
			if(result1 > result2) {
				resultcount1 += 1;
			}
			else if(result1 < result2) {
				resultcount2 += 1;
			}
			return;
		}
		
		for(int i=1;i<=18;i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr2[idx] = i;
				dfs(count+1, idx+1);
				visited[i] = false;
				arr2[idx] = 0;
			} else {
				continue;
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1;tc<=T;tc++) {
			visited = new boolean[19];
			arr2 = new int[9];
			arr1 = new int[9];
			
			for(int i=1;i<=9;i++) {
				int num = sc.nextInt();
				arr1[i-1] = num;
				visited[num] = true;
			}
			dfs(0,0);

			System.out.println("#"+tc+" "+resultcount1+" "+resultcount2);

			resultcount1 = 0;
			resultcount2 = 0;
		}
		
	}
}
