package D2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class swea_1983_taekto_fail1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 T
		int T = sc.nextInt();
		

		
		for(int g=1;g<=T;g++) {
			// 학생수 N, 학생번호 K\
			int N = sc.nextInt();
			int K = sc.nextInt();
			// 점수 저장할 공간
			float[] arr = new float[N];
			
			// K의 값을 저장할 공간
			Float dataK = (float) 0;
			for(int i=0;i<N;i++) {
				// 과목 a, b, c 받기
				Float a = sc.nextFloat();
				Float b = sc.nextFloat();
				Float c = sc.nextFloat();
				// 평균 값 구하기
				Float data = (a/100)*35 + (b/100)*45 + (c/100)*20;
				
				// 학생번호가 K일때 값 저장
				
				if(i == K-1) {
					dataK = data;
				}
				// 리스트로는 왜안되지?
				
				arr[i] = data;
			}
			// 정렬하기, 값을 담을 상자 하나 만들기
			float box = 0;
			
			for(int i=0;i<N;i++) {
				for(int j=i;j<N;j++) {
					if(arr[i] < arr[j]) {
						box = arr[i];
						arr[i] = arr[j];
						arr[j] = box;

					}
					
				}
			}
			
			int index = 0;
			// 값이 똑같은지 확인하여 인덱스값 저장하기
			for(int i=0;i<N;i++) {
				if(dataK == arr[i]) {
					index = i;
				}
				
				
			}
			
			
			if(index == 0) {
				System.out.print('#'+g+" "+'A');
				System.out.println("+");
				break;
			}
			else if(index == 1) {
				System.out.print('#'+g+" "+'A');
				System.out.println("0");	
				break;
			}
			else if(index == 2) {
				System.out.print('#'+g+" "+'A');
				System.out.println("-");	
				break;
			}
			else if(index == 3) {
				System.out.print('#'+g+" "+'B');
				System.out.println("+");		
				break;
			}
			else if(index == 4) {
				System.out.print('#'+g+" "+'B');
				System.out.println("0");	
				break;
			}
			else if(index == 5) {
				System.out.print('#'+g+" "+'B');
				System.out.println("-");		
				break;
			}
			else if(index == 6) {
				System.out.print('#'+g+" "+'C');
				System.out.println("+");	
				break;
			}
			else if(index == 7) {
				System.out.print('#'+g+" "+'C');
				System.out.println("0");		
				break;
			}
			else if(index == 8) {
				System.out.print('#'+g+" "+'C');
				System.out.println("-");		
				break;
			}
			else if(index == 9) {
				System.out.print('#'+g+" "+'D');
				System.out.println("0");		
				break;
			}
			else {
				
			}
			
			System.out.println(g);
			
			
			
			
		}
		}

}
