package D2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
 
public class swea_1959_taekto {
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int i=1;i<=T;i++) {
             
            int N = sc.nextInt();
            int M = sc.nextInt();
             
            List<Integer> Narr = new ArrayList<>();
            List<Integer> Marr = new ArrayList<>();
 
             
            for(int j=0;j<N;j++) {
                Narr.add(sc.nextInt());
            }
             
            for(int j=0;j<M;j++) {
                Marr.add(sc.nextInt());
            }
             
            List<Integer> result = new ArrayList<>();
             
            if(M > N) {
                for(int a=0;a<=M-N;a++) {
                    int data = 0;
                    for(int b=0;b<Narr.size();b++) {
                        data += Narr.get(b)*Marr.get(b);
                    }
                    Narr.add(0, 0);
                    result.add(data);
                }
            }
            else if(M < N) {
                for(int a=0;a<=N-M;a++) {
                    int data = 0;
                    for(int b=0;b<Marr.size();b++) {
                        data += Narr.get(b)*Marr.get(b);
                    }
                    Marr.add(0, 0);
                    result.add(data);
                }
                 
            }
            else {
                int data = 0;
                for(int a=0;a<M;a++) {
                    data += Narr.get(a)*Marr.get(a);
                }
                result.add(data);
            }
             
            result.sort(null);
             
            System.out.println("#"+i+" "+result.get(result.size()-1));
             
             
        }
         
    }
 
}
