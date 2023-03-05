import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 주사위의 갯수 N
		int N = sc.nextInt();
		
		int sumA = 0;
		int sumB = 0;
		int sumC = 0;
		int sumD = 0;
		int sumE = 0;
		int sumF = 0;
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int E = sc.nextInt();
		int F = sc.nextInt();
		sumA += dice(A,A,B,C,D,E,F);
		sumB += dice(B,A,B,C,D,E,F);
		sumC += dice(C,A,B,C,D,E,F);
		sumD += dice(D,A,B,C,D,E,F);
		sumE += dice(E,A,B,C,D,E,F);
		sumF += dice(F,A,B,C,D,E,F);
		int startA = ground(A,A,B,C,D,E,F);
		int startB = ground(B,A,B,C,D,E,F);
		int startC = ground(C,A,B,C,D,E,F);
		int startD = ground(D,A,B,C,D,E,F);
		int startE = ground(E,A,B,C,D,E,F);
		int startF = ground(F,A,B,C,D,E,F);
		
		for(int i=1;i<N;i++) {

			
			A = sc.nextInt();
			B = sc.nextInt();
			C = sc.nextInt();
			D = sc.nextInt();
			E = sc.nextInt();
			F = sc.nextInt();
			sumA += dice(startA,A,B,C,D,E,F);
			sumB += dice(startB,A,B,C,D,E,F);
			sumC += dice(startC,A,B,C,D,E,F);
			sumD += dice(startD,A,B,C,D,E,F);
			sumE += dice(startE,A,B,C,D,E,F);
			sumF += dice(startF,A,B,C,D,E,F);
			startA = ground(startA,A,B,C,D,E,F);
			startB = ground(startB,A,B,C,D,E,F);
			startC = ground(startC,A,B,C,D,E,F);
			startD = ground(startD,A,B,C,D,E,F);
			startE = ground(startE,A,B,C,D,E,F);
			startF = ground(startF,A,B,C,D,E,F);

		}
		List<Integer> result = new ArrayList<>();
		result.add(sumA);
		result.add(sumB);
		result.add(sumC);
		result.add(sumD);
		result.add(sumE);
		result.add(sumF);
		result.sort(null);
		System.out.println(result.get(result.size()-1));
	}
	public static int dice(int ground, int A, int B, int C, int D, int E, int F) {
		int sum = 0;
		if(ground == A) {
			sum += Math.max(Math.max(B, C), Math.max(D, E));
			ground = F;
		}
		else if(ground == B) {
			sum += Math.max(Math.max(A, C), Math.max(E, F));
			ground = D;
		}
		else if(ground == C) {
			sum += Math.max(Math.max(A, B), Math.max(D, F));
			ground = E;
		}
		else if(ground == D) {
			sum += Math.max(Math.max(A, F), Math.max(C, E));
			ground = B;
		}
		else if(ground == E) {
			sum += Math.max(Math.max(A, F), Math.max(B, D));
			ground = C;
		}
		else if(ground == F) {
			sum += Math.max(Math.max(B, D), Math.max(C, E));
			ground = A;
		}
		return sum;
	}
	
	public static int ground(int ground,int A, int B, int C, int D, int E, int F) {
		if(ground == A) {
			ground = F;
		}
		else if(ground == B) {
			ground = D;
		}
		else if(ground == C) {
			ground = E;
		}
		else if(ground == D) {
			ground = B;
		}
		else if(ground == E) {
			ground = C;
		}
		else if(ground == F) {
			ground = A;
		}
		return ground;
	}
}
