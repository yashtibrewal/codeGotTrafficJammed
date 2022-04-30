import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    // returns the length of the integer
    public static int length(int x){
        String temp = x+"";
        return temp.length();
    }

    public static void multiplyByTen(int X[], int i){
        X[i] = X[i]*10;
    }

    public static int solve(int X[], int N){
        int counter = 0;
        for(int i=0;i<N-1;i++){
            if(X[i]>=X[i+1]){
                while(X[i]>=X[i+1]){
                    multiplyByTen(X,i+1);
                    counter++;
                }
            }
        }
        return counter;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int T = scanner.nextInt();
        int counter = 1;
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] X = new int[N];
            for(int j=0;j<N;j++){
                X[j] = scanner.nextInt();
            }
            System.out.println("Case #"+counter+":"+solve(X, N));
            counter++;
        }
    }

}