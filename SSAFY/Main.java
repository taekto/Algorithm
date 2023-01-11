package ch05.sec11;

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a == 1 && b == 2) {
			System.out.println("B");
		} 
		else if(a == 1 && b == 3) {
			System.out.println("A");
		}
		else if(a == 2 && b == 3) {
			System.out.println("B");
		}
		else if(a == 2 && b == 1) {
			System.out.println("A");
		}
		else if(a == 3 && b == 1) {
			System.out.println("B");
		} 
		else if(a == 3 && b == 2) {
			System.out.println("A");
		}
		

	}
}
