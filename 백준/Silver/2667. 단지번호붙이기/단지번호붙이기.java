import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Node {
    private int y;
    private int x;
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public Node(int y, int x) {
        super();
        this.y = y;
        this.x = x;
    }
    
}


public class Main {
    public static int N;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};
    
    
    public static int bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        int count = 0;
        q.offer(new Node(y, x));
        visited[y][x] = true;
        count++;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            y = node.getY();
            x = node.getX();
            for(int i=0;i<4;i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || nx>=N || ny>=N) continue;
                if(arr[ny][nx] == 1 && visited[ny][nx] == false) {
                    visited[ny][nx] = true;
                    q.offer(new Node(ny,nx));
                    count++;
                }
            }
        }
        return count;
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++) {
            String str = sc.next();
            for(int j=0;j<N;j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int num = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    list.add(bfs(i,j));
                    num++;
                }
            }
        }
        System.out.println(num);
        list.sort(null);
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
        
    }
}