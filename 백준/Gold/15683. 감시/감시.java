import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int y;
        int x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M;
    static int[][] map;
    static List<Node> list = new ArrayList<>();
    static int[] arr;
    static int[][] copy;
    static int ans = Integer.MAX_VALUE;

    static void func(int depth) {
        if(depth == list.size()) {
            copy = new int[N][M];
            for(int i=0;i<N;i++) {
                copy[i] = Arrays.copyOf(map[i], map[i].length);
            }

            for(int i=0;i<list.size();i++) {
                Node cur = list.get(i);
                if(map[cur.y][cur.x] == 1) {
                    cctv1(cur.y, cur.x, arr[i]);
                }
                else if(map[cur.y][cur.x] == 2) {
                    cctv2(cur.y, cur.x, arr[i]);
                }
                else if(map[cur.y][cur.x] == 3) {
                    cctv3(cur.y, cur.x, arr[i]);
                }
                else if(map[cur.y][cur.x] == 4) {
                    cctv4(cur.y, cur.x, arr[i]);
                }
                else if(map[cur.y][cur.x] == 5) {
                    cctv5(cur.y, cur.x);
                }
            }

            int count = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(copy[i][j] == 0) count++;
                    else continue;
                }
            }
            ans = Math.min(ans, count);
            return;
        }

        for(int i=0;i<4;i++) {
            arr[depth] = i;
            func(depth+1);
        }

    }

    static void cctv1(int y, int x, int direction) {
        if(direction == 0) {
            int ny = y;
            int nx = x+1;
            while(true) {
                if(nx >= M || map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    nx+=1;
                    continue;
                }
                copy[ny][nx] = 7;
                nx+=1;
            }
        }
        else if(direction == 1) {
            int ny = y+1;
            int nx = x;
            while(true) {
                if(ny >= N ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    ny+=1;
                    continue;
                }
                copy[ny][nx] = 7;
                ny+=1;
            }
        }
        else if(direction == 2) {
            int ny = y;
            int nx = x-1;
            while(true) {
                if(nx < 0 ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    nx-=1;
                    continue;
                }
                copy[ny][nx] = 7;
                nx-=1;
            }
        }
        else if(direction == 3) {
            int ny = y-1;
            int nx = x;
            while(true) {
                if(ny < 0 ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    ny-=1;
                    continue;
                }
                copy[ny][nx] = 7;
                ny-=1;
            }
        }
    }

    static void cctv2(int y, int x, int direction) {
        direction = direction%2;
        if(direction == 0) {
            int ny = y;
            int nx = x+1;
            while(true) {
                if(nx >= M || map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    nx+=1;
                    continue;
                }
                copy[ny][nx] = 7;
                nx+=1;
            }

            ny = y;
            nx = x-1;
            while(true) {
                if(nx < 0 ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    nx-=1;
                    continue;
                }
                copy[ny][nx] = 7;
                nx-=1;
            }

        }
        else if(direction == 1) {
            int ny = y+1;
            int nx = x;
            while(true) {
                if(ny >= N ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    ny+=1;
                    continue;
                }
                copy[ny][nx] = 7;
                ny+=1;
            }

            ny = y-1;
            nx = x;
            while(true) {
                if(ny < 0 ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    ny-=1;
                    continue;
                }
                copy[ny][nx] = 7;
                ny-=1;
            }
        }
    }

    static void cctv3(int y, int x, int direction) {
        if(direction == 0) {
            int ny = y;
            int nx = x+1;
            while(true) {
                if(nx >= M ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    nx+=1;
                    continue;
                }
                copy[ny][nx] = 7;
                nx+=1;
            }

            ny = y-1;
            nx = x;
            while(true) {
                if(ny < 0 ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    ny-=1;
                    continue;
                }
                copy[ny][nx] = 7;
                ny-=1;
            }

        }
        else if(direction == 1) {
            int ny = y+1;
            int nx = x;
            while(true) {
                if(ny >= N ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    ny+=1;
                    continue;
                }
                copy[ny][nx] = 7;
                ny+=1;
            }

            ny = y;
            nx = x+1;
            while(true) {
                if(nx >= M ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    nx+=1;
                    continue;
                }
                copy[ny][nx] = 7;
                nx+=1;
            }
        }
        else if(direction == 2) {
            int ny = y+1;
            int nx = x;
            while(true) {
                if(ny >= N ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    ny+=1;
                    continue;
                }
                copy[ny][nx] = 7;
                ny+=1;
            }

            ny = y;
            nx = x-1;
            while(true) {
                if(nx < 0 ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    nx-=1;
                    continue;
                }
                copy[ny][nx] = 7;
                nx-=1;
            }
        }
        else if(direction == 3) {
            int ny = y-1;
            int nx = x;
            while(true) {
                if(ny < 0 ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    ny-=1;
                    continue;
                }
                copy[ny][nx] = 7;
                ny-=1;
            }

            ny = y;
            nx = x-1;
            while(true) {
                if(nx < 0 ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    nx-=1;
                    continue;
                }
                copy[ny][nx] = 7;
                nx-=1;
            }
        }
    }

    static void cctv4(int y, int x, int direction) {
        if(direction == 0) {
            int ny = y;
            int nx = x+1;
            while(true) {
                if(nx >= M ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    nx+=1;
                    continue;
                }
                copy[ny][nx] = 7;
                nx+=1;
            }

            ny = y-1;
            nx = x;
            while(true) {
                if(ny < 0 ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    ny-=1;
                    continue;
                }
                copy[ny][nx] = 7;
                ny-=1;
            }

            ny = y;
            nx = x-1;
            while(true) {
                if(nx < 0 ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    nx-=1;
                    continue;
                }
                copy[ny][nx] = 7;
                nx-=1;
            }

        }
        else if(direction == 1) {
            int ny = y+1;
            int nx = x;
            while(true) {
                if(ny >= N ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    ny+=1;
                    continue;
                }
                copy[ny][nx] = 7;
                ny+=1;
            }

            ny = y;
            nx = x+1;
            while(true) {
                if(nx >= M ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    nx+=1;
                    continue;
                }
                copy[ny][nx] = 7;
                nx+=1;
            }

            ny = y-1;
            nx = x;
            while(true) {
                if(ny < 0 ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    ny-=1;
                    continue;
                }
                copy[ny][nx] = 7;
                ny-=1;
            }
        }

        else if(direction == 2) {
            int ny = y+1;
            int nx = x;
            while(true) {
                if(ny >= N ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    ny+=1;
                    continue;
                }
                copy[ny][nx] = 7;
                ny+=1;
            }

            ny = y;
            nx = x+1;
            while(true) {
                if(nx >= M ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    nx+=1;
                    continue;
                }
                copy[ny][nx] = 7;
                nx+=1;
            }

            ny = y;
            nx = x-1;
            while(true) {
                if(nx < 0 ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    nx-=1;
                    continue;
                }
                copy[ny][nx] = 7;
                nx-=1;
            }
        }
        else if(direction == 3) {
            int ny = y+1;
            int nx = x;
            while(true) {
                if(ny >= N ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    ny+=1;
                    continue;
                }
                copy[ny][nx] = 7;
                ny+=1;
            }

            ny = y;
            nx = x-1;
            while(true) {
                if(nx < 0 ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    nx-=1;
                    continue;
                }
                copy[ny][nx] = 7;
                nx-=1;
            }

            ny = y-1;
            nx = x;
            while(true) {
                if(ny < 0 ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    ny-=1;
                    continue;
                }
                copy[ny][nx] = 7;
                ny-=1;
            }
        }
    }

    static void cctv5(int y, int x) {
            int ny = y;
            int nx = x+1;
            while(true) {
                if(nx >= M ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    nx+=1;
                    continue;
                }
                copy[ny][nx] = 7;
                nx+=1;
            }
            ny = y+1;
            nx = x;
            while(true) {
                if(ny >= N ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    ny+=1;
                    continue;
                }
                copy[ny][nx] = 7;
                ny+=1;
            }

            ny = y;
            nx = x-1;
            while(true) {
                if(nx < 0 ||  map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    nx-=1;
                    continue;
                }
                copy[ny][nx] = 7;
                nx-=1;
            }

            ny = y-1;
            nx = x;
            while(true) {
                if(ny < 0 || map[ny][nx] == 6) break;
                if(map[ny][nx] != 0) {
                    ny-=1;
                    continue;
                }
                copy[ny][nx] = 7;
                ny-=1;
            }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if(a != 0 && a != 6) {
                    list.add(new Node(i,j));
                }
            }
        }

        arr = new int[list.size()];
        func(0);
        System.out.println(ans);
    }
}