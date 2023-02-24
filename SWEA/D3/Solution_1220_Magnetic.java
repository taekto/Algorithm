package D3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_1220_Magnetic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=1;i<=10;i++) {
			// 테이블 크기 입력받기 N
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int j=0;j<100;j++) {
				for(int k=0;k<100;k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			// 1은 N극 2는 S극이고 1과 2만 담은 list 배열 생성
			List<List<Integer>> list = new ArrayList<>();
			for(int j=0;j<100;j++) {
				List<Integer> check = new ArrayList<>();
				for(int k=0;k<100;k++) {
					if(arr[k][j] != 0) {
						check.add(arr[k][j]);						
					}
				}
				list.add(check);
			}
			// 사이즈 담기
			int[] size = new int[100];
			for(int j=0;j<100;j++) {
				size[j] = list.get(j).size();
			}
			
//			System.out.println(list);
			// 맨앞이 2이면 제거 , 맨뒤가 1이면 제거
			for(int j=0;j<100;j++) {
				for(int k=0;k<size[j];k++) {
					if(list.get(j).get(0) == 2) {
						list.get(j).remove(0);
					}
					if(list.get(j).get(list.get(j).size()-1) == 1) {
						list.get(j).remove(list.get(j).size()-1);
					}
				}
			}
			
			int count = 0;
//			System.out.println(list);
			for(int j=0;j<100;j++) {
				int count1 = 0;
				int count2 = 0;
				for(int k=0;k<list.get(j).size()-1;k++) {
						if(list.get(j).get(k) == 1 && list.get(j).get(k+1) == 2) {
							count++;
					}
				}
			}
			System.out.println("#"+i+" "+count);
			
		}
	}
}
