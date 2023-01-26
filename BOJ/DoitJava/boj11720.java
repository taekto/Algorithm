package DoitJava;

import java.util.Scanner;

public class boj11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String data = sc.next();
		
		// 결과값을 집어 넣을 result 선언
		int result = 0;
		
		char[] cdata = data.toCharArray();
		
		for(int i=0;i<cdata.length;i++) {
			result += cdata[i] - '0';
		}
		
		System.out.println(result);
		
		String sNum = "1234"; // string형 변수
		int i1 = Integer.parseInt(sNum);
		int i2 = Integer.valueOf(sNum);
		double d1 = Double.parseDouble(sNum);
		double d2 = Double.valueOf(sNum);
		float f1 = Float.parseFloat(sNum);
		float f2 = Float.valueOf(sNum);
		long l1 = Long.parseLong(sNum);
		long l2 = Long.valueOf(sNum);
		short s1 = Short.parseShort(sNum);
		short s2 = Short.valueOf(sNum);
		
	}

}
