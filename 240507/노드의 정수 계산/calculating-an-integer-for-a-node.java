import java.util.*;
import java.io.*;

public class Main {
    static int[] dp, weights;
    static boolean[] visited;
    static int N;
    static List<Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        weights = new int[N+1];
        visited = new boolean[N+1];

        edges = new List[N+1];
        for(int i=0; i<N+1; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            
            int cur = 2 + i;
            weights[cur] = (t == 1) ? a : -a;

            edges[p].add(cur);
        }

        dfs(1);

        System.out.println(dp[1]);
    }

    private static void dfs(int cur) {
        for(int i=0; i<edges[cur].size(); i++) {
            int next = edges[cur].get(i);

            if(visited[next]) {
                continue;
            }

            visited[next] = true;
            dfs(next);
        }

        int sum = weights[cur];
        for(int i=0; i<edges[cur].size(); i++) {
            int next = edges[cur].get(i);

            if(dp[next] < 0) { 
                continue;
            }

            sum += dp[next];
        }

        dp[cur] = sum;
    }
}