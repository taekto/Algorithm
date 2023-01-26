package DoitJava;

import java.util.Arrays;
import java.util.Scanner;

public class boj1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 과목의 갯수 N개 값 받기
		int N = sc.nextInt();
		// N개의 자리를 가진 배열 만들기
		float[] arr = new float[N];
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextFloat();
		}
		
		// max값 탐색
		float max = arr[0];
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		
		float result = 0;
		for(int i=0;i<arr.length;i++) {
			result += (arr[i]/max)*100;
		}
		float avg = result/arr.length;
		System.out.println(avg);
}
}
