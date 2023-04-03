import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static int N;
	public static int[][] arr;
	public static List<List<Integer>> wormholey;
	public static List<List<Integer>> wormholex;
	public static int result = 0;
	public static int[] dy = {0, 1, 0, -1};
	public static int[] dx = {1, 0, -1, 0};
	
	
	public static void pinball(int starty, int startx, int startgear) {
		
		int y = starty+dy[startgear];
		int x = startx+dx[startgear];
		int gear = startgear;
		int score = 0;

		while(true) {
//			System.out.println("startx : "+startx+" starty : "+starty);
//			System.out.println(startgear);
//			System.out.println("x : "+x+" y : "+y);
//			System.out.println("gear : "+gear);
			
			// 벽에 부딪히는거
			if(y < 0 || x < 0 || x >= N || y >= N) {
				if(gear == 0) {
					score += 1;
					gear = 2;
					x -= 1;
				}
				else if(gear == 1) {
					score += 1;
					gear = 3;
					y -= 1;
				}
				else if(gear == 2) {
					score += 1;
					gear = 0;
					x += 1;
				}
				else if(gear == 3) {
					score += 1;
					gear = 1;
					y += 1;
				}
			} else {
				if(x == startx && y == starty) {
					break;
				}
				else if(arr[y][x] == -1) {
					break;
				}
				else if(arr[y][x] == 0) {
					y += dy[gear];
					x += dx[gear];
				}
				else if(arr[y][x] == 1) {
					if(gear == 0) {
						score += 1;
						gear = 2;
						x -= 1;
					}
					else if(gear == 1) {
						score += 1;
						gear = 0;
						x += 1;
					}
					else if(gear == 2) {
						score += 1;
						gear = 3;
						y -= 1;
					}
					else if(gear == 3) {
						score += 1;
						gear = 1;
						y += 1;
					}
				}
				else if(arr[y][x] == 2) {
					if(gear == 0) {
						score += 1;
						gear = 2;
						x -= 1;
					}
					else if(gear == 1) {
						score += 1;
						gear = 3;
						y -= 1;
					}
					else if(gear == 2) {
						score += 1;
						gear = 1;
						y +=1;
					}
					else if(gear == 3) {
						score += 1;
						gear = 0;
						x += 1;
					}
				}
				else if(arr[y][x] == 3) {
					if(gear == 0) {
						score += 1;
						gear = 1;
						y += 1;
					}
					else if(gear == 1) {
						score += 1;
						gear = 3;
						y -= 1;
					}
					else if(gear == 2) {
						score += 1;
						gear = 0;
						x += 1;
					}
					else if(gear == 3) {
						score += 1;
						gear = 2;
						x -= 1;
					}
				}
				else if(arr[y][x] == 4) {
					if(gear == 0) {
						score += 1;
						gear = 3;
						y -= 1;
					}
					else if(gear == 1) {
						score += 1;
						gear = 2;
						x -= 1;
					}
					else if(gear == 2) {
						score += 1;
						gear = 0;
						x += 1;
					}
					else if(gear == 3) {
						score += 1;
						gear = 1;
						y += 1;
					}
				}
				else if(arr[y][x] == 5) {
					if(gear == 0) {
						score += 1;
						gear = 2;
						x -= 1;
					}
					else if(gear == 1) {
						score += 1;
						gear = 3;
						y -= 1;
					}
					else if(gear == 2) {
						score += 1;
						gear = 0;
						x += 1;
					}
					else if(gear == 3) {
						score += 1;
						gear = 1;
						y += 1;
					}
				}
				else if(arr[y][x] >= 6) {
					int temp = arr[y][x];
					for(int i=0;i<wormholey.get(temp).size();i++) {
						if(wormholey.get(temp).get(i) != y || wormholex.get(temp).get(i) != x) {
//							System.out.println("무한루프도는거같은데");
//							System.out.println("웜홀에서의 x"+x+"웜홀에서의 y"+y);
//							System.out.println(wormholey);
//							System.out.println(wormholex);
//							System.out.println(wormholey.get(arr[y][x]).get(i));
//							System.out.println(wormholex.get(arr[y][x]).get(i));
//							System.out.println("출력되는데 왜 안됨?ㅋㅋ");
//							System.out.println(arr[y][x]);
							y = wormholey.get(temp).get(i);
							x = wormholex.get(temp).get(i);
							y += dy[gear];
							x += dx[gear];
							break;
						}
					}
				}
			}
		}
		result = Math.max(result, score);
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 T
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			// N
			N = sc.nextInt();
			
			// 핀볼 맵
			arr = new int[N][N];
			
			// 웜홀의 x좌표, y좌표 담을 공간 저장!
			wormholey = new ArrayList<>();
			wormholex = new ArrayList<>();
			
			// 초기화 하기
			for(int i=0;i<=10;i++) {
				wormholey.add(new ArrayList<>());
				wormholex.add(new ArrayList<>());
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int a = sc.nextInt();
					arr[i][j] = a;
					if(a > 5) {
						wormholey.get(a).add(i);
						wormholex.get(a).add(j);
					}
				}
			}
			
			
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j] == 0) {
						for(int k=0;k<4;k++) {
							pinball(i,j,k);
						}
					}
					else {
						continue;
					}
				}
			}
			
			System.out.println("#"+tc+" "+result);
			result = 0;
			
		}
	}
}