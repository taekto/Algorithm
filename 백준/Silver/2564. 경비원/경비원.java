import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 가로, 세로 받기
		int x = sc.nextInt();
		int y = sc.nextInt();
		// 전체길이
		int size = 2*x+2*y;
		// 배열만들기
		int[] arr = new int[size];
		// 몇번 반복
		int N = sc.nextInt();
		for(int i=1;i<=N;i++) {
			int direction = sc.nextInt();
			int location = sc.nextInt();
			
			if(direction == 1) {
				arr[location] = i;
			}
			else if(direction == 2) {
				arr[-location+2*x+y] = i;
			}
			else if(direction == 3) {
				arr[-location+2*x+2*y] = i;
			}
			else if(direction == 4) {
				arr[location+x] = i;
			}
		}
		
		int startdirection = sc.nextInt();
		int startloaction = sc.nextInt();
		int start = 0;
		if(startdirection == 1) {
			arr[startloaction] = -1;
			start = startloaction;
		}
		else if(startdirection == 2) {
			arr[-startloaction+2*x+y] = -1;
			start = -startloaction+2*x+y;

		}
		else if(startdirection == 3) {
			arr[-startloaction+2*x+2*y] = -1;
			start = -startloaction+2*x+2*y;
		}
		else if(startdirection == 4) {
			arr[startloaction+x] = -1;
			start = startloaction+x;
		}
		int result = 0;
		for(int i=1;i<=N;i++) {
			int leftcount = 0;
			int rightcount = 0;
			int rightindex = 1;
			int leftindex = start-1;
			while(true) {
				
				if(arr[(start+rightindex)%size] == i) {
					rightcount++;
					break;
				}
				if(arr[(start+rightindex)%size] != i) {
					rightcount++;
					rightindex++;
				}
			}
			while(true) {
				
				if(arr[leftindex] == i) {
					leftcount++;
					break;
				}
				if(arr[leftindex] != i) {
					leftcount++;
					leftindex--;
				}
				if(leftindex <0 ) {
					leftindex = size-1;
				}
			}
			result += Math.min(leftcount, rightcount);
		}
		System.out.println(result);
		
	}
}
