import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테케 T 주어짐
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			// 각 테스트 케이스의 첫 번째 줄에는 두 정수 H, W (2 ≤ H, W ≤ 20) 이 공백으로 구분되어 주어진다.
			// 이는 게임 맵의 높이가 H, 너비가 W임을 나타낸다.
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] map = new char[H][W];
			// 전차의 초기 위치
			int trainy = -1;
			int trainx = -1;
			
			// 맵에 값 넣기
			for(int i=0;i<H;i++) {
				String str = sc.next();
				for(int j=0;j<W;j++) {
					map[i][j] = str.charAt(j);
					if(str.charAt(j) == 'v' || str.charAt(j) == '^' || str.charAt(j) == '<' || str.charAt(j) == '>' ) {
						trainy = i;
						trainx = j;
					}
				}
			}
			
//			System.out.println(Arrays.toString(map[0]));
//			System.out.println(Arrays.toString(map[1]));
//			System.out.println(Arrays.toString(map[2]));
			
//			System.out.println(trainy);
//			System.out.println(trainx);
			
			// 사용자가 넣을 입력을 나타내는 정수 N 정의
			int N = sc.nextInt();
			// 길이가 N인 명령이 주어짐
			String command = sc.next();
			for(int c=0;c<command.length();c++) {
				if(command.charAt(c) == 'U') {
					map[trainy][trainx] = '^';
					if(trainy-1 >= 0 && map[trainy-1][trainx] == '.') {
						char temp = map[trainy][trainx];
						map[trainy][trainx] = '.';
						trainy -=1;
						map[trainy][trainx] = temp;
					}
				}
				else if(command.charAt(c) == 'D') {
					map[trainy][trainx] = 'v';
					if(trainy+1 < H && map[trainy+1][trainx] == '.') {
						char temp = map[trainy][trainx];
						map[trainy][trainx] = '.';
						trainy +=1;
						map[trainy][trainx] = temp;
					}
				}
				else if(command.charAt(c) == 'L') {
					map[trainy][trainx] = '<';
					if(trainx-1 >= 0 && map[trainy][trainx-1] == '.') {
						char temp = map[trainy][trainx];
						map[trainy][trainx] = '.';
						trainx -=1;
						map[trainy][trainx] = temp;
					}
				}
				else if(command.charAt(c) == 'R') {
					map[trainy][trainx] = '>';
					if(trainx+1 < W && map[trainy][trainx+1] == '.') {
						char temp = map[trainy][trainx];
						map[trainy][trainx] = '.';
						trainx +=1;
						map[trainy][trainx] = temp;
					}
				}
				else if(command.charAt(c) == 'S') {
					if(map[trainy][trainx] == '^') {
						int index = 1;
						while(trainy - index >= 0 && map[trainy-index][trainx] != '#') {
							if(map[trainy-index][trainx] == '*') {
								map[trainy-index][trainx] = '.';
								break;
							}
							else if(map[trainy-index][trainx] == '-' || map[trainy-index][trainx] == '.') {
								index++;
								continue;
							}
						}
					}
					else if(map[trainy][trainx] == 'v') {
						int index = 1;
						while(trainy + index < H && map[trainy+index][trainx] != '#') {
							if(map[trainy+index][trainx] == '*') {
								map[trainy+index][trainx] = '.';
								break;
							}
							else if(map[trainy+index][trainx] == '-' || map[trainy+index][trainx] == '.') {
								index++;
								continue;
							}
						}
					}
					else if(map[trainy][trainx] == '<') {
						int index = 1;
						while(trainx - index >= 0 && map[trainy][trainx-index] != '#') {
							if(map[trainy][trainx-index] == '*') {
								map[trainy][trainx-index] = '.';
								break;
							}
							else if(map[trainy][trainx-index] == '-' || map[trainy][trainx-index] == '.') {
								index++;
								continue;
							}
						}
					}
					else if(map[trainy][trainx] == '>') {
						int index = 1;
						while(trainx + index < W && map[trainy][trainx+index] != '#') {
							if(map[trainy][trainx+index] == '*') {
								map[trainy][trainx+index] = '.';
								break;
							}
							else if(map[trainy][trainx+index] == '-' || map[trainy][trainx+index] == '.') {
								index++;
								continue;
							}
						}
					}
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
