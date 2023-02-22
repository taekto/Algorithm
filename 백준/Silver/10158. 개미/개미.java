import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 격자판 크기
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		// 초기 좌표값 
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		// 시간 t
		int t = sc.nextInt();
		
		int[] timearr = new int[2];
		timearr[0] = t%(w*2);
		timearr[1] = t%(h*2);
		
		// t%(w*2), t%(h*2)하면 간단할것 같은데?
		
		while(true) {
			if(timearr[0] == 0) break;
			if(x+1 <= w) {
				x++;
				timearr[0]--;
			}
			if(x == w) {
				while(true) {
					if(timearr[0] == 0 | x == 0) break;
					x--;
					timearr[0]--;
				}
			}
		}
		while(true) {
			if(timearr[1] == 0) break;
			if(y+1 <= h) {
				y++;
				timearr[1]--;
			}
			if(y == h) {
				while(true) {
					if(timearr[1] == 0 | y == 0) break;
					y--;
					timearr[1]--;
				}
			}
		}
		
		
		System.out.print(x+" ");
		System.out.println(y);
		
		
	}
}
