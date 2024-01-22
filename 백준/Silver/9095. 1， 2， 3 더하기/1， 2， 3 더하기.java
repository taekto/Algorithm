import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    static int[] arr = new int[20];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for(int i=4;i<=11;i++) {
            arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
        }

        for(int i=0;i<T;i++) {
            int n = sc.nextInt();
            System.out.println(arr[n]);
        }

    }
}