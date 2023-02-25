import java.util.Arrays;
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		// 스위치 입력받기
		int[] arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = sc.nextInt();
		}
		
		// 학생수 student 입력받기
		int student = sc.nextInt();
		
		for(int i=0;i<student;i++) {
			// 성별과 받은수
			int gender = sc.nextInt();
			int num = sc.nextInt();
			int index = 0;
			if(gender == 1) {
				while(true) {
					index += num;
					if(index > N) break;
					if(index%num == 0) {
						if(arr[index] == 1) {
							arr[index] = 0;
						}
						else if(arr[index] == 0) {
							arr[index] = 1;
						}
					}
				}
			}
			else if(gender == 2) {
				// 일단 받은 숫자의 상태는 무조건 바뀜
				if(arr[num] == 0) {
					arr[num] = 1;
				}
				else if(arr[num] == 1) {
					arr[num] = 0;
				}
				// 포인터 정의
				int left = -1;
				int right = 1;
				while(true) {
					if(num+left <= 0 || num+right > N || arr[num+right] != arr[num+left]) {
						break;
					}
					if(arr[num+right] == arr[num+left]) {
						if(arr[num+right] == 0) arr[num+right] = 1;
						else arr[num+right] = 0;
						if(arr[num+left] == 0) arr[num+left] = 1;
						else arr[num+left] = 0;
						left--;
						right++;
					} 
				}
			}
//			System.out.println(Arrays.toString(arr));
		}
		
		for(int i=1;i<=N;i++) {
			System.out.print(arr[i]+" ");
			if(i%20 == 0) {
				System.out.println();
			}
		}
	 }
}
