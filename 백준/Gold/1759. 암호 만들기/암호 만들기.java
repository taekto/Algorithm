import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static int L, C;
	public static String[] arr;
	public static boolean[] visited;
	public static List<String> list = new ArrayList<>();
	public static List<String> resultlist = new ArrayList<>();
	public static List<String> temp = new ArrayList<>();
	
	
	public static void dfs(int count, int idx) {
		if(count == L) {
			
			if(check(arr)) {
				for(int i=0;i<arr.length;i++) {
					System.out.print(arr[i]);
				}
				System.out.println();
			}
			return;
		}
		
		
		for(int i=idx;i<C;i++) {
			arr[count] = list.get(i);
			dfs(count+1,i+1);
		}
	}
	
	public static boolean check(String[] arr) { 
		
		int mo = 0;
		int ja = 0;
		for(String tmp : arr) {
			if(tmp.equals("a") || tmp.equals("e") || tmp.equals("i") || tmp.equals("o") || tmp.equals("u")) {
				mo++;
			}
			else {
				ja++;
			}
		}
		if(mo >= 1 && ja>= 2) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		arr = new String[L];
		String str = "aeiou";
		visited = new boolean[C];
		for(int i=0;i<C;i++) {
			list.add(sc.next());
		}
		for(int i=0;i<L;i++) {
			temp.add("");
		}
		
		list.sort(null);
		dfs(0,0);
	}
}
