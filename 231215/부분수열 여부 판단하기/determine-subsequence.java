import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(isPossible());
    }

    private static String isPossible() {
        int a=0;
        for(int b=0; b<M; b++) {
            while(a<N && A[a] != B[b]) {
                // System.out.println("B : " + B[b] + ", A : " + A[a]);
                a++;
            }

            if(a == N) {
                return "No";
            }

            a++;
        }


        return "Yes";
    }
}