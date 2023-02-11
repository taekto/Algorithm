package D2;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class swea_1974_taekto {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			int[][] arr = new int[10][10];
			int xresult = 0;
			int yresult = 0;
			
			for(int j=1;j<=9;j++) {
				for(int k=1;k<=9;k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			
			for(int j=1;j<=9;j++) {
				HashSet<Integer> xfind = new HashSet<Integer>();
				for(int k=1;k<=9;k++) {
					xfind.add(arr[j][k]);
					
				}
				if(xfind.size() == 9) {
					xresult = 1;
				}
				else {
					xresult = 0;
					break;
				}
			}
			
			for(int j=1;j<=9;j++) {
				HashSet<Integer> yfind = new HashSet<Integer>();
				for(int k=1;k<=9;k++) {
					yfind.add(arr[k][j]);
					
				}
				if(yfind.size() == 9) {
					yresult = 1;
				}
				else {
					yresult = 0;
					break;
				}
			}
			
			
			HashSet<Integer> block1 = new HashSet<Integer>();
			
			for(int j=1;j<=3;j++) {
				for(int k=1;k<=3;k++) {
					block1.add(arr[j][k]);
				}
			}
			
			
			HashSet<Integer> block2 = new HashSet<Integer>();
			
			for(int j=1;j<=3;j++) {
				for(int k=4;k<=6;k++) {
					block2.add(arr[j][k]);
				}
			}
			
			HashSet<Integer> block3 = new HashSet<Integer>();
			
			for(int j=1;j<=3;j++) {
				for(int k=7;k<=9;k++) {
					block3.add(arr[j][k]);
				}
			}
			
			HashSet<Integer> block4 = new HashSet<Integer>();
			
			for(int j=4;j<=6;j++) {
				for(int k=1;k<=3;k++) {
					block4.add(arr[j][k]);
				}
			}
			
			HashSet<Integer> block5 = new HashSet<Integer>();
			
			for(int j=4;j<=6;j++) {
				for(int k=4;k<=6;k++) {
					block5.add(arr[j][k]);
				}
			}
			
			HashSet<Integer> block6 = new HashSet<Integer>();
			
			for(int j=4;j<=6;j++) {
				for(int k=7;k<=9;k++) {
					block6.add(arr[j][k]);
				}
			}
			
			HashSet<Integer> block7 = new HashSet<Integer>();
			
			for(int j=7;j<=9;j++) {
				for(int k=1;k<=3;k++) {
					block7.add(arr[j][k]);
				}
			}
			
			HashSet<Integer> block8 = new HashSet<Integer>();
			
			for(int j=7;j<=9;j++) {
				for(int k=4;k<=6;k++) {
					block8.add(arr[j][k]);
				}
			}
			
			HashSet<Integer> block9 = new HashSet<Integer>();
			
			for(int j=7;j<=9;j++) {
				for(int k=7;k<=9;k++) {
					block9.add(arr[j][k]);
				}
			}
			
			int result = 0;
			
			if(block1.size() == 9 & block2.size() == 9 & block3.size() == 9 & block4.size() == 9 & block5.size() == 9 & block6.size() == 9 & block7.size() == 9 & block8.size() == 9 & block9.size() == 9 & xresult == 1 & yresult == 1) {
				result = 1;
			} else {
				result = 0;
			}
			
			System.out.println("#"+i+" "+result);
			
			
			
		}
		
		
		

		
	}

}
