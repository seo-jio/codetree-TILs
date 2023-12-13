import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M, max;
    static int[][] grid;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;

        grid = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                cal(i, j);
            }
        }

        System.out.println(max);
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static void cal(int x, int y) {
        // System.out.println("==================");
        // System.out.println("sx : " + sx + ", sy : " + sy);
        
        for(int d=0; d<4; d++) {
            int sum = grid[x][y];
            
            int nx1 = x + dx[d];
            int ny1 = y + dy[d];

            int nx2 = x + dx[(d+1) % 4];
            int ny2 = y + dy[(d+1) % 4];

            if(inRange(nx1, ny1) && inRange(nx2, ny2)) {
                sum += (grid[nx1][ny1] + grid[nx2][ny2]);
            }

            max = Integer.max(max, sum);

            sum = grid[x][y];
            int nx = x;
            int ny = y;
            for(int i=0; i<2; i++) {
                nx += dx[d];
                ny += dy[d];

                if(!inRange(nx, ny)) {
                    break;
                }

                sum += grid[nx][ny];
            }

            max = Integer.max(max, sum);
        }
    }
}