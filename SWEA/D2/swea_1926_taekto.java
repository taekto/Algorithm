package D2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea_1926_taekto {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 숫자 입력 받기
		int N = sc.nextInt();
		
		
		for(int i=1;i<=N;i++) {
			// i 값을 String 형식으로 바꾸기
			String str = Integer.toString(i);
			// 숫자안에 3 ,6, 9가 몇개인지 저장할 count 정의
			int count = 0;
			
			// count 값 세기
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j) == '3' | str.charAt(j) == '6' | str.charAt(j) == '9') {
					count += 1;
				}	
			}
			
			// 카운트값이 1이상이면 '-'형식으로 출력되고 count값만큼 출력하기
			if(count >= 1) {
				
				for(int a=0;a<count;a++) {
					System.out.print('-');
				}
				
			}
			else {
				System.out.print(str);
			}
			
			System.out.print(" ");
			
			
				
			
		}
		
		
		
		
	}

}
