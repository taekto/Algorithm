import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// col , row 받기
		int col = sc.nextInt();
		int row = sc.nextInt();
		int[][] arr = new int[row][col];
		
		int num = 2;
		int x = 0;
		int y = 0;
		arr[y][x] = 1;
		while(num != col*row+1) {
			
			if(y+1 < row && arr[y+1][x] == 0) {
				arr[y+1][x] = num++;
				y++;
				continue;
			}
			if(x+1 < col && arr[y][x+1] == 0) {
				arr[y][x+1] = num++;
				x++;
				continue;
			}
			if(y-1>=0 && arr[y-1][x] == 0) {
				arr[y-1][x] = num++;
				y--;
				continue;
			}
			while(true) {
				if(arr[y][x-1] != 0) break;
				if(arr[y][x-1] == 0) {
					arr[y][x-1] = num++;
					x--;
				}
			}
		}
//		System.out.println(Arrays.toString(arr[0]));
//		System.out.println(Arrays.toString(arr[1]));
//		System.out.println(Arrays.toString(arr[2]));
//		System.out.println(Arrays.toString(arr[3]));
//		System.out.println(Arrays.toString(arr[4]));
//		System.out.println(Arrays.toString(arr[5]));
		
		
		outer :for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(arr[i][j] == 0) arr[i][j] = num;
				break outer;
			}
		}
		int searchnum = sc.nextInt();
		int searchx = 0;
		int searchy = 0;
		
		outer :for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(arr[i][j] == searchnum) {
					searchx = j;
					searchy = i;
					break outer;
				}
			}
		}
		
		if(col*row >= searchnum) {
			System.out.printf("%d %d\n",searchx+1, searchy+1);
		}
		else {
			System.out.println(0);
		}
		
		
	}
}
