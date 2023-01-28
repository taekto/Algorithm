import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String data = sc.next();
		
		// 결과값을 집어 넣을 result 선언
		int result = 0;
		
		for(int i=0;i<data.length();i++) {
			result += data.charAt(i) - '0';
		}
		System.out.println(result);
		
	}

}