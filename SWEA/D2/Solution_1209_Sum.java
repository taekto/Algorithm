package D3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1209_Sum_박기택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=1;i<=10;i++) {
			int N = sc.nextInt();
			
			int[][] arr = new int[100][100];
			
			for(int j=0;j<100;j++) {
				for(int k=0;k<100;k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			
			List<Integer> resultlist = new ArrayList<>();
			
			for(int j=0;j<100;j++) {
				int sum = 0;
				for(int k=0;k<100;k++) {
					sum += arr[j][k];
				}
				resultlist.add(sum);
			}
			
			for(int j=0;j<100;j++) {
				int sum = 0;
				for(int k=0;k<100;k++) {
					sum += arr[k][j];
				}
				resultlist.add(sum);
			}
			
			for(int j=0;j<1;j++) {
				int sum = 0;
				for(int k=0;k<100;k++) {
					sum += arr[k][k];
				}
				resultlist.add(sum);
			}
			
			for(int j=0;j<1;j++) {
				int sum = 0;
				for(int k=0;k<100;k++) {
					sum += arr[k][99-k];
				}
				resultlist.add(sum);
			}
			
			resultlist.sort(null);
//			System.out.println(resultlist);
			System.out.println("#"+i+" "+resultlist.get(resultlist.size()-1));
			
			
		}
		
	}

}
