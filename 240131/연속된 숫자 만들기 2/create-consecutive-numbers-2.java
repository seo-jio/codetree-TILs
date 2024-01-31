import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int[] nums = new int[3];
        for(int i=0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        
        int stick = 0;
        for(int i=0; i<nums.length -1; i++) {
            if(nums[i+1] - nums[i] == 1) {
                stick++;
            }
        }

        if(stick == 2) {
            System.out.println(0);
        } else if(stick == 1) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}