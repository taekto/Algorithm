package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj_13300_방_배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] malearr = new int[7];
		int[] femalearr = new int[7];
		for(int i=0;i<N;i++) {
			// 성별 S, 학년 Y
			int S = sc.nextInt();
			int Y = sc.nextInt();
			
			if(S == 0) {
				femalearr[Y]++;
			}
			else {
				malearr[Y]++;
			}
		}
		int count = 0;
		
		for(int i=1;i<malearr.length;i++) {
			count += malearr[i]/K;
			malearr[i] = malearr[i]%K;
			if(malearr[i] > 0) {
				count++;
			}
		}
		
		for(int i=1;i<femalearr.length;i++) {
			count += femalearr[i]/K;
			femalearr[i] = femalearr[i]%K;
			if(femalearr[i] > 0) {
				count++;
			}
		}
		System.out.println(count);
		
	}
}
