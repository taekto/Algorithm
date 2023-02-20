package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_2309_일곱_난쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> list = new ArrayList<>();
		List<Integer> data = new ArrayList<>();
		for(int i=0;i<9;i++) {
			list.add(sc.nextInt());
		}
		
		outer :for(int a=0;a<list.size();a++) {
			for(int b=0;b<list.size();b++) {
				if(b != a) {
					for(int c=0;c<list.size();c++) {
						if(c != b && c != a) {
							for(int d=0;d<list.size();d++) {
								if(d != a && d != b && d != c) {
									for(int e=0;e<list.size();e++) {
										if(e != a && e != b && e != c && e != d) {
											for(int f=0;f<list.size();f++) {
												if(f != a && f != b && f != c && f != d && f != e) {
													for(int g=0;g<list.size();g++) {
														if(g != a && g != b && g != c && g != d && g != e && g != f) {
															int result = list.get(a) + list.get(b) + list.get(c) + list.get(d) + list.get(e) + list.get(f) + list.get(g);
															if(result == 100) {
																data.add(list.get(a));
																data.add(list.get(b));
																data.add(list.get(c));
																data.add(list.get(d));
																data.add(list.get(e));
																data.add(list.get(f));
																data.add(list.get(g));
																break outer;
															}
														}
													}	
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		data.sort(null);
		for(int i=0;i<7;i++) {
			System.out.println(data.get(i));
		}
		
	}
	

}
