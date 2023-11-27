import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {

    public static class Pair{
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }
    }

    static int[][] arr;
    static int n, m;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 그림의 갯수
        int count = 0;
        // 그림의 최대 넓이
        int resultsize = 0;

        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(visited[i][j] == false && arr[i][j] == 1) {
                    visited[i][j] = true;
                    int size = 0;
                    count++;
                    q.add(new Pair(i,j));

                    while(!q.isEmpty()) {
                        Pair cur = q.poll();
                        int y = cur.getY();
                        int x = cur.getX();

                        size++;

                        for(int k=0;k<4;k++) {
                            int ny = y + dy[k];
                            int nx = x + dx[k];
                            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                                continue;
                            }
                            else if(arr[ny][nx] == 1 && visited[ny][nx] == false) {
                                visited[ny][nx] = true;
                                q.add(new Pair(ny,nx));
                            }
                        }
                    }
                    resultsize = Math.max(resultsize, size);
                }
            }
        }
        System.out.println(count);
        System.out.println(resultsize);
    }
}