import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static int K;
	public static int magnet, direction;
	public static int[][] arr;
	
	public static void rotate(int[] insidearr, int direction) {
		if(direction == 1) {
//			System.out.println(123);
			int a = insidearr[7];
			for(int i=6;i>=0;i--) {
				insidearr[i+1] = insidearr[i];
			}
			insidearr[0] = a;
		}
		else if(direction == -1) {
			int a = insidearr[0];
			for(int i=1;i<=7;i++) {
				insidearr[i-1] = insidearr[i];
			}
			insidearr[7] = a;
		}
	}
	
	public static void start() {
//		System.out.println(123123123);
		magnet = magnet-1;
		boolean[] tf = new boolean[4];
		tf[magnet] = true;
		if(magnet == 0) {
			if(arr[0][2] != arr[1][6]) tf[1] = true;
			if(arr[1][2] != arr[2][6]) tf[2] = true;
			if(arr[2][2] != arr[3][6]) tf[3] = true;
			
			if(tf[0] == true) {
				rotate(arr[0], direction);
				if(tf[1] == true) {
					rotate(arr[1], -direction);
					if(tf[2] == true) {
						rotate(arr[2], direction);
						if(tf[3] == true) {
							rotate(arr[3], -direction);
						}
					}
				}
			}
		}
		else if(magnet == 1) {
			if(arr[1][6] != arr[0][2]) tf[0] = true;
			if(arr[1][2] != arr[2][6]) tf[2] = true;
			if(arr[2][2] != arr[3][6]) tf[3] = true;
			if(tf[1] == true) {
				rotate(arr[1], direction);
			}
			if(tf[0] == true) {
				rotate(arr[0], -direction);
			}
			if(tf[2] == true) {
				rotate(arr[2], -direction);
				if(tf[3] == true) {
					rotate(arr[3], direction);
				}
			}
		}
		else if(magnet == 2) {
			if(arr[2][6] != arr[1][2]) tf[1] = true;
			if(arr[2][2] != arr[3][6]) tf[3] = true;
			if(arr[1][6] != arr[0][2]) tf[0] = true;
			if(tf[2] == true) {
				rotate(arr[2], direction);
			}
			if(tf[3] == true) {
				rotate(arr[3], -direction);
			}
			if(tf[1] == true) {
				rotate(arr[1], -direction);
				if(tf[0] == true) {
					rotate(arr[0], direction);
				}
			}
		}
		else if(magnet == 3) {
			if(arr[3][6] != arr[2][2]) tf[2] = true;
			if(arr[2][6] != arr[1][2]) tf[1] = true;
			if(arr[1][6] != arr[0][2]) tf[0] = true;
			
			if(tf[3] == true) {
				rotate(arr[3], direction);
				if(tf[2] == true) {
					rotate(arr[2], -direction);
					if(tf[1] == true) {
						rotate(arr[1], direction);
						if(tf[0] == true) {
							rotate(arr[0], -direction);
						}
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
			// 자석을 회전시키는 횟수 
			K = sc.nextInt();
			// 초기화 하기
			arr = new int[4][8];
			
			// 각각의 초기상태 집어넣기
			for(int i=0;i<4;i++) {
				for(int j=0;j<8;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0;i<K;i++) {
				magnet = sc.nextInt();
				direction = sc.nextInt();
				start();
			}
			
			int[] resultarr = new int[4];
			for(int i=0;i<4;i++) {
				resultarr[i] = arr[i][0];
			}
			int result = 0;
			for(int i=0;i<4;i++) {
				if(resultarr[i] == 0) continue;
				if(resultarr[i] == 1) {
					if(i == 0) result += 1;
					else if(i == 1) result += 2;
					else if(i == 2) result += 4;
					else if(i == 3) result += 8;
				}
			}
			
			
			System.out.println("#"+tc+" "+result);
		}
	}
}