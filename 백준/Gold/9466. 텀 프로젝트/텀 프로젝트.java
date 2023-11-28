import java.util.Scanner;

public class Main {
    static int[] arr;
    static int n;
    static int[] state;

    static final int NOT_VISITED = 0;
    static final int CYCLE_IN = -1;

    static void run(int x) {
        int cur = x;
        while (true) {
            state[cur] = x;
            cur = arr[cur];
            // 이번 방문에서 지나간 학생에 도달했을 경우
            if (state[cur] == x) {
                while (state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;
                    cur = arr[cur];
                }
                return;
            }
            // 이전 방문에서 지나간 학생에 도달했을 경우
            else if (state[cur] != 0)
                return;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            n = scanner.nextInt();
            arr = new int[n + 1];
            state = new int[n + 1];
            for (int i = 1; i <= n; i++)
                arr[i] = scanner.nextInt();

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (state[i] == NOT_VISITED)
                    run(i);
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (state[i] != CYCLE_IN)
                    cnt++;
            }
            System.out.println(cnt);
        }
    }
}