package D3;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution_1230_암호문3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테케는 10번
		for(int i=1;i<=10;i++) {
			// 링크드리스트 정의
			LinkedList<Integer> linkedlist = new LinkedList<>();
			
			// 암호문 길이 N
			int N = sc.nextInt();
			// 원본값 채워넣기
			for(int j=0;j<N;j++) {
				linkedlist.add(sc.nextInt());
			}
			// 명령어의 갯수 M
			int M = sc.nextInt();
			for(int j=0;j<M;j++) {
				// 명령어 입력받기
				String cmd = sc.next();
				if(cmd.equals("I")) {
					// 1. I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.[ ex) I 3 2 123152 487651 ]
					int x = sc.nextInt();
					int y = sc.nextInt();
					for(int k=0;k<y;k++) {
						int s = sc.nextInt();
						linkedlist.add(x, s);
						x++;
					}
				}
				else if(cmd.equals("D")) {
					// 2. D(삭제) x, y : 앞에서부터 x의 위치 바로 다음부터 y개의 숫자를 삭제한다.[ ex) D 4 4 ]
					int x = sc.nextInt();
					int y = sc.nextInt();
					for(int k=0;k<y;k++) {
						linkedlist.remove(x);
					}
				}
				else if(cmd.equals("A")) {
					// 3. A(추가) y, s : 암호문의 맨 뒤에 y개의 숫자를 덧붙인다. s는 덧붙일 숫자들이다. [ ex) A 2 421257 796813 ]
					int y = sc.nextInt();
					for(int k=0;k<y;k++) {
						int s = sc.nextInt();
						linkedlist.add(s);
					}
				}
			}
			System.out.print("#"+i+" ");
			for(int j=0;j<10;j++) {
				System.out.print(linkedlist.get(j)+" ");
			}
			System.out.println();
		}
		
		
	}
}
