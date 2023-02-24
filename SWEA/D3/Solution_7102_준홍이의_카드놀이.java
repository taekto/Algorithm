package D3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_7102_준홍이의_카드놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테케 T
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			// N과 M 입력받기
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arr = new int[10000];
			
			
			for(int j=1;j<=N;j++) {
				for(int k=1;k<=M;k++) {
					int a = j+k;
					arr[a] += 1;
				}
			}
			
			//max값 찾기
			int max = 0;
			for(int j=0;j<arr.length;j++) {
				if(arr[j] > max) {
					max = arr[j];
				}
			}
			System.out.print("#"+i+" ");
//			낮은거 부터 출력
			for(int j=0;j<arr.length;j++) {
				if(arr[j] == max) {
					System.out.print(j+" ");
				}
			}
			System.out.println();
			
			
			
			
		}
	}
}
