import java.util.*;
import java.io.*;

public class Solution {

    int d[];
    int n;
    int leftIndex;
    int rightIndex;
    int paidCustomers;
    int max;

    Solution(int d[], int n){
        this.d = d;
        this.n = n;
        leftIndex = 0;
        rightIndex = n - 1;
        paidCustomers = 0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[] d = new int[n];
            for(int j=0;j<n;j++){
                d[j] = in.nextInt();
            }
            Solution solution = new Solution(d,n);
            solution.maxPaidCustomers();
            System.out.println("Case #" + i + ": " + solution.paidCustomers);
        }
    }

    private void maxPaidCustomers() {
        while(leftIndex<=rightIndex){
            serve();
        }
    }


    private void serve() {
        if(d[leftIndex]<d[rightIndex]){
            serveLeftIndex();
        }else{
            serveRightIndex();
        }
    }

    private void serveLeftIndex(){
        if(d[leftIndex]>=max){
            max = d[leftIndex];
            paidCustomers++;
        }
        leftIndex++;
    }

    private void serveRightIndex(){
        if(d[rightIndex]>=max){
            max = d[rightIndex];
            paidCustomers++;
        }
        rightIndex--;
    }

}
