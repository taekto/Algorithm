import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[5][5];
		// 빙고판 만들기
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int result = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<25;i++) {
			int a = sc.nextInt();
			erase(map, a);
			int count = 0;
			int bingo = bingo(map, count);
			if(bingo >= 3) {
				result = a;
				list.add(i);
			}
		}
		System.out.println(list.get(0)+1);
	}
	public static void erase(int[][] map, int a) {
		outer : for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(map[i][j] == a) {
					map[i][j] = 0;
					break outer;
				}
			}
		}
	}
	
	public static int bingo(int[][] map, int bingo) {
		// 가로 찾기
		bingo = 0;
		for(int i=0;i<5;i++) {
			int count = 0;
			for(int j=0;j<5;j++) {
				if(map[i][j] == 0) {
					count++;
				}
			}
			if(count == 5) {
				bingo++;
			}
		}
		
		for(int i=0;i<5;i++) {
			int count = 0;
			for(int j=0;j<5;j++) {
				if(map[j][i] == 0) {
					count++;
				}
			}
			if(count == 5) {
				bingo++;
			}
		}
		
		for(int i=0;i<1;i++) {
			int count = 0;
			for(int j=0;j<5;j++) {
				if(map[j][j] == 0) {
					count++;
				}
			}
			if(count == 5) {
				bingo++;
			}
		}
		for(int i=0;i<1;i++) {
			int count = 0;
			for(int j=0;j<5;j++) {
				if(map[j][4-j] == 0) {
					count++;
				}
			}
			if(count == 5) {
				bingo++;
			}
		}
		return bingo;
	}
}
