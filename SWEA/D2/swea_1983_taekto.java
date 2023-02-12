package D2;

import java.util.Arrays;
import java.util.Scanner;

public class swea_1983_taekto {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			// 성적 저장할 arr 배열 만들기
			double[] arr = new double[N];
			double data = 0;
			double dataK = 0;
			
			// 성적값 arr 배열에 저장하기
			for(int j=0;j<N;j++) {
				double a = sc.nextDouble();
				double b = sc.nextDouble();
				double c = sc.nextDouble();
				
				data = a*35/100 + b*45/100 + c*20/100;
				
				if(j == (K-1)) {
					dataK = data;
				}
				
				arr[j] = data;
				
			}
			
			double box = 0;
			
			// 내림차순 정렬
			for(int j=0;j<N;j++) {
				for(int k=j;k<N;k++) {
					
					if(arr[j] < arr[k]) {
						box = arr[j];
						arr[j] = arr[k];
						arr[k] = box;
					}
					
				}
			}
			
			// dataK를 이용해서 dataK의 인덱스 구하기
			int index = 0;
			for(int j=0;j<N;j++) {
				if(arr[j] == dataK) {
					index = j;
				}
			}
			// 구간을 나눌 binary 정의
			int binary = N/10;
			
			// 구간별로 등급나누기
			if( 0 <= index & index <= binary-1 ) {
				System.out.println("#"+i+" "+"A+");
			}
			else if(binary <= index & index <= 2*binary-1) {
				System.out.println("#"+i+" "+"A0");
			}
			else if(2*binary <= index & index <= 3*binary-1) {
				System.out.println("#"+i+" "+"A-");
			}
			else if(3*binary <= index & index <= 4*binary-1) {
				System.out.println("#"+i+" "+"B+");
			}
			else if(4*binary <= index & index <= 5*binary-1) {
				System.out.println("#"+i+" "+"B0");
			}
			else if(5*binary <= index & index <= 6*binary-1) {
				System.out.println("#"+i+" "+"B-");
			}
			else if(6*binary <= index & index <= 7*binary-1) {
				System.out.println("#"+i+" "+"C+");
			}
			else if(7*binary <= index & index <= 8*binary-1) {
				System.out.println("#"+i+" "+"C0");
			}
			else if(8*binary <= index & index <= 9*binary-1) {
				System.out.println("#"+i+" "+"C-");
			}
			else {
				System.out.println("#"+i+" "+"D0");
			}
			
			
			
			
		}
		
		
		
	}

}
