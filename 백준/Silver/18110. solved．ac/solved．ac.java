import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Double result = 0d;

        List<Integer> arr = new ArrayList<>();

        for(int i=0;i<N;i++) {
            int a = Integer.parseInt(br.readLine());
            arr.add(a);
            result += a;
        }

        Collections.sort(arr);

        Long num = Math.round(N*0.15);

        for(int i=0;i<=num-1;i++) {
            result -= arr.get(i);
        }

        for(int i=arr.size()-1;i>=arr.size()-num;i--) {
            result -= arr.get(i);
        }

        System.out.println(Math.round(result/(N-num*2)));


    }
}