package D3;

import java.util.Scanner;

public class swea_6019_taekto {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			double D = sc.nextDouble();
			double A = sc.nextDouble();
			double B = sc.nextDouble();
			double F = sc.nextDouble();
			
			double second = D/(A+B);
			
			System.out.println("#"+i+" "+F*second);
			
			
		}
		
		
	}

}
